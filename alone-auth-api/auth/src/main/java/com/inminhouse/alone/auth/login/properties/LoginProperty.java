package com.inminhouse.alone.auth.login.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "policy.login")
public class LoginProperty {

	private int maxTry;
	
	private boolean duplicated;

	private List<String> ip;
}
