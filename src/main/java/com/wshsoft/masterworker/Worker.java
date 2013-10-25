/**
 * @package com.hitao.masterworker
 * @title: Worker.java
 * @company: 快乐淘宝
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.masterworker;

import java.util.Map;
import java.util.Queue;

/**
 * @className: Worker
 * @description: TODO
 * @author: 谢建
 * @email: xiejian@hitao.com
 * @date 2013-9-6
 * 
 */

public class Worker implements Runnable {

	// 任务队列，用于取得子任务
	protected Queue<Object> workQueue;
	
	// 子任务处理结果集
	protected Map<String, Object> resultMap;

	// 子任务处理逻辑，在子类中实现具体逻辑
	public Object handle(Object input) {
		return input;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			// 获取子任务
			Object input = workQueue.poll();
			if (input == null)
				break;
			// 处理子任务
			Object re = handle(input);
			// 将处理结果写入结果集
			resultMap.put(Integer.toString(input.hashCode()), re);

		}

	}

	/**
	 * getter method
	 * 
	 * @return the workqQueue
	 */

	public Queue<Object> getWorkQueue() {
		return workQueue;
	}

	/**
	 * setter method
	 * 
	 * @param workqQueue
	 *            the workqQueue to set
	 */

	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue = workQueue;
	}
	
	/**
	 * getter method
	 * @return the resultMap
	 */
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	/**
	 * setter method
	 * @param resultMap the resultMap to set
	 */
	
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
}
