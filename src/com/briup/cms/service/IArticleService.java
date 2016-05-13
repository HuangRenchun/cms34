package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Article;

public interface IArticleService {
	//添加
	void add(Article article);
	//删除
	void remove(long id);
	//查询
	List<Article> list();
	//通过id查询
	Article scanner(long id);
	//通过栏目查询
	List<Article> listByCategory(long c_id);
}
