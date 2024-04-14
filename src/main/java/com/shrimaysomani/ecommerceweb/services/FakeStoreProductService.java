package com.shrimaysomani.ecommerceweb.services;

import com.shrimaysomani.ecommerceweb.DTOS.FakeStoreProductDTO;
import com.shrimaysomani.ecommerceweb.models.Category;
import com.shrimaysomani.ecommerceweb.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id){//chef (actual logic)
        //Call the fakestore API to get the product with given id
         throw new RuntimeException("Something went wrong");
//       j RestTemplate restTemplate = new RestTemplate();
//        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+ id, FakeStoreProductDTO.class);
//
//        //convert fakestoreproductdto object to product object
//        if(fakeStoreProductDTO == null){
//            return null;
//        }
//        return convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }

    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        //java says there is no point of generics after compiling so during runtime we need not to mention the generics(<content inside this >) so it is better to use arrays ..

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
            products.add(convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product convertFakeStoreProductDTOtoProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());
        Category category = new Category();
        category.setDescription(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }

}
