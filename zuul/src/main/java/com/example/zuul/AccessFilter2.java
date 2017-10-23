package com.example.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;

public class AccessFilter2 extends ZuulFilter{
	
	private static final Logger LOG = LoggerFactory.getLogger(AcessFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		LOG.info("【filter2被执行】");
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
