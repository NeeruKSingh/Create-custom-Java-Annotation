package com.java.annotation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.create.annotation.RoleAuth;

@RestController
@RequestMapping(path = "/user", produces = { "application/json" }, headers = { "Authorization" })
public class UserController {

	
	/**** @RoleAuth is custom annotation used**/
	
	
	@RoleAuth
	@GetMapping(path="/{userid}")
	public String isAuthenticated(HttpServletRequest request, @PathVariable("userid") String userId) {
		System.out.print("userSession: "+request.getAttribute("userSession"));
		if(("yes").equals(request.getAttribute("isAuthenticated"))) {
			return "Yes, Your are Authenticated";
		}
		return "No, Your are  not Authenticated";
	}

}
