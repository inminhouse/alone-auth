package com.inminhouse.alone.auth.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inminhouse.alone.auth.login.dto.LoginForm;
import com.inminhouse.alone.auth.login.dto.LoginResult;

@RestController
public class LoginController {
	
	@Autowired private LoginService loginService;

	@PostMapping("/login")
	public LoginResult login(HttpServletRequest request, @RequestBody LoginForm loginForm) {
		
		loginForm.setIpAddress(request.getRemoteAddr());
		loginForm.setCurrentTry(3);
		return loginService.checkRules(loginForm);
	}
}
