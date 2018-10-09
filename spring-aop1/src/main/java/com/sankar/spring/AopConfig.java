package com.sankar.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.sankar.spring")
//Enabling AspectJ
@EnableAspectJAutoProxy
public class AopConfig {
			

}
