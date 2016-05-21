<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="top">
    	<div class="topbg">
            <div class="logo_sign">
            	<div class="logo"></div>
                <div class="sign">
                	<span>欢迎您系统管理员</span>
                    <span class="sp_home">首页</span>
                    <span class="sp_backstage"><a href="manager/toIndex.action">后台管理</a></span>
                    <span class="sp_signout">退出</span>
                </div>
            </div> 
            <div class="nav">
            	<ul class="navUI">
                	<li><a href="toIndex.action">首页</a></li>
                	<c:forEach items="${categoryList }" var="c">
                		<li><a href="toList.action?c_id=${c.id }">${c.name }</a></li>
                	</c:forEach>
                    
                </ul>
            </div>
            <div class="banner">
            	<div class="banimg"><img src="theme/1/images/front/banner.png"></div>
            </div>
        </div>
    </div>