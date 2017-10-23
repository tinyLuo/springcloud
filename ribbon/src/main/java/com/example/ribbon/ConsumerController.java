package com.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class ConsumerController {
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private HelloService helloservice;
	
	@RequestMapping(value="/consumer",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="fallback")
	public String helloConsumer() {
		return template.getForObject("http://HELLO-SERVICE/hello", String.class);
	}
	
	public String fallback(){
		return "error";
	}
}
