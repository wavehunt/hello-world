package com.sankar.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MyMessageReceiver {

	public static void main(String[] args) throws JMSException {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jt=ctx.getBean(JmsTemplate.class);
		
		//For single message delivery.. this example works fine
		//for multiple, its best to create message listener
		TextMessage tm=(TextMessage) jt.receive("testQueue");
		
		System.out.println(tm.getText());

		
				

	}

}
