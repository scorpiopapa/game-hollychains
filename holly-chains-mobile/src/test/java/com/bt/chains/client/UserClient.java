package com.bt.chains.client;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.client.RestTemplate;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Param;
import com.bt.chains.bean.form.BindForm;
import com.bt.chains.bean.form.CheckpointsForm;
import com.bt.chains.bean.form.EnterCheckpointForm;
import com.bt.chains.bean.form.EnterCustomCheckpointForm;
import com.bt.chains.bean.form.EnterRandomCheckpointForm;
import com.bt.chains.bean.form.IntensifyUserRoleForm;
import com.bt.chains.bean.form.LoginForm;
import com.bt.chains.bean.form.SacrifiedWeapon;
import com.bt.chains.bean.form.WeaponComposeForm;
import com.joinway.utils.json.JsonConverter;

public class UserClient {

	private static final RestTemplate temp = new RestTemplate();
	private static final HttpClient client = HttpClients.createDefault();
	
//	private static final String BASE_URL = "http://localhost:9080/";
//	private static final String BASE_URL = "http://ec2-54-199-169-243.ap-northeast-1.compute.amazonaws.com:8080/";
	private static final String BASE_URL = "http://localhost:8080/";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		login();
//		composeWeapon();
//		finishedCheckPoint();
//		enterCustomCheckpoint();
//		enterRandomCheckpoint();
//		bindDevice();
//		enterCheckPoint();
//		playedCheckPoints();
		
		printJson();
//		Map<String, Integer> params = new HashMap<String, Integer>();
//		params.put("archivementId", 7065);
//		params.put("userId", 410);
//		getRequest(params, "chains/reward/clickToObtainAchivement");
		
//		Map<String, Integer> params = new HashMap<String, Integer>();
//		params.put("userId", 410);
//		getRequest(params, "chains/reward/getAchivementList");
	}

	static void enterCustomCheckpoint() throws Exception {
		EnterCustomCheckpointForm form = new EnterCustomCheckpointForm();
		
		form.setUserId(404);
		form.setPayType("0");
		
		postRequest(form, "chains/checkpoints/enterCustomCheckpoint");
	}
	
	static void enterRandomCheckpoint() throws Exception {
		EnterRandomCheckpointForm form = new EnterRandomCheckpointForm();
		
		form.setUserId(426);
		form.setRoleId(1);
		form.setPayType("0");
		
		List<Param> weaponIds = new ArrayList<>();
		weaponIds.add(new Param(7));
		weaponIds.add(new Param(38));
		weaponIds.add(new Param(67));
		weaponIds.add(new Param(80));
		weaponIds.add(new Param(107));
		
		postRequest(form, "chains/checkpoints/enterRandomCheckpoint");
	}

	static void finishedCheckPoint() throws Exception {
		CheckpointsForm form = new CheckpointsForm();
		form.setSceneId(1006);
		form.setUserId(410);
		form.setMoney(30);
		
		postRequest(form, "chains/checkpoints/finishCheckpoint");
	}
	
	static void playedCheckPoints() throws Exception {
		CheckpointsForm form = new CheckpointsForm();
		
		form.setSceneId(1001);
		form.setUserId(378);
		
		postRequest(form, "chains/checkpoints/playedCheckpoints");
	}
	
	static void printJson() throws Exception {
//		WeaponComposeForm form = new WeaponComposeForm();
//		List<Param> ids = new ArrayList<Param>();
//		Param p1 = new Param();
//		p1.setId(1);
//		Param p2 = new Param();
//		p2.setId(2);
//		ids.add(p1);
//		ids.add(p2);
////		form.setTributeIds(ids);
//		form.setUserId(123);
//		form.setId(11);
////		form.setWeaponRank(1);
		
//		WeaponSellForm form = new WeaponSellForm();
//		form.setUserId(386);
//		List<Param> ids = new ArrayList<>();
//		ids.add(new Param(330));
//		form.setIds(ids);
		
		IntensifyUserRoleForm form = new IntensifyUserRoleForm();
		form.setUserId(386);
		form.setRoleId(1);
		form.setPayType(1);
		
		System.out.println(JsonConverter.objectToJson(form));
	}
	
	private static void login() throws Exception {
	    LoginForm form = new LoginForm();
//	    form.setId("liliang2005@gmail.com");
//	    form.setMarket("G");
	    form.setId("Luz794");
//	    form.setId("liliang2005@gmail.com");
	    form.setMarket("G");
	    
	    postRequest(form, "chains/user/login");
	}

	static void composeWeapon() throws Exception {
		WeaponComposeForm form = new WeaponComposeForm();
		form.setId(27);
		form.setUserId(386);
		
		List<SacrifiedWeapon> sacrifiedWeapons = new ArrayList<>();
		SacrifiedWeapon sw = new SacrifiedWeapon();
		sw.setId(318);
		sw.setRank(1);
//		sw.setPoint(0);
		sacrifiedWeapons.add(sw);
		form.setSacrifiedWeapons(sacrifiedWeapons);
		
		postRequest(form, "chains/weapon/composeWeapon");
	}
	
	static void bindDevice()throws Exception {
		BindForm form = new BindForm();
		
		form.setCode("6783b");
		form.setId(1760);
		form.setUserId(1762);

		postRequest(form, "chains/user/bind");
	}
	
	static void enterCheckPoint() throws Exception {
		EnterCheckpointForm form = new EnterCheckpointForm();
		
		form.setUserId(383);
		form.setSceneId(1001);
		form.setSceneType(0);
//		form.setRoleId(1);
		form.setPower(1);
		
		postRequest(form, "chains/checkpoints/enterCheckpoint");
	}
	
	private static String postRequest(Product form, String url) throws Exception {
	    String input = JsonConverter.objectToJson(form);
	    out.println(input);
	    
	    HttpPost post = new HttpPost(BASE_URL + url);
	    HttpEntity entity = new StringEntity(input, ContentType.APPLICATION_JSON);
	    post.setEntity(entity);
//	    post.addHeader(name, value);
	    
	    HttpResponse response = client.execute(post);
	    out.println(response.getStatusLine());
	    
	    entity = response.getEntity();
	    String json = EntityUtils.toString(entity);
	    out.println(json);
	    
	    return json;
	}
	
	private static String getRequest(Map<String, Integer> paramsMap, String url){
		String json = null;
		try{
			Set<Map.Entry<String, Integer>> set = paramsMap.entrySet();
			Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
			String sUrl = "";
			while(iterator.hasNext()){
				Map.Entry<String, Integer> en = iterator.next();
				String key = en.getKey();
				Integer value = en.getValue();
				sUrl += key + "=" + value + "&";
			}
			sUrl = sUrl.substring(0, sUrl.length() - 1);
			HttpGet httpGet = new HttpGet(BASE_URL + url + "?" +sUrl);
			HttpResponse response = client.execute(httpGet);
			out.println(response.getStatusLine());
		    
			HttpEntity entity = response.getEntity();
		    json = EntityUtils.toString(entity);
		    out.println(json);
		} catch(Exception e){
			
		}
		
	    
	    return json;
	}
}
