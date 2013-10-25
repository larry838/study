/**
 * @package com.hitao.product
 * @title: Consumer.java
 * @company: 快乐淘宝
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.product;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @className: Consumer
 * @description: TODO
 * @author: 谢建
 * @email: xiejian@hitao.com
 * @date 2013-9-6
 *
 */

public class Consumer implements Runnable {

	private BlockingQueue<PCData> queue;//内存缓存区
	private static final int SLEEPTIME=1000;
	
	public Consumer(BlockingQueue<PCData> queue){
		this.queue=queue;
	}

	@Override
	public void run() {
		System.out.println("start consumer id="+Thread.currentThread().getId());
		
		Random r=new Random();
		try {
			while (true) {
				PCData data=queue.take();//提交任务
				if(null!=data){
					int re=data.getData()*data.getData();//计算平方
					System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(),data.getData(),re));
					Thread.sleep(r.nextInt(SLEEPTIME));
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

	}

}
