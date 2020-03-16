
<%@page import="com.yq.cn.dao.entity.Image"%>
<%@page import="java.util.Set"%>
<%@page import="com.yq.cn.dao.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>贵美商城</title>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/layout.css"	/>
 <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
 <script type="text/JavaScript">
 	function multiCheck(oThis){
 		var oInput=document.getElementsByTagName("input");
 		for (var i=1;i<oInput.length;i++){ 	
 				oInput[i].checked=oThis.checked;}
 	}
 	/* $(function(){
		var newNode=$("<li><input type='checkbox' /></li>");
 		$(".check").append(newNode);
 	}) */
 	
 	$().ready(function(){
			var currentPage = 1;//默认第一页
			var pageSize=5; 	//默认每页5个数据
			var count = 0; 		//初始总记录数为0
			var totalPages = 1;	//默认总共只有一页
			//初始化
			show();
			
			/* $('#firstPage').live('click',function(){
				currentPage = 1;
				show();
			});
			
			$('#lastPage').live('click',function(){
				currentPage = totalPages;
				show();
			});
			
			$('.middPage').live('click', function() {
				currentPage = $(this).text().trim();
				show();
			}); */
			
			//ajax方法，异步局部刷新
			function show(){
				<%
				long pid = (Long)session.getAttribute("ProductParentId");
				%>
				var ProductParentId = <%=pid%>;
				$.getJSON("ProductController/getSameProducts", { currentPage: currentPage,ProductParentId:ProductParentId },function(page){
		  			alert("lk");
					totalPages = page.getTotalPages()//获取总页数
		  			currentPage = page.getCurrentPage();//获取当前页码
		  			pageSize = page.getPageSize();//获取每页的图片数量
		  			count = page.getCount();//获取总记录数
		  			alert(count);
		  			var photoDiv="";
		  			$.each(pageClassProducts.getList,function(i,j){//获取遍历的内容
		  				photoDiv+= "<li><input type='checkbox' /></li>";
			  			$(".check").append(photoDiv);
			  			photoDiv="";
		  				
			  		});
		  			
		  			/* photoDiv+="</div>";
					$("#photo").html(photoDiv);
				
					var pagination="";
					if(currentPage==1){
						pagination = "<li id='disable'><a href='###'>首页</a></li>";
					}
					else{
						pagination = "<li id='firstPage' class='bgcgreen'><a href='###'>首页</a></li>";
					}
		  			for(var i = currentPage-3 ; i <= currentPage+3 ; i++){
						if(i>=1 && i<=totalPages){
							if(i == currentPage){
								pagination+="<li class='default'><a href='###'>" + i + "</a></li>";
							}
							else{
								pagination+="<li class='bgcgreen'><a class='middPage' href='###'>" + i + "</a></li>";
							}
						}
		  			}
 		  			if(currentPage==totalPages){
		  				pagination+="<li id='disable'><a href='###'>尾页</a></li>"
		  			}
		  			else{
		  				pagination+="<li id='lastPage' class='bgcgreen'><a href='###'>尾页</a></li>"
		  			}
				    $(".pagination").html(pagination);*/

				}); 
			}
		});
	</script>
</head>
<body>
<%
List<Product> classProducts = (List<Product>)session.getAttribute("classProducts");
%>
<div id="container">
	<iframe id="header" runat="server" src="${pageContext.request.contextPath}/header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	<div class="catlist a_c">
	
		<ul class="w20p check">
			<h3><input type="checkbox" name="checkall" onclick="multiCheck(this)" />全选</h3>
			<%-- <%
				if(classProducts!=null){
					for(int i = 0 ; i < classProducts.size() ; i ++){
						out.print("<li><input type='checkbox' /></li>");
					}
				}
				
			%> --%>
		</ul>
		<ul class="w20p">
			<h3>商品图片</h3>
			<%
			if(classProducts!=null){
				for(int i = 0 ; i < classProducts.size() ; i ++){
					Set<Image> images = classProducts.get(i).getImages();
					for(Image image : images){
						out.print("<li><a href='ProductController/getProduct?id="+classProducts.get(i).getId()+"'><img width=90 height=90 src='upload/"+image.getUrl()+"'/></a></li>");
					}
					
				}
			}
			
			%>
			
			
		</ul>
		<ul class="w50p info">
			<h3>商品名称/出售者/联系方式</h3>
			<%
			if(classProducts!=null){
				for(int i = 0 ; i < classProducts.size() ; i ++){
					out.print("<li><a href='ProductController/getProduct?id="+classProducts.get(i).getId()+"'>"+classProducts.get(i).getName()+"</a><br />出售者：<a href='#'>"+classProducts.get(i).getSeller()+"</a><br /><a href='#'><img src='images/contactme.gif'/>&nbsp;<img src='images/addfav.gif'/>&nbsp;收藏</a></li>");
				}
			}
			
			%>
			
		</ul>
		<ul class="w10p price">
			<h3>价格</h3>
			<%
			if(classProducts!=null){
				for(int i = 0 ; i < classProducts.size() ; i ++){
					out.print("<li>一口价：<br />"+classProducts.get(i).getPrice()+"</li>");		
				}
			}
				
			%>
			
		</ul>
	</div>
	<iframe id="footer"  src="${pageContext.request.contextPath}/footer.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
</div> <!--container end-->	
</body>
</html>
