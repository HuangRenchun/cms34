package com.briup.cms.bean;

/**
 * 房产信息的pojo类
 * */
public class Home {
	private Long id;
	private String name;
	private String address;
	private Double size;
	private Double price;
	
	public Home(){
		
	}
	public Home(Long id, String name, String address, Double size, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.size = size;
		this.price = price;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
