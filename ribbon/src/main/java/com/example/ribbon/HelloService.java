package com.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class HelloService {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "helloFallback" )
	public String hello(){
		return restTemplate.getForObject("http://HELLO-SERVICE/hello",String.class);
	}
	
	public String helloFallback() {
		return "hello world";
	}
}
