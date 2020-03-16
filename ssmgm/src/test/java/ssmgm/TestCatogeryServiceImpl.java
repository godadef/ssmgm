package ssmgm;



import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yq.cn.dao.entity.Category;
import com.yq.cn.service.ICatogeryService;
import com.yq.cn.service.IUserService;

public class TestCatogeryServiceImpl {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		ICatogeryService catogeryService = (ICatogeryService) context.getBean("catogeryService");
		Set<Category> ps = catogeryService.getpsById();
		for (Category category : ps) {
			System.out.println("父亲"+category.getName()+"的孩子有：");
			Set<Category> children = category.getChildren();
			for (Category category2 : children) {
				System.out.println(category2.getName());
			}
		}
	}
	
	


}
