/**
 * @package com.hitao.masterworker
 * @title: Master.java
 * @company: �����Ա�
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

package com.wshsoft.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @className: Master
 * @description: TODO
 * @author: л��
 * @email: xiejian@hitao.com
 * @date 2013-9-6
 * 
 */

public class Master {

	// �������
	protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
	// worker���̶���
	protected Map<String, Thread> threadMap = new HashMap<String, Thread>();
	// ������������
	protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

	// �Ƿ����е������񶼽���
	public boolean isComplete() {
		for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
			if (entry.getValue().getState() != Thread.State.TERMINATED) {
				return false;
			}

		}
		return true;
	}
    //����Master
	public Master(Worker worker,int countWorker){
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for (int i = 0; i <countWorker ; i++) {
			threadMap.put(Integer.toString(i), new Thread(worker,Integer.toString(i)));
		}
	}
	
	//�ύһ������
	public void submit(Object job){
		workQueue.add(job);
	}
	
	//��������������
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	
	//��ʼ�������е�worker���̣����д���
	public void  execute(){
		for (Map.Entry<String, Thread>  entry:threadMap.entrySet()) {
			
			entry.getValue().start();
			
		}
	}
}
