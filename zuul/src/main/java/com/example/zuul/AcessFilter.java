package com.example.zuul;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AcessFilter extends ZuulFilter{
	private static final Logger LOG = LoggerFactory.getLogger(AcessFilter.class);
	
	@Override
	public Object run() {
		LOG.info("执行请求filter操作");
		RequestContext ctx = RequestContext.getCurrentContext();
		
		HttpServletRequest request = ctx.getRequest();
		LOG.info("send {} request to {} ",request.getMethod(),request.getRequestURL().toString());
		
		String accessToken = request.getParameter("accessToken");
		if(accessToken == null) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 2;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
