<%@page import="com.yq.cn.dao.entity.Image"%>
<%@page import="com.yq.cn.dao.entity.Product"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>贵美商城-商品分类页</title>
 <link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="css/layout.css"	/>
 <script type="text/JavaScript" defer="true">
	var oImg=document.getElementById("show").getElementsByTagName("img");
	for(var i=1;i<=(oImg.length-3);i++){
		oImg[i].onmouseover=function(){oImg[0].src=this.src.replace('.jpg','_big.jpg');
			this.style.border='2px #ff7300 solid';}
		oImg[i].onmouseout=function(){this.style.border='2px #ccc solid';}
 	}
 </script>
</head>
<body>
<div id="container">
	<iframe id="header" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	
	<%
	Product product = (Product)session.getAttribute("product");
	if(product == null){
		response.sendRedirect("ProductController/getProduct");
		return;
	}
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(product.getExpireTime());
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
	%>
	<div class="good">
		<h1><%=product.getName() %></h1>
		<ul class="f_l" id="show" style="padding-right:80px">
			<%
				int i=0;
			Set<Image> images = product.getImages();
			for(Image image : images){
				if(i==0){
					out.print("<li class='bigimg'><a href='userController/saveProductToMine?id="+product.getId()+"'><img width=380 height=300 src='upload/"+image.getUrl()+"'/></a></li>");
					i++;
				}else{
					out.print("<li class='smallimg'><img width=50 height=50 src='upload/"+image.getUrl()+"'/></li>");
				}
				
			}
				
			%>
		</ul>
		<ul class="goodinfo f_l">
			<li>一 口 价：<span><%=product.getPrice() %>元 </span></li>
			<li>运　　费：<span><%=product.getFreight()<=0?"免运费":product.getFreight() %></span></li>
			<li class="h74 buynow"><a href="userController/saveProductToMine?id=<%=product.getId() %>"><img src="images/buynow.gif" alt="alt" /></a></li>
			<li class="onlinepay">此商品支持<a href="#">网银支付</a>，网上汇款免手续费。<br />收货满意后出售者才能拿钱，货款都安全！</li>
			<li>剩余时间：<span><%=month%>月<%=day%>日</span></li>
			<li>累计售出：<span><%=product.getSellNum()%>件</span></li>
			<li class="f_l w175">商品类型：<span>全新</span></li>
			<li>所 在 地：<span><%=product.getSellAddress() %></span></li>
			<li class="f_l w175">商品库存：<span><%=product.getStockNum() %>件</span></li>
			<li>浏 览 量：<span><%=product.getViewNum() %>次</span></li>	
		</ul>
	</div>
	<iframe id="footer" src="footer.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
</div> <!--container end-->	
</body>
</html>
