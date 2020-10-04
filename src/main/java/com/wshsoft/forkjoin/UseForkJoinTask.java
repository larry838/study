package com.wshsoft.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
 
 /**
  * 
  * @author Administrator
  *
  */
public class UseForkJoinTask extends RecursiveTask<Long>{
	private static final int THRESHORD = 2;
	private Integer start;
	private Integer end;
	public UseForkJoinTask(Integer start, Integer end) {
		super();
		this.start = start;
		this.end = end;
	}
 
	@Override
	protected Long compute() {
		long sum = 0;
		boolean canCompute = (end - start) <= THRESHORD;
		if(canCompute) {
			for(int i = start; i <= end; i++) {
				sum += i;
			}
		}else {
			int middle = (start + end) / 2;
			UseForkJoinTask leftTask = new UseForkJoinTask(start, middle);
			UseForkJoinTask rightTask  = new UseForkJoinTask(middle + 1, end);
			//执行拆分
			leftTask.fork();
			rightTask.fork();
			//执行结果合并
			Long leftResult = leftTask.join();
			Long rightResult = rightTask.join();
			sum = leftResult + rightResult;
		}
		return sum;
	}
 
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();
		final int max_size=10000000;
		UseForkJoinTask ufj = new UseForkJoinTask(0,max_size);
		Future<Long> submit = pool.submit(ufj);
		long end = System.currentTimeMillis();
		System.out.println(String.format("使用forkJoinTask执行的结果为：%s,使用的时间为：%s毫秒", submit.get(),end - start));
		
		start = System.currentTimeMillis();
		long sum = 0;
		for(int i = 0; i <= max_size; i++) {
			sum += i;
		}
		end = System.currentTimeMillis();
		System.out.println(String.format("使用普通的for循环执行的结果为：%s,使用的时间为：%s毫秒", sum,end - start));
	}
}