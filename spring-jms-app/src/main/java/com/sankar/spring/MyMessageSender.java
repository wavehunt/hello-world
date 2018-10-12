package com.sankar.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MyMessageSender {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(JmsConfig.class);
		//For Queue messaging
		//JmsTemplate jt=ctx.getBean(JmsTemplate.class);
		
		//For pubsub messaging
		JmsTemplate jt=(JmsTemplate) ctx.getBean("jtPubSub");
		
		for(int i=0;i<3;i++) {
			int count = i;
			//jt.send("testQueue", new MessageCreator() {
			jt.send("demoTopic", new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage tm=session.createTextMessage();
					tm.setText("Message " + count);
					System.out.println("message Sent");
					return tm;
				}
			});
			
		}
		
		

		
		

	}

}
