package com.wshsoft.single;

/**
 * ˫�����Ƶ���
 * @author Administrator
 *
 */
public class Singleton {
	
	private volatile static Singleton uniqueInstance;
	private Singleton(){
		
	}
	
    public static Singleton getUniqueInstance() {
    	//���ж϶����Ƿ�ʵ�ֹ���û��ʵ�����Ž����������
    	if(uniqueInstance==null){
    	//��������
    		synchronized (Singleton.class) {
    			if(uniqueInstance==null){
    				uniqueInstance= new Singleton();
    			}
				
			}
    	}
		return uniqueInstance;
	}
}
