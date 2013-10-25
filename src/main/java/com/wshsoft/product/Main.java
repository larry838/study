/**
 * @package com.hitao.product
 * @title: Main.java
 * @company: 快乐淘宝
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @className: Main
 * @description: TODO
 * @author: 谢建
 * @email: xiejian@hitao.com
 * @date 2013-9-6
 *
 */

public class Main {
 
	public static void main(String[] args) throws InterruptedException{
		//建立缓存区
		BlockingQueue<PCData> queue=new LinkedBlockingQueue<PCData>(10);
		
		Producer producer1=new Producer(queue);
		Producer producer2=new Producer(queue);
		Producer producer3=new Producer(queue);
		
		Consumer consumer1=new Consumer(queue);
		Consumer consumer2=new Consumer(queue);
		Consumer consumer3=new Consumer(queue);
		
		ExecutorService service=Executors.newCachedThreadPool();//建立线程池
		
		service.execute(producer1);//运行生产者
		service.execute(producer2);
		service.execute(producer3);
		
		service.execute(consumer1);//运行消费者
		service.execute(consumer2);
		service.execute(consumer3);
		
		Thread.sleep(10*1000);
		
		producer1.stop();
		producer2.stop();
		producer3.stop();
		
		Thread.sleep(3000);
		
		service.shutdown();
		
	}
}
