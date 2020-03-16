package com.yq.cn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yq.cn.dao.entity.Order;
import com.yq.cn.dao.entity.OrderDetail;
import com.yq.cn.dao.entity.Product;
import com.yq.cn.dao.entity.User;
import com.yq.cn.service.IOrderDetailService;
import com.yq.cn.service.IOrderService;
import com.yq.cn.service.IUserService;

@Controller
@RequestMapping("/OrderDetailController")
public class OrderDetailController {
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@Autowired
	private IUserService userService;
	
	
	@RequestMapping("/saveOrderAndOrderDetail")
	public void saveOrderAndOrderDetail(Order order,String[] productId,String[] buyNum,String[] price,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		User user = (User) session.getAttribute("user");
		if(order!=null&&productId!=null){
			//插入tbl_order
			order.setPhone(order.getCode()+order.getTelnumber()+order.getBranchnumber());
			order.setUserId(user.getId());
			orderService.insert(order);
			
			//插入tbl_order_detail
			List<OrderDetail> list = new ArrayList<OrderDetail>();
			for(int i=0;i<productId.length;i++){
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setBuyNum(Integer.parseInt(buyNum[i]));
				orderDetail.setPrice(Float.parseFloat(price[i]));
				orderDetail.setProductId(Long.parseLong(productId[i]));
				orderDetail.setOrderId(order.getId());
				list.add(orderDetail);
			}
			orderDetailService.insert(list);
			//修改tbl_product_user表对应用户id的数据为空
			userService.deleteMyProducts(user.getId());
		}
		
		//重新查询个人产品
		User myProducts = userService.getMyProducts(user.getId());
		session.setAttribute("myProducts", myProducts);
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write("<script type=\"text/javascript\">");
			out.write("alert(\"提交成功\");");
			out.write("window.location.href=\"toBuy\";");
			out.write("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/toBuy")
	public String toBuy(){
		return  "redirect:/buy.jsp";
	}

}
