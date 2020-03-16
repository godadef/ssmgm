package com.yq.cn.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yq.cn.dao.entity.Product;
import com.yq.cn.dao.entity.User;
import com.yq.cn.service.IUserService;

@Controller
@RequestMapping("/userController")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/getUserById")
	public String getUserById(long id, HttpSession session) {

		User user = userService.getUserById(id);
		session.setAttribute("user", user);
		return "update";
	}

	@RequestMapping("/login")
	public String login(String loginName, String pass, HttpSession session) {
		User user = userService.login(loginName, pass);
		if (user != null) {
			session.setAttribute("user", user);
			return "login_success";
		} else {
			return "login";
		}
	}

	@RequestMapping("/register")
	public String register(User user, HttpSession session, @RequestParam("image") CommonsMultipartFile file)
			throws ParseException, IllegalStateException, IOException {
		String year = user.getNyear();
		String month = user.getNmonth();
		String day = user.getNday();
		String bornDay = year + "-" + month + "-" + day;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(bornDay);
		user.setBornDay(date);

		if(!file.isEmpty()){
			// 得到服务器上传文件的路径
			ServletContext application = session.getServletContext();
			String serverPath = application.getRealPath("/upload");

			// 得到上传文件名
			String fileName = file.getOriginalFilename();
			// 得到上传文件后缀
			String extendName = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			// 得到全球唯一名称
			String uuid = UUID.randomUUID().toString();
			// 拼接成唯一名称
			String onlyName = uuid + extendName;
			file.transferTo(new File(serverPath, onlyName));
			user.setUserImg(onlyName);
		}
		
		
		int rows = userService.insert(user);

		if (rows > 0) {
			session.setAttribute("user", user);
			return "register_success";
		} else {
			return "register";
		}

	}
	
	@RequestMapping("/getUserAndProduct")
	public String getUserAndProduct(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user==null){
			return "login";
		}
		User myProducts = userService.getMyProducts(user.getId());
		session.setAttribute("myProducts", myProducts);
		return "buy";
	}
	
	@RequestMapping("/deleteMyOneProduct")
	public String deleteMyOneProduct(long id,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Map map = new HashMap();
		map.put("userId", user.getId());
		map.put("productId", id);
		userService.deleteMyOneProduct(map);
		User myProducts = userService.getMyProducts(user.getId());
		session.setAttribute("myProducts", myProducts);
		return "redirect:/buy.jsp";
	}
	
	@RequestMapping("/saveProductToMine")
	public String saveProductToMine(long id,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user==null){
			return "login";
		}
		Map map = new HashMap();
		map.put("userId", user.getId());
		map.put("productId", id);
		userService.saveProductToMine(map);
		User myProducts = userService.getMyProducts(user.getId());
		session.setAttribute("myProducts", myProducts);
		return "redirect:/userController/getUserAndProduct";
	}

}
