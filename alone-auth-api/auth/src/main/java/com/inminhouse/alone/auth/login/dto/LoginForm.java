package com.inminhouse.alone.auth.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

	private String email;
	
	private String password;
	
	private String ipAddress;
	
	private int currentTry;
}
