package com.inminhouse.alone.auth.login;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inminhouse.alone.auth.login.dto.LoginForm;
import com.inminhouse.alone.auth.login.dto.LoginResult;
import com.inminhouse.alone.auth.login.properties.LoginProperty;
import com.inminhouse.alone.auth.login.rules.IpAddressLoginRule;
import com.inminhouse.alone.auth.login.rules.LoginRule;
import com.inminhouse.alone.auth.login.rules.MaxTryLoginRule;

@Service
public class LoginService {
	
	@Autowired private LoginProperty loginProperty;
	
	private Set<LoginRule> rules;
	
	@PostConstruct
	private void addRules() {
		
		rules = new HashSet<>();
		
		if(loginProperty.getMaxTry() > 0) {
			rules.add(new MaxTryLoginRule(loginProperty.getMaxTry()));
		}
		if(!loginProperty.getIp().isEmpty()) {
			rules.add(new IpAddressLoginRule(loginProperty.getIp()));
		}
	}
	
	public LoginResult checkRules(LoginForm form) {
		
		for(LoginRule rule : rules) {
			LoginResult result = rule.apply(form);
			if(!result.isSuccess()) {
				return result;
			}
		}
		
		return LoginResult.builder()
				.success(Boolean.TRUE)
				.build();
	}
}
