package com.bt.chains.controller;

import static java.lang.System.out;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bt.chains.BaseTest;
import com.bt.chains.bean.form.IntensifyUserRoleForm;
import com.joinway.utils.json.JsonConverter;

public class RoleControllerTest extends BaseTest {
	@Autowired
	private RoleController controller;
	
//	@Test
//	public void test() throws Exception {
//		/**
//		 * 插入用户
//		 */
//		UserRoleForm form = new UserRoleForm();
//		List<UserRole> roles = new ArrayList<UserRole>();
//		UserRole userRole = new UserRole();
//		userRole.setRoleId(9);
//		userRole.setRoleRank(1);
//		UserRole userRole1 = new UserRole();
//		userRole1.setRoleId(10);
//		userRole1.setRoleRank(1);
//		roles.add(userRole);
//		roles.add(userRole1);
//	    //用户ID
//	    form.setUserId(1);
//	    form.setRoles(roles);
//	    
//	    out.println(JsonUtils.objectToString(form));
//	    
//	    // a json string
//		String output = standaloneSetup(controller)
//				.build()
//				.perform(
//						post("/role/insertUserRole").body(JsonUtils.objectToString(form).getBytes("UTF-8"))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON)
////								.headers(ClientHelper.getHeaders())
//				)
//				.andReturn().getResponse().getContentAsString();
//		
//		out.println(output);
//	}
	
//	@Test
//	public void test() throws Exception {
//		/**
//		 * 购买用户职业
//		 */
//		BuyUserRoleForm form = new BuyUserRoleForm();
//		List<UserRole> roles = new ArrayList<UserRole>();
//		UserRole userRole = new UserRole();
//		userRole.setRoleId(9);
//		userRole.setRoleRank(1);
//		UserRole userRole1 = new UserRole();
//		userRole1.setRoleId(10);
//		userRole1.setRoleRank(1);
//		roles.add(userRole);
//		roles.add(userRole1);
//	    //用户ID
//	    form.setUserId(1);
//	    form.setRoles(roles);
//	    form.setPayType("1");
//	    form.setMoney(10);
//	    
//	    out.println(JsonUtils.objectToString(form));
//	    
//	    // a json string
//		String output = standaloneSetup(controller)
//				.build()
//				.perform(
//						post("/role/buyUserRole").body(JsonUtils.objectToString(form).getBytes("UTF-8"))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON)
////								.headers(ClientHelper.getHeaders())
//				)
//				.andReturn().getResponse().getContentAsString();
//		
//		out.println(output);
//	}
	
	@Test
	public void test() throws Exception {
		/**职业强化
		 */
		IntensifyUserRoleForm form = new IntensifyUserRoleForm();
		form.setUserId(386);
		form.setRoleId(10);
		form.setPayType(0);
//		form.setRoleRank(5);
		//是否付费，可能是花钱升级，也可能是积分达到一定程度升级
//		form.setPayStatus("0");
//		form.setPayType("1");
//		form.setMoney(100);
	    
	    out.println(JsonConverter.objectToJson(form));
	    
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/role/upgradeRole").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
}
