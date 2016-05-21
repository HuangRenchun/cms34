package com.briup.cms.bean;

import java.util.Date;

public class Article {
	private Long id;		//编号
	private String title;	//标题
	private String author;
	private String content;	//内容
	private Date publisurDate;	//日趋
	private Integer clickTimes;	//点击次数
	private Long c_id;//外键  该文章属于哪个栏目
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublisurDate() {
		return publisurDate;
	}
	public void setPublisurDate(Date publisurDate) {
		this.publisurDate = publisurDate;
	}
	public Integer getClickTimes() {
		return clickTimes;
	}
	public void setClickTimes(Integer clickTimes) {
		this.clickTimes = clickTimes;
	}
	public Long getC_id() {
		return c_id;
	}
	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author
				+ ", content=" + content + ", publisurDate=" + publisurDate
				+ ", clickTimes=" + clickTimes + ", c_id=" + c_id + "]";
	}
	
}
