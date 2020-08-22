package com.java.annotation.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


/**** Annotation used @Aspect && @Before of Concept of Spring AOP,you can also use server filer**/
@Aspect
@Configuration
public class RoleAuthFilter {

	@Autowired
	RoleAuthFilterImpl authFilter;

	@Before("@annotation(com.java.create.annotation.RoleAuth) && args(request,..)")
	public void before(HttpServletRequest request) throws Exception {
		if (!(request instanceof HttpServletRequest)) {
			throw new RuntimeException("request should be HttpServletRequesttype");
		}

		if ((authFilter.authorize(request.getHeader("Authorization")) && ("admin".equalsIgnoreCase(request.getHeader("role"))))) {
			request.setAttribute("userSession", UUID.randomUUID().toString());
			request.setAttribute("isAuthenticated", "yes");
		} else {
			request.setAttribute("isAuthenticated", "no");
		}
	}

}
