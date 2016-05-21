package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Home;

public interface IHomeService {
	//添加房产信息
	void addHome(Home home);
	//列出房产信息
	List<Home> list();
	//删除房产信息
	void delete(long id);
	//更新
	void update(Home home);
	//通过id查询
	Home findById(long id);
}
