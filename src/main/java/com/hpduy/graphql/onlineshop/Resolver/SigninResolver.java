package com.hpduy.graphql.onlineshop.Resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hpduy.graphql.onlineshop.POJO.SigninPayload;
import com.hpduy.graphql.onlineshop.POJO.User;

public class SigninResolver implements GraphQLResolver<SigninPayload> {
    public User user(SigninPayload payload) {
        return payload.getUser();
    }
}
