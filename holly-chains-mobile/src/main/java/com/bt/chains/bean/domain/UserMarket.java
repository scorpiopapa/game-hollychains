package com.bt.chains.bean.domain;

import java.util.Date;

import com.bt.chains.bean.Product;

/**
 * 用户市场
 */
@Deprecated
public class UserMarket extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6818769777216660614L;
	
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 市场ID
	 */
	private String marketId;
	/**
	 * 市场：A：苹果；G：谷歌
	 */
	private String market;
	/**
	 * 创建日期
	 */
	private Date createDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
