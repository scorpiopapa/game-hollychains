package com.bt.chains.bean.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.constant.RegexConstants;

@ApiObject(name = "UserScoreForm", description = "用户积分")
public class UserScoreForm extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -365310973053534027L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "用户获得的金币")
	@Min(0)
	int money;
	
//	@ApiObjectField(description = "用户名称")
//	private String userName;
	
	@ApiObjectField(description = "用户积分")
	@Min(0)
	private int score;
	
//	@ApiObjectField(description = "职业")
//	private int roleId;
	
	@ApiObjectField(description = "积分模式:R-随机无限模式积分；C-自定义无限模式积分")
	@Pattern(regexp=RegexConstants.CHECKPOINT_MODEL)
	private String type;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
