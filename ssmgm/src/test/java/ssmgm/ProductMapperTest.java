package ssmgm;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yq.cn.dao.ProductMapper;
import com.yq.cn.dao.entity.Image;
import com.yq.cn.dao.entity.Product;
import com.yq.cn.service.IProductService;
import com.yq.cn.utils.Page;

public class ProductMapperTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		IProductService productService = (IProductService) context.getBean("productService");
//		Set<Product> indexProduct = productService.getIndexProduct();
//		for (Product product : indexProduct) {
//			Set<Image> images = product.getImages();
//			System.out.println(((Image)(images.toArray()[0])).getUrl());
//		}
		
//		Product product = productService.getProduct(1);
//		System.out.println(product.getName());
//		Set<Image> images = product.getImages();
//		for (Image image : images) {
//			System.out.println(image.getUrl());
//		}
		
//		List<Product>  products = productService.listSameProduct(1);
//		for (Product product : products) {
//			Set<Image> images = product.getImages();
//			for (Image image : images) {
//				System.out.print(image.getId()+"\t"+image.getProductId()+"\t"+image.getUrl()+"\t");
//			}
//			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getPrice()+"\t"+product.getSeller());
//		}
		
//		List<Product> productPageInfo = productService.getProductPageInfo(1, 1, 5);
//		
//		for (Product product : productPageInfo) {
//			Set<Image> images = product.getImages();
//			for (Image image : images) {
//				System.out.print(image.getId()+"\t"+image.getProductId()+"\t"+image.getUrl()+"\t");
//			}
//			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getPrice()+"\t"+product.getSeller());
//		}
		
		int count = productService.countClassProduct(1);
		System.out.println(count);
		
		
		
		
		

	}

}
