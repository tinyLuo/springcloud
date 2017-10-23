package yc.yonyou.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {
	
	private final static Logger LOG = LoggerFactory.getLogger(HelloController.class);
	
	@Value(value = "${from}")
	private String from;
	
	@RequestMapping("/hello")
	public String hello(){
		LOG.info("from:【{}】",from);
		return "hello world";
	}
}
