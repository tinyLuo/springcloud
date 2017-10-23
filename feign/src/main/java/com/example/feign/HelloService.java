package com.example.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="hello-service")
public interface HelloService {
	
	@RequestMapping("/hello")
	String hello();
}
