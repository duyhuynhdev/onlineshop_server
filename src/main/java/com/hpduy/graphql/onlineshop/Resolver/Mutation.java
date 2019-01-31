package com.hpduy.graphql.onlineshop.Resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.hpduy.graphql.onlineshop.POJO.*;
import com.hpduy.graphql.onlineshop.Repository.CategoryRepository;
import com.hpduy.graphql.onlineshop.Repository.ProductRepository;
import com.hpduy.graphql.onlineshop.Repository.UserRepository;
import graphql.GraphQLException;

public class Mutation implements GraphQLRootResolver {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    public Mutation(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Category createCategory(String name, String description) {
        Category category = new Category(name, description);
        categoryRepository.addCategory(category);
        return category;
    }

    public Product createProduct(String name, String description, String category_id, double price, int amount, int discount, String currency) {
        Product product = new Product(name, description, price, discount, amount, category_id, currency);
        productRepository.addProduct(product);
        return product;
    }

    public User createUser(String username, String password, String email, String fullname, String phone, String address, int role) {
        User user = new User(username, password, email, fullname, phone, address, role);
        userRepository.addUser(user);
        return user;
    }

    //TODO: encrypt password by BCrypt and implement JWT

    public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByUsername(auth.getUsername());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SigninPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }
}
