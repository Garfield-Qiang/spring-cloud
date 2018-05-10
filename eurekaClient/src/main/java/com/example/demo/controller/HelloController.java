package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {

	private final static Logger logger = Logger.getLogger(HelloController.class);
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("hello")
	public String sayHello() {
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		logger.info("/hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return "hello";
	}
}
