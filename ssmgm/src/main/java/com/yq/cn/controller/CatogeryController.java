package com.yq.cn.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yq.cn.dao.entity.Category;
import com.yq.cn.service.ICatogeryService;

@Controller
@RequestMapping("/CatogeryController")
public class CatogeryController {
	@Autowired
	ICatogeryService catogeryService;
	
	@RequestMapping("/getCatogerys")
	public String getCatogerys(HttpSession session) {
		Set<Category> ps = catogeryService.getpsById();
		session.setAttribute("ps", ps);
		return "redirect:/index.jsp";
	}
	
	

}
