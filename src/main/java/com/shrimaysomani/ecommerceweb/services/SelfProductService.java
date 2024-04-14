package com.shrimaysomani.ecommerceweb.services;

import com.shrimaysomani.ecommerceweb.exceptions.ProductNotFoundException;
import com.shrimaysomani.ecommerceweb.models.Category;
import com.shrimaysomani.ecommerceweb.models.Product;
import com.shrimaysomani.ecommerceweb.repository.CategoryRepository;
import com.shrimaysomani.ecommerceweb.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService") //This is used to tell spring that this is a service class and it should be created as a bean
//@Primary
public class SelfProductService implements ProductService {
    //FakeStoreService fakeStoreService = new FakeStoreService(); Creating obejct this way is a wrong practice as it is tightly coupled
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException(id, "Product not found");
        }
        return product.get();

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of(); //returning empty list
    }

    @Override
    public Product createProduct(Product product) {
         Category category = product.getCategory();
//         Category savedCategory = categoryRepository.save(category);
//         product.setCategory(savedCategory);
        if(category.getId() == null){
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(product1.getCategory().getId());
        product1.setCategory(optionalCategory.get());
        return product1;
    }
}
