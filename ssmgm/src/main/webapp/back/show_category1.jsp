
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>编号</td>
			<td>类别名称</td>
		</tr>
	
	</table>
	<%
		Integer pageNum = Integer.parseInt(request.getParameter("page"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		Long total = (Long)request.getAttribute("total");
		Long totalPage = 0L;
		if(total % pageSize == 0){
			totalPage = total / pageSize;
		}else{
			totalPage = total / pageSize + 1;
		}
	%>
	<a href="showAllCategory.servlet?page=1&pageSize=5">首页</a>
	<a href="showAllCategory.servlet?page=<%=pageNum-1<1? 1: pageNum-1 %>&pageSize=<%=pageSize%>">上一页</a>
	<a href="showAllCategory.servlet?page=<%=pageNum+1>totalPage?totalPage:pageNum+1 %>&pageSize=<%=pageSize%>">下一页</a>
	<a href="showAllCategory.servlet?page=<%=totalPage %>&pageSize=5">末页</a>
</body>
</html>