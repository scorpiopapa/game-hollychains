package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Prop;


@ApiObject(name = "PropBuyView", description = "道具购买返回信息")
public class PropBuyView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -741246009627330895L;
	
//	@ApiObjectField(description = "用户id")
//	private int userId;
	
//	@ApiObjectField(description = "用户信息")
//	private User user;
	
//	@ApiObjectField(description = "用户购买的道具信息")
//	private UserProp userProp;
	
	@ApiObjectField(description = "购买道具列表信息")
	private List<Prop> propList;

	@ApiObjectField(description = "用户余额")
	BuyGemView balance;
	
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

//	public UserProp getUserProp() {
//		return userProp;
//	}
//
//	public void setUserProp(UserProp userProp) {
//		this.userProp = userProp;
//	}

	public List<Prop> getPropList() {
		return propList;
	}

	public void setPropList(List<Prop> propList) {
		this.propList = propList;
	}

	public BuyGemView getBalance() {
		return balance;
	}

	public void setBalance(BuyGemView balance) {
		this.balance = balance;
	}
}
