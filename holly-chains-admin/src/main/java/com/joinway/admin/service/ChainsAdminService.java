package com.joinway.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joinway.admin.bean.domain.TreeMenu;

@Service("ChainsAdminService")
public class ChainsAdminService extends AdminService {

	@Override
	protected List<TreeMenu> findTreeMenus(int userId) throws Exception {
		return tableRepository.find(TreeMenu.class);
	}

}

