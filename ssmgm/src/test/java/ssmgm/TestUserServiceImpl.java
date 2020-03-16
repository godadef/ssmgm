package ssmgm;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yq.cn.dao.entity.Product;
import com.yq.cn.dao.entity.User;
import com.yq.cn.service.IUserService;

public class TestUserServiceImpl {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		IUserService userService = (IUserService) context.getBean("userService");
		User user = userService.getUserById(2L);
		//System.out.println(user.getLoginName()+"=="+user.getEmail());
		
		
		user = userService.getMyProducts(1L);
		if(user!=null){
			Set<Product> products = user.getProducts();
			for (Product product : products) {
				System.out.println(product.getName());
			}
		}
		


	}

}
