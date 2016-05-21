package com.briup.cms.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.model.CategoryModel;
import com.briup.cms.service.IArticleService;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.ArticleServiceImpl;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//声明私有属性
	private List<Category> categoryList;
	
	private Long c_id;
	private Long id;
	private Article article;
	private List<CategoryModel> cmList;
	
	private ICategoryService categoryService = new CategoryServiceImpl();
	private IArticleService articleService = new ArticleServiceImpl();
	
	
	private List<Article> articleList;
	
	/**
	 * 跳转到首页
	 * http://ip:port/命名空间/url
	 * http://localhost:8888/cms/toIndex.action
	 * */
	@Action(value="toIndex",results={
			@Result(name="success",location="/WEB-INF/jsp/index.jsp")})
	public String toIndex(){
		loadCategory();
		cmList = articleService.listAll();
		return "success";
	}
	
	private void loadCategory(){
		//调用service层方法查询所有栏目的信息，并且将查到的数据赋给categoryList
		categoryList = categoryService.list();
	}
	
	/**
	 * 跳转到列表页
	 * */
	@Action(value="toList",results={
			@Result(name="success",location="/WEB-INF/jsp/list.jsp")})
	public String toList(){
		loadCategory();
		articleList = articleService.listByCategory(c_id);
		return "success";
	}
	
	/**
	 * 跳转到内容页
	 * */
	@Action(value="toContent",results={
			@Result(name="success",location="/WEB-INF/jsp/content.jsp")})
	public String toContent(){
		loadCategory();
		article = articleService.scanner(id);
		return "success";
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<CategoryModel> getCmList() {
		return cmList;
	}

	public void setCmList(List<CategoryModel> cmList) {
		this.cmList = cmList;
	}
}
