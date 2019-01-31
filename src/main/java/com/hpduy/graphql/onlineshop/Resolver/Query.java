package com.hpduy.graphql.onlineshop.Resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.hpduy.graphql.onlineshop.POJO.Category;
import com.hpduy.graphql.onlineshop.POJO.Product;
import com.hpduy.graphql.onlineshop.Repository.CategoryRepository;
import com.hpduy.graphql.onlineshop.Repository.ProductRepository;
import com.hpduy.graphql.onlineshop.Repository.UserRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Query(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public List<Category> allCategories(){
        return categoryRepository.getAllCategories();
    }

    public List<Product> allProducts(){
        return productRepository.getAllProducts();
    }

    public List<Product> allProductsByCategory(String category_id){
        return productRepository.getAllProductsByCategory(category_id);
    }
}
