package com.wshsoft.single;

/**
 * 双锁机制单例
 * @author Administrator
 *
 */
public class Singleton {
	
	private volatile static Singleton uniqueInstance;
	private Singleton(){
		
	}
	
    public static Singleton getUniqueInstance() {
    	//先判断对象是否实现过，没有实例化才进入加锁代码
    	if(uniqueInstance==null){
    	//类对象加锁
    		synchronized (Singleton.class) {
    			if(uniqueInstance==null){
    				uniqueInstance= new Singleton();
    			}
				
			}
    	}
		return uniqueInstance;
	}
}
