package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

@Deprecated
public class UserAuthMarket extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5297262431445321380L;
	
	private int sId;
	private int userId;
	private String marketId;
	private String market;

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

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}
}
