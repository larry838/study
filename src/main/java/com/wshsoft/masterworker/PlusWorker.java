/**
 * @package com.hitao.masterworker
 * @title: PlusWorker.java
 * @company: 快乐淘宝
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.masterworker;

import java.util.Map;
import java.util.Set;

/**
 * @className: PlusWorker
 * @description: TODO
 * @author: 谢建
 * @email: xiejian@hitao.com
 * @date 2013-9-6
 *
 */
//求立方和:   1*1*1+2*2*2+3*3*3 ..........

public class PlusWorker extends Worker {
	
    public Object handle(Object input) {
		Integer i=(Integer)input;
		return i*i*i;
	}

    public static void main(String[] args) {
		// TODO Auto-generated method stub
       Master m= new Master(new PlusWorker(), 5);//固定用5个线程处理
       
       for(int i=0;i<=100;i++)
    	   m.submit(i);
       m.execute();//开始计算
       int re=0;//最终计算结果
       Map<String, Object> resultMap=m.getResultMap();
       while (resultMap.size()>0||!m.isComplete()) {//等待计算
		Set<String>keys= resultMap.keySet();
		String key=null;
		for (String k:keys) {
			key=k;
			break;
		}
		Integer i=null;
		if(key!=null)
			i=(Integer)resultMap.get(key);
		if(i!=null) re+=i;
		if (key!=null) {
			resultMap.remove(key);
		}
	}
       System.out.println(re);
       
	}
}
