package com.briup.cms.model;

import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;

public class CategoryModel {
	private Category category;
	private List<Article> articles;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
