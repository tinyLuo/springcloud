package yc.yonyou.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private final static Logger LOG = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello world";
	}
}
