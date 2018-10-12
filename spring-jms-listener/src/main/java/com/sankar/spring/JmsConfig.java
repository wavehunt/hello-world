package com.sankar.spring;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;


@Configuration
@ComponentScan(basePackages="com.sankar.spring")
@EnableJms
public class JmsConfig {
	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory cf=new ActiveMQConnectionFactory();
		cf.setBrokerURL("tcp://localhost:61616");
		return cf;
	}
	
	//For Queue Based
	/*
	@Bean
	public JmsListenerContainerFactory<?> factory(){
		DefaultJmsListenerContainerFactory factory=new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		return factory;
	}
	*/
	
	//For Pub/Sub
	@Bean
	public JmsListenerContainerFactory<?> factory(){
		DefaultJmsListenerContainerFactory factory=new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setPubSubDomain(true);
		return factory;
	}
	
	@Bean
	public JmsTemplate jt() {
		JmsTemplate jt=new JmsTemplate();
		jt.setConnectionFactory(connectionFactory());
		return jt;
	}
	

}
