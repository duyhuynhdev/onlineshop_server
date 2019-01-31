package com.hpduy.graphql.onlineshop;
import com.coxautodev.graphql.tools.SchemaParser;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpduy.graphql.onlineshop.POJO.User;
import com.hpduy.graphql.onlineshop.Repository.CategoryRepository;
import com.hpduy.graphql.onlineshop.Repository.ProductRepository;
import com.hpduy.graphql.onlineshop.Repository.UserRepository;
import com.hpduy.graphql.onlineshop.Resolver.Mutation;
import com.hpduy.graphql.onlineshop.Resolver.ProductResolver;
import com.hpduy.graphql.onlineshop.Resolver.Query;
import com.hpduy.graphql.onlineshop.Resolver.SigninResolver;
import com.hpduy.graphql.onlineshop.Util.AuthContext;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.SimpleGraphQLServlet;

import java.util.Optional;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet{
    private static final CategoryRepository categoryRepository;
    private static final ProductRepository productRepository;
    private static final UserRepository userRepository;

    static {
        //Change to `new MongoClient("mongodb://<host>:<port>/hackernews")`
        //if you don't have Mongo running locally on port 27017
        MongoDatabase mongo = new MongoClient().getDatabase("onlineshop");
        categoryRepository = new CategoryRepository(mongo.getCollection("category"));
        productRepository = new ProductRepository(mongo.getCollection("product"));
        userRepository = new UserRepository(mongo.getCollection("user"));
    }
    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                        new Query(categoryRepository, productRepository, userRepository),
                        new Mutation(categoryRepository, productRepository, userRepository),
                        new ProductResolver(categoryRepository),
                        new SigninResolver())
                .build()
                .makeExecutableSchema();
    }

    @Override
    protected GraphQLContext createContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
        User user = request
                .map(req -> req.getHeader("Authorization"))
                .filter(id -> !id.isEmpty())
                .map(id -> id.replace("Duy ", ""))
                .map(userRepository::findById)
                .orElse(null);
        return new AuthContext(user, request, response);
    }

}
