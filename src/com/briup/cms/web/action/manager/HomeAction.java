package com.briup.cms.web.action.manager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@Action(value="toAddHome",
			results={@Result(name="success",location="/WEB-INF/jsp/manager/addHome.jsp")})
	public String toAddHome(){
		return SUCCESS;
	}
}
