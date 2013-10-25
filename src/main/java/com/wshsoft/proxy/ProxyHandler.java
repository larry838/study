/**
 * @package com.hitao.proxy
 * @title: ProxyHandler.java
 * @company: �����Ա�
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @className: ProxyHandler ��̬��������
 * @description: TODO
 * @author: л��
 * @email: xiejian@hitao.com
 * @date 2013-10-14
 *
 */

public class ProxyHandler implements InvocationHandler {

	    //����ʵ����     
	private Object delegate;

	public ProxyHandler(Object obj) {
		delegate = obj;
	}

	/*
	 * <p>Title: invoke</p>
	 * <p>Description: </p>
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		       System.out.println("Before mothod:" + method);    
		     Object result = method.invoke(this.delegate, args);     
		      System.out.println("After mothod:" + method);    
		       return result; 
	}

}
