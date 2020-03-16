package com.yq.cn.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yq.cn.dao.entity.Product;
import com.yq.cn.service.IProductService;
import com.yq.cn.utils.Page;

@Controller
@RequestMapping("/ProductController")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping("/getInitProduct")
	public String  getInitProduct(HttpSession session) {
		Set<Product> indexProduct = productService.getIndexProduct();
		session.setAttribute("indexProduct", indexProduct);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/getProduct")
	public String  getProduct(long id,HttpSession session) {
		Product product = productService.getProduct(id);
		session.setAttribute("product", product);
		return "redirect:/info.jsp";
	}
	
	@RequestMapping(value = "/getSameProducts", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Page<Product> getSameProducts(int currentPage, int ProductParentId,HttpSession session) {
		List<Product> classProducts = productService.listSameProduct(ProductParentId);
		session.setAttribute("classProducts", classProducts);

		int pageSize=5; 	//默认每页5个数据
		int totalPages = 1;	//默认总共只有一页
		List<Product> pageProductInfo = productService.getProductPageInfo(ProductParentId,currentPage,pageSize);
		int count = productService.countClassProduct(ProductParentId);	//总记录数
		if(count!=0){
			if(count%pageSize == 0){
				totalPages = count%pageSize;
			}else {
				totalPages = count%pageSize+1;
			}
		}
		Page<Product> page = new Page<Product>();
		page.setCount(count);
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		page.setList(pageProductInfo);
		
		return page;
		//return"redirect:/catlist.jsp";
	}
	
	@RequestMapping("/getProductParentId")
	public String  getProductParentId(long ProductParentId,HttpSession session) {
		session.setAttribute("ProductParentId", ProductParentId);
		return "redirect:/catlist.jsp";
	}

}
