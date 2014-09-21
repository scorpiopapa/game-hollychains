package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "RankingListView", description = "排行榜列表信息")
public class RankingListView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1810592007152714437L;
	
	@ApiObjectField(description = "排名信息")
	private List<RankingView> rankingViews;

	@ApiObjectField(description = "剩下的页数")
	int tailPages;
	
	public List<RankingView> getRankingViews() {
		return rankingViews;
	}
	public void setRankingViews(List<RankingView> rankingViews) {
		this.rankingViews = rankingViews;
	}
	public int getTailPages() {
		return tailPages;
	}
	public void setTailPages(int tailPages) {
		this.tailPages = tailPages;
	}
}
