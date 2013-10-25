/**
 * @package com.hitao.proxy
 * @title: DynamicProxyDemo.java
 * @company: �����Ա�
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.proxy;

import java.lang.reflect.Proxy;

/**
 * @className: DynamicProxyDemo
 * @description: TODO
 * @author: л��
 * @email: xiejian@hitao.com
 * @date 2013-10-14
 *
 */

public class DynamicProxyDemo {
	 public static void main(String[] args){  
		   
		         IProxy p = new ProxyImpl();    
		       ProxyHandler handler = new ProxyHandler(p);    
		       //������̬����     
		    IProxy  proxy = (IProxy)Proxy.newProxyInstance(IProxy.class.getClassLoader(), p.getClass().getInterfaces(), handler);    
		      proxy.hello("xiejian");    
		     }    

}
