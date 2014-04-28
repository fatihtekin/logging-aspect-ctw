package com.acneuro.orchestration.customtask.sendword.client;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SendWordWorkItemHandler {

	private static Logger logger = Logger.getLogger("SendWordWorkItemHandler.class");

	private String restURL = "http://ams1-devsupse-01:8080/sendword/send";


	public void executeWorkItem(String workItem,String workItem2) {

			logger.log(Level.INFO,"request treter");
			
			

	}


}