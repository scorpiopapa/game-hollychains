package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "Role", description = "用户所有职业")
public class Role extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/**
	 * 职业ID
	 */
	@ApiObjectField(description = "职业ID")
	private int jobId;
	/**
	 * 职业名称
	 */
	@ApiObjectField(description = "职业名称")
	private String jobName;

	/**
	 * 是否新职业
	 */
	@ApiObjectField(description = "是否新职业")
	private int unblockCheckpoints;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getUnblockCheckpoints() {
		return unblockCheckpoints;
	}

	public void setUnblockCheckpoints(int unblockCheckpoints) {
		this.unblockCheckpoints = unblockCheckpoints;
	}
	
	
	
}
