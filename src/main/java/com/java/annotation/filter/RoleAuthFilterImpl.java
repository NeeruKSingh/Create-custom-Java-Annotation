package com.java.annotation.filter;

import org.springframework.stereotype.Component;

@Component
public class RoleAuthFilterImpl {

	public boolean authorize(String auth) {
		
		
		/*** Wite here your custom code user auth token authentication**/
		
		
		if(("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9").equals(auth)){
			return true;
		}
		return false;
		

	}

}
