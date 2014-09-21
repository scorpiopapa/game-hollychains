package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Boss;
import com.bt.chains.bean.domain.Checkpoint;
import com.bt.chains.bean.domain.Monster;
import com.bt.chains.bean.domain.PlayStageInfoView;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserHellAssignView;
import com.bt.chains.bean.domain.UserWeapon;

@ApiObject(name = "PlayStageListView", description = "大小关卡信息")
public class PlayStageListView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8740414940092062511L;

	@ApiObjectField(description = "大小关卡基本信息列表")
	private List<PlayStageInfoView> playStageInfos;

	@ApiObjectField(description = "炼狱模式关卡信息")
	private List<UserHellAssignView> userHellRandomInfo;

	public List<PlayStageInfoView> getPlayStageInfos() {
		return playStageInfos;
	}

	public void setPlayStageInfos(List<PlayStageInfoView> playStageInfos) {
		this.playStageInfos = playStageInfos;
	}

	public List<UserHellAssignView> getUserHellRandomInfo() {
		return userHellRandomInfo;
	}

	public void setUserHellRandomInfo(List<UserHellAssignView> userHellRandomInfo) {
		this.userHellRandomInfo = userHellRandomInfo;
	}

}
