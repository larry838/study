package com.wshsoft.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        for(int i = 0; i < latch.getCount(); i++){
            new Thread(new MyThread(latch), "player"+i).start();
        }
        System.out.println("���ڵȴ��������׼����");
        latch.await();
        System.out.println("��ʼ��Ϸ");
    }
    
    private static class MyThread implements Runnable{
        private CountDownLatch latch ;

        public MyThread(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Random rand = new Random();
                int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//����1000��3000֮����������
                Thread.sleep(randomNum);
                System.out.println(Thread.currentThread().getName()+" �Ѿ�׼������, ��ʹ�õ�ʱ��Ϊ "+((double)randomNum/1000)+"s");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
