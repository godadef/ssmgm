<%@page import="com.yq.cn.dao.entity.Image"%>
<%@page import="com.yq.cn.dao.entity.Product"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.yq.cn.dao.entity.Category"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>贵美商城</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/layout.css?id=7" />
<script type="text/JavaScript"
	src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
	<div id="container">
		<iframe id="header"
			src="${pageContext.request.contextPath}/header.jsp" width="980"
			height="136" frameborder="0" scrolling="no"></iframe>
		<div id="main">
			<div class="cat">
				<%
					Set<Category> ps = (Set<Category>) session.getAttribute("ps");
					if (ps == null) {
						response.sendRedirect("CatogeryController/getCatogerys");
						return;
					}
					ps = (Set<Category>) session.getAttribute("ps");
					for (Category category : ps) {
				%>
				<ul>
					<h1><%=category.getName()%></h1>
					<%
						Set<Category> children = category.getChildren();
							for (Category category2 : children) {
								out.print("<li><a href='ProductController/getSameProducts?id="+category.getId()+"'>" + category2.getName() + "</a></li>");
							}
					%>

				</ul>
				<%
					}
				%>

			</div>
			<!--cat end-->
			<div id="content">
				<div class="content_top">
					<div>
						<img src="${pageContext.request.contextPath}/images/ad-01.jpg"
							alt="9月新品新气象" id="div1" /> <img
							src="${pageContext.request.contextPath}/images/ad-02.jpg"
							alt="流行服饰魅力场" id="div2" /> <img
							src="${pageContext.request.contextPath}/images/ad-03.jpg"
							alt="食全食美" id="div3" /> <img
							src="${pageContext.request.contextPath}/images/ad-04.jpg"
							alt="outlets开张啦" id="div4" />
					</div>
					<div id="adv">
						<a href="JavaScript:show(1);">1</a>&nbsp;<a class="adv"
							href="JavaScript:show(2);">2</a>&nbsp;<a class="adv"
							href="JavaScript:show(3);">3</a>&nbsp;<a class="adv"
							href="JavaScript:show(4);">4</a>
					</div>
				</div>
				<!-- content_top end -->

				<div class="content_list">
					<%
						Set<Product> indexProduct = (Set<Product>) session.getAttribute("indexProduct");
						if (indexProduct == null) {
							response.sendRedirect("ProductController/getInitProduct");
							return;
						}
						for (Product product : indexProduct) {
						Set<Image> images = product.getImages();
					%>
					<dl>
						<dt>
							<img src="upload/<%=((Image)(images.toArray()[0])).getUrl() %>" alt="alt" width="90" height="90" />
						</dt>
						<dd>
							<a href="${pageContext.request.contextPath}/ProductController/getProduct?id=<%=product.getId() %>"><%=product.getName() %></a>
						</dd>
					</dl>
					<%
						}
					%>




				</div>
				<!-- content_list end -->
			</div>
			<!-- content end -->
			<div class="sidebar">
				<div class="r1"></div>
				<div class="r2">
					<dl>
						<dt>
							<img src="${pageContext.request.contextPath}/images/show1.jpg"
								alt="alt" />
						</dt>
						<dd>
							<a href="info.jsp">大牌狂降价，三折直送</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<img src="${pageContext.request.contextPath}/images/show2.jpg"
								alt="alt" />
						</dt>
						<dd>
							<a href="info.jsp">大学要求老师开网店</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<img src="${pageContext.request.contextPath}/images/show5.jpg"
								alt="alt" />
						</dt>
						<dd>
							<a href="info.jsp">黑眼圈推荐，美白不停</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<img src="${pageContext.request.contextPath}/images/show4.jpg"
								alt="alt" />
						</dt>
						<dd>
							<a href="info.jsp">瘦身狂潮风，修形之选</a>
						</dd>
					</dl>
				</div>
				<!--r2	end-->
				<div id="tab">
					<div id="tabtitle1" onmouseover="switchMe(1);"></div>
					<div id="tabtitle2" onmouseover="switchMe(2);"></div>
					<div id="tabbody">
						<img src="images/tabbody2.gif" alt="手机充值" />
					</div>
				</div>
			</div>
			<!--sidebar end-->
		</div>
		<!--main end-->
		<iframe id="footer"
			src="${pageContext.request.contextPath}/footer.jsp" width="980"
			height="150" frameborder="0" scrolling="no"></iframe>
		<div id="pairflag" style="z-index: -2">
			<a class="f_l" href="#" id="advLeft"><img src="images/list1.jpg"
				alt="alt" /></a> <img class="f_l" id="closeLeft" onclick="leftClose();"
				src="images/close.gif" alt="alt" /> <a href="#" class="f_r"
				id="advRight"><img src="images/list2.jpg" alt="alt" /></a> <img
				id="closeRight" class="f_r" onclick="rightClose();"
				src="images/close.gif" alt="alt" />
		</div>
	</div>
	<!--container	end-->
</body>
</html>
