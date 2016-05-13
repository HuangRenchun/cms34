package com.briup.cms.web.action.manager;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.service.IArticleService;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.ArticleServiceImpl;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private ICategoryService categoryService
						= new CategoryServiceImpl();
	private IArticleService articleService = 
						new ArticleServiceImpl();
	
	private List<Category> cateogryList;
	private List<Article> articleList;
	
	private String title;
	private String author;
	private String content;
	private Long c_id;
	
	
	
	@Action(value="toAddArticle",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/addArticle.jsp")})
	public String toAddArticle(){
		cateogryList = categoryService.list();
		return SUCCESS;
	}
	
	/**
	 * 跳转到栏目管理页面
	 * */
	@Action(value="toArticleManager",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/articleManager.jsp")})
	public String toArticleManager(){
		articleList = articleService.list();
		return SUCCESS;
	}
	
	
	/**
	 * 信息发布的处理类
	 * */
	@Action("addArticle")
	public void addArticle(){
		Article article = new Article();
		article.setAuthor(author);
		article.setC_id(c_id);
		article.setClickTimes(0);
		article.setContent(content);
		article.setPublisurDate(new Date());
		article.setTitle(title);
		articleService.add(article);
	}

	public List<Category> getCateogryList() {
		return cateogryList;
	}

	public void setCateogryList(List<Category> cateogryList) {
		this.cateogryList = cateogryList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
}
