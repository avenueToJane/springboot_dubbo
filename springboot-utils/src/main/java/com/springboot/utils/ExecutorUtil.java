package com.springboot.utils;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorUtil implements Serializable{
	
	private static final long serialVersionUID = 1656605431901858662L;
	//创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待	
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    
	public ExecutorService getExecutorService() {
		return executorService;
	}
	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}

}
