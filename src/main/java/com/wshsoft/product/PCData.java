/**
 * @package com.hitao.product
 * @title: PCData.java
 * @company: øÏ¿÷Ã‘±¶
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.product;

/**
 * @className: PCData
 * @description: TODO
 * @author: –ªΩ®
 * @email: xiejian@hitao.com
 * @date 2013-9-6
 *
 */

public class PCData {
	
	private final int intData;

	public PCData(int d){
		intData=d;
	}
	
	public PCData(String d){
		intData=Integer.valueOf(d);
	}
	
	/**
	 * getter method
	 * @return the intData
	 */
	
	public int getData() {
		return intData;
	}
	
	public String toString(){
		return "data:"+intData;
	}

}
