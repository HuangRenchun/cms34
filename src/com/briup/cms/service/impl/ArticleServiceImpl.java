package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.ArticleDao;
import com.briup.cms.service.IArticleService;

public class ArticleServiceImpl implements IArticleService {

	private ArticleDao articleDao = new ArticleDao();
	
	@Override
	public void add(Article article) {
		articleDao.save(article);
	}

	@Override
	public void remove(long id) {
		
	}

	@Override
	public List<Article> list() {
		return articleDao.findAll();
	}

	@Override
	public Article scanner(long id) {
		return null;
	}

	@Override
	public List<Article> listByCategory(long c_id) {
		return null;
	}

}
