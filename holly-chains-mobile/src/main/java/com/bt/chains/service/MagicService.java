package com.bt.chains.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bt.chains.bean.domain.MagicUpgradeConfig;
import com.bt.chains.bean.domain.Param;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserMagic;
import com.bt.chains.bean.form.IntensifyUserMagicForm;
import com.bt.chains.bean.form.MagicForm;
import com.bt.chains.bean.form.MagicSellForm;
import com.bt.chains.bean.view.Item;
import com.bt.chains.bean.view.UpdateItemView;
import com.bt.chains.bean.view.UserMagicView;
import com.bt.chains.constant.Constants;
import com.bt.chains.constant.DBConstants;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.mapper.MagicMapper;
import com.bt.chains.mapper.UserMapper;

@Service
public class MagicService {
	private final static Logger log = LoggerFactory.getLogger(MagicService.class);
	
	@Autowired
	private MagicMapper magicMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional(rollbackFor=Exception.class)
	public int sellMagic(MagicSellForm form){
		int userId = form.getUserId();
		int sellTotal = form.getSellTotal();
		List<Param> list = form.getMagicIds();
		List<Integer> magicSellIds = new ArrayList<Integer>();
		Iterator<Param> iterator = list.iterator();
		while(iterator.hasNext()){
			magicSellIds.add(iterator.next().getId());
		}
		
		User user = new User();
		user.setMagicIds(magicSellIds);
		user.setUserId(userId);
		user.setMoney(sellTotal);
		
		//删除买掉的魔法
		magicMapper.deleteMagic(user);
		//更新用户金币数量
		magicMapper.updateUserGold(user);
		return 1;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public UpdateItemView updateUserMagic(MagicForm form) {
		UpdateItemView view = new UpdateItemView();
		
		int userId = form.getUserId();
		List<Param> magics = form.getMagicIds();
		
		if(magics != null && magics.size() > 0){
			magicMapper.resetUserMagicInUseStatus(DBConstants.InUseStatus.NotInUse);
			List<Item> items = new ArrayList<>();
			
			Iterator<Param> iterator = magics.iterator();
			while(iterator.hasNext()){
				int id = iterator.next().getId();
				UserMagic userMagic = magicMapper.queryeMagic(userId, id, null).get(0);
				userMagic.setInUse(DBConstants.InUseStatus.InUse);
				magicMapper.updateUserMagic(userMagic);
				
				items.add(new Item(id, userMagic.getMagicRank()));
			}
			
			view.setItems(items);
		}
		
		return view;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int intensifyUserMagic(IntensifyUserMagicForm form){
		int status = 0;
		
		UserMagic userMagic = magicMapper.queryeMagic(form.getUserId(), form.getMagicId(), null).get(0);
		
		User user = userMapper.selectUser(form.getUserId());
		MagicUpgradeConfig config = magicMapper.selectMagicUpgradeConfig(userMagic.getMagicRank());
		
		if(config.getMoney() == 0 && config.getSpecialMoney() == 0){
			// 魔法已经达到上限，不能继续升级
			return 1;
		}
		
		int balance = ServiceHelper.calculateBalance(user, form.getUserId(), form.getPayType(), config.getMoney(), config.getSpecialMoney());
		
		if(balance < 0 ){
			return Integer.valueOf(ErrorCodeConstants.NOT_ENOUGH_MONEY);
		}

		
		if(Constants.PaymentType.PayCoin == form.getPayType()){
			user.setSpecialMoney(balance);
		}else{
			user.setMoney(balance);
		}
		
		userMapper.updateUser(user);
		
		//更新魔法信息
		userMagic.setMagicRank(userMagic.getMagicRank() + 1);
		magicMapper.updateUserMagic(userMagic);
		
		return status;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED) 
	public UserMagicView getUserMagic(int userId){
		UserMagicView view = new UserMagicView();
		
		List<Item> items = new ArrayList<>();
		
		List<UserMagic> magics = magicMapper.queryAllMagic(userId);
		if(!CollectionUtils.isEmpty(magics)){
			for(UserMagic um : magics){
				Item item = new Item();
				item.setId(um.getMagicId());
				item.setRank(um.getMagicRank());
				
				items.add(item);
			}
		}
		
		view.setMagics(items);
		
		return view;
	}

}
