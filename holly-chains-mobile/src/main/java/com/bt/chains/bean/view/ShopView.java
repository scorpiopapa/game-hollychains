package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Prop;

@ApiObject(name = "ShopView", description = "商城菜单")
public class ShopView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2394891527446464645L;

	@ApiObjectField(description = "购买武器菜单")
	List<ShopWeaponMenu> weaponMenus;
	
	@ApiObjectField(description = "购买道具菜单")
	private List<Prop> propMenus;

	public List<ShopWeaponMenu> getWeaponMenus() {
		return weaponMenus;
	}

	public void setWeaponMenus(List<ShopWeaponMenu> weaponMenus) {
		this.weaponMenus = weaponMenus;
	}

	public List<Prop> getPropMenus() {
		return propMenus;
	}

	public void setPropMenus(List<Prop> propMenus) {
		this.propMenus = propMenus;
	}
}
