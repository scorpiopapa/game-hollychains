package com.bt.chains.bean.domain;

import java.util.Date;

import com.bt.chains.bean.Product;

/**
 * 炼狱模式 随机分配的3个职业与武器对象
 * 
 * @author javier
 * 
 */
public class UserHellAssignInfo extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7979208902287367039L;
	private int userId;
	private String randomRole;
	private String randomWeapon;
	private String randomMagic;
	private Date createDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRandomRole() {
		return randomRole;
	}

	public void setRandomRole(String randomRole) {
		this.randomRole = randomRole;
	}

	public String getRandomWeapon() {
		return randomWeapon;
	}

	public void setRandomWeapon(String randomWeapon) {
		this.randomWeapon = randomWeapon;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRandomMagic() {
		return randomMagic;
	}

	public void setRandomMagic(String randomMagic) {
		this.randomMagic = randomMagic;
	}
}
