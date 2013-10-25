/**
 * @package com.hitao.product
 * @title: Producer.java
 * @company: �����Ա�
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.product;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className: Producer
 * @description: TODO
 * @author: л��
 * @email: xiejian@hitao.com
 * @date 2013-9-6
 *
 */

public class Producer implements Runnable {
	
	private volatile boolean isRunning=true;
	private BlockingQueue<PCData> queue;//�ڴ滺����
	private static AtomicInteger count = new AtomicInteger();//������ ԭ�Ӳ���
	private static final int SLEEPTIME=1000;
	
	public Producer(BlockingQueue<PCData> queue) {
		this.queue=queue;
	}
	
	public void run(){
		PCData data=null;
		Random r=new Random();
		System.out.println("start producer id="+Thread.currentThread().getId());
		try {
			while (isRunning) {
				Thread.sleep(r.nextInt(SLEEPTIME));
				data=new PCData(count.incrementAndGet());//������������
				System.out.println(data+" is put into queue");
				if (!queue.offer(data,2,TimeUnit.SECONDS)) {//�ύ���ݵ���������
				   System.err.println("failed to put data: "+data);
				}
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
			// TODO: handle exception
		}
	}
	
	public void stop() {
		isRunning=false;
	}

}
