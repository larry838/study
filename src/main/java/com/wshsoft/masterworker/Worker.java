/**
 * @package com.hitao.masterworker
 * @title: Worker.java
 * @company: �����Ա�
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.masterworker;

import java.util.Map;
import java.util.Queue;

/**
 * @className: Worker
 * @description: TODO
 * @author: л��
 * @email: xiejian@hitao.com
 * @date 2013-9-6
 * 
 */

public class Worker implements Runnable {

	// ������У�����ȡ��������
	protected Queue<Object> workQueue;
	
	// ������������
	protected Map<String, Object> resultMap;

	// ���������߼�����������ʵ�־����߼�
	public Object handle(Object input) {
		return input;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			// ��ȡ������
			Object input = workQueue.poll();
			if (input == null)
				break;
			// ����������
			Object re = handle(input);
			// ��������д������
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
