package com.sankar.spring;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
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
	
	@Bean
	public JmsTemplate jt() {
		JmsTemplate jt=new JmsTemplate();
		jt.setConnectionFactory(connectionFactory());
		return jt;
	}
	

}
