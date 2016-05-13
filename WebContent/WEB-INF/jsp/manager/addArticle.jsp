<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form = $("#addArticleForm");
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			form[0].reset();
			alert("添加成功！");
		});
		return false;
	});
});

</script>
<h1>文章发布</h1>
<hr>
<form action="addArticle.action" method="post" id="addArticleForm">
	文章标题:<input type="text" name="title"/><br/>
	文章作者:<input type="text" name="author"/><br/>
	所属栏目:	<select name="c_id">
				<option value="">请选中</option>
				<c:forEach items="${cateogryList }" var="c">
				<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	文章内容:
			<textarea name="content" rows="10" cols="30"></textarea>
		<br/>
	<input type="submit" value="提交"/><br/>
</form>