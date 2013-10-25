/**
 * @package com.hitao.proxy
 * @title: ProxyImpl.java
 * @company: 快乐淘宝
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.proxy;

/**
 * @className: ProxyImpl 接口实现类，即被代理类 
 * @description: TODO
 * @author: 谢建
 * @email: xiejian@hitao.com
 * @date 2013-10-14
 *
 */

public class ProxyImpl implements IProxy {
	
	 public void hello(String s){    
		         System.out.println("Hello, " + s);    
		     }    

	
}
