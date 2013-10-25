/**
 * @package com.hitao.product
 * @title: Consumer.java
 * @company: �����Ա�
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
 * @author: л��
 * @email: xiejian@hitao.com
 * @date 2013-9-6
 *
 */

public class Consumer implements Runnable {

	private BlockingQueue<PCData> queue;//�ڴ滺����
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
				PCData data=queue.take();//�ύ����
				if(null!=data){
					int re=data.getData()*data.getData();//����ƽ��
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
