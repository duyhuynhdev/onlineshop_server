package com.hpduy.graphql.onlineshop.Resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hpduy.graphql.onlineshop.POJO.Category;
import com.hpduy.graphql.onlineshop.POJO.Product;
import com.hpduy.graphql.onlineshop.Repository.CategoryRepository;

public class ProductResolver  implements GraphQLResolver<Product> {
    private final CategoryRepository categoryRepository;

    public ProductResolver(CategoryRepository userRepository) {
        this.categoryRepository = userRepository;
    }

    public Category category(Product product) {
        if (product.getCategoryId() == null) {
            return null;
        }
        return categoryRepository.findById(product.getCategoryId());
    }
}
