package com.inminhouse.alone.auth.login.rules;

import com.inminhouse.alone.auth.login.dto.LoginForm;
import com.inminhouse.alone.auth.login.dto.LoginResult;

public interface LoginRule {

	LoginResult apply(LoginForm loginForm);
	
}
