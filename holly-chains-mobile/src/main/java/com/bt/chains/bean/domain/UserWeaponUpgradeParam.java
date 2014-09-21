package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class UserWeaponUpgradeParam extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2547001212246665313L;

	int level;
	
	int benchmarkPoint;
	
	int convertPoint;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getBenchmarkPoint() {
		return benchmarkPoint;
	}

	public void setBenchmarkPoint(int benchmarkPoint) {
		this.benchmarkPoint = benchmarkPoint;
	}

	public int getConvertPoint() {
		return convertPoint;
	}

	public void setConvertPoint(int convertPoint) {
		this.convertPoint = convertPoint;
	}
}
