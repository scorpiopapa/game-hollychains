package com.bt.chains.bean;


//@ApiObject(name = "LoginUser", description = "登录用户信息")
public class LoginUser extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7830316623495293924L;
	
//	@ApiObjectField(description = "用户id")
	private int userId;

//	@ApiObjectField(description = "用户名")
	private String name;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
