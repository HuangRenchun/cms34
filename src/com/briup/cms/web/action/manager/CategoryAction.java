package com.briup.cms.web.action.manager;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 后台栏目管理Action
 * */
public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//同名参数传值
	private Long id;
	private String name;
	private Integer code;
	
	//创建service层对象，方便action各个方法去调用
	private ICategoryService categoryService = new CategoryServiceImpl();
	
	private List<Category> categoryList;
	private Category category;
	
	/**
	 * 跳转到添加栏目页面
	 * @author 李四
	 * http://localhost:8888/cms/manager/toAddCategory.action
	 * */
	@Action(value="toAddCategory",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/addCategory.jsp")})
	public String toAddCategory(){
		return SUCCESS;//"success"
	}
	
	/**
	 * @author 王五
	 * 跳转到栏目管理页面
	 * */
	@Action(value="toCategoryManager",
			results={@Result(name="success",location="/WEB-INF/jsp/manager/categoryManager.jsp")})
	public String toCategoryManager(){
		//调用service层的方法查询所有的栏目信息，并且将这些值赋给categoryList
		categoryList = categoryService.list();
		return SUCCESS;//"success"
	}
	
	@Action(value="toUpdCategory",
			results={@Result(name="success",location="/WEB-INF/jsp/manager/updCategory.jsp")})
	public String toUpdCategory(){
		//调用service层的方法通过id查询要修改栏目的信息
		category = categoryService.findById(id);
		return SUCCESS;//"success"
	}
	
	
	@Action(value="updCategory")
	public void updCategory(){
		//将接收到的参数进行封装，封装为一个对象
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setCode(code);
		//调用sercice层的服务，完成添加栏目的功能
		categoryService.update(category);
	}
	
	
	/**
	 * 添加栏目
	 * @author 李四
	 * */
	@Action(value="addCategory")
	public void addCategory(){
		//将接收到的参数进行封装，封装为一个对象
		Category category = new Category(name, code);
		//调用sercice层的服务，完成添加栏目的功能
		categoryService.add(category);
	}
	
	
	/**
	 * 添加栏目
	 * @author 王五
	 * */
	@Action(value="delCategory")
	public void delCategory(){
		categoryService.delete(id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
