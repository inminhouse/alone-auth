package com.inminhouse.alone.auth.login.rules;

public class RuleArgument<T> {

	private Object arg;
	
	public RuleArgument(Object arg) {
		this.arg = arg;
	}
	
	@SuppressWarnings("unchecked")
	public T getArg() {
		return (T) arg;
	}
}
