package com.inminhouse.alone.auth.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inminhouse.alone.auth.login.dto.LoginForm;
import com.inminhouse.alone.auth.login.dto.LoginResult;

@SpringBootTest
class LoginServiceTest {

	@Autowired private LoginService loginService;
	
	@Test
	void testCheckRules() {
		LoginForm form = new LoginForm();
		form.setEmail("yuinye@gmail.com");
		form.setPassword("123sdfaefasd");
		form.setIpAddress("127.0.0.1");
		form.setCurrentTry(6);
		LoginResult result = loginService.checkRules(form);
		Assertions.assertEquals(false, result.isSuccess());
	}
}
