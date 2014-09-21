package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserMagic;

@Deprecated
@ApiObject(name = "IntensifyUserRoleView", description = "魔法强化返回数据", show=false)
public class IntensifyUserMagicView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -808451039262900344L;
	
	@ApiObjectField(description = "用户")
	private User user;
	
	@ApiObjectField(description = "用户魔法")
	private UserMagic userMagic;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserMagic getUserMagic() {
		return userMagic;
	}

	public void setUserMagic(UserMagic userMagic) {
		this.userMagic = userMagic;
	}
}
