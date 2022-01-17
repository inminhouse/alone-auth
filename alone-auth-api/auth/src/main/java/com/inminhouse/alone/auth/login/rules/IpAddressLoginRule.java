package com.inminhouse.alone.auth.login.rules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.inminhouse.alone.auth.login.dto.LoginForm;
import com.inminhouse.alone.auth.login.dto.LoginResult;

public class IpAddressLoginRule extends AbstractLoginRule {

	private Set<String> addresses;
	
	public IpAddressLoginRule(List<String> addresses) {
		this.addresses = new HashSet<>(addresses);
	}

	@Override
	public LoginResult apply(LoginForm loginForm) {
		
		return addresses.contains(loginForm.getIpAddress()) ?
				LoginResult.builder()
					.owner(loginForm.getEmail())
					.success(Boolean.TRUE)
					.build() :
				LoginResult.builder()
					.owner(loginForm.getEmail())
					.success(Boolean.FALSE)
					.reason("Not accessible IP address")
					.build();
	}

}
