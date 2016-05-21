package com.briup.cms.test;

import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.ArticleDao;

public class DaoTest {
	public static void main(String[] args) {
		ArticleDao dao = new ArticleDao();
		List<Article> list = dao.query(null, "test", 2L);
		for(Article a : list){
			System.out.println(a);
		}
	}
}
