<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>

	<form action="<%=path%>/addProductAction.action" method="post"
		enctype="multipart/form-data">
		名称:<input type="text" name="productDTO.name" /> <br /> 价格:<input
			type="text" name="productDTO.price" /> <br /> 运费:<input type="text"
			name="productDTO.freight" /> <br /> 失效时间:<input type="text"
			name="productDTO.expireTime" /> yyyy/MM/dd格式 <br /> 库存:<input type="text"
			name="productDTO.stockNum" /> <br /> 所在地:<input type="text"
			name="productDTO.sellAddress" /> <br /> 
			商品类型: <select name="productDTO.categoryDTO.id">
			
		</select>
		<br/>
		商品主图片:<input type="file" name="images" /> <br/>
		商品副图片1:<input type="file" name="images" /> <br/>
		商品副图片2:<input type="file" name="images" /> <br/>
		商品副图片3:<input type="file" name="images" /> <br/>
		商品副图片4:<input type="file" name="images" /> <br />
		<button type="submit">添加</button>
		<button type="reset">重置</button>
	</form>
</body>
</html>