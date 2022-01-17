package com.inminhouse.alone.auth.login.rules;

import com.inminhouse.alone.auth.login.dto.LoginForm;
import com.inminhouse.alone.auth.login.dto.LoginResult;

public class MaxTryLoginRule extends AbstractLoginRule{
	
	private int maxTry;
	
	public MaxTryLoginRule(int maxTry) {
		this.maxTry = maxTry;
	}

	@Override
	public LoginResult apply(LoginForm loginForm) {
		
		return loginForm.getCurrentTry() <= maxTry ?
				LoginResult.builder()
					.owner(loginForm.getEmail())
					.success(Boolean.TRUE)
					.build() :
				LoginResult.builder()
					.owner(loginForm.getEmail())
					.success(Boolean.FALSE)
					.reason("Login tries exceeded")
					.build();
	}


}
