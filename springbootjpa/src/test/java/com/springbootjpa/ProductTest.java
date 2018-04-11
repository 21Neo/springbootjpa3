package com.springbootjpa;

import com.springbootjpa.domain.Category;
import com.springbootjpa.domain.Product;
import com.springbootjpa.service.CategoryService;
import com.springbootjpa.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    // step 1
    @Test
    public void saveCategory(){
        Category category = new Category();
        category.setName("电器");
        category.setDescription("电器:需要电");

        categoryService.save(category);
    }

    // step 2
    @Test
    public void saveProduct(){
        Category category = categoryService.findById(16).get();
        Product product = new Product();
        product.setPrice(8900d);
        product.setDescription("省电");
        product.setCategory(category);

        productService.save(product);
    }

    // step 3
    @Test
    public void list(){
        for(Product product : productService.findAll()){
            System.out.println(product.getName()+" "+product.getCategory().getDescription());
        }
    }

}
