package com.hpduy.graphql.onlineshop.Resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hpduy.graphql.onlineshop.POJO.Order;
import com.hpduy.graphql.onlineshop.POJO.OrderItem;
import com.hpduy.graphql.onlineshop.Repository.OrderItemRepository;

import java.util.List;

public class OrderResolver implements GraphQLResolver<Order> {
    private final OrderItemRepository orderItemRepository;

    public OrderResolver(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> orderItemList(Order order) {
        if (order.getId() == null) {
            return null;
        }
        return orderItemRepository.findByOrderId(order.getId());
    }
}
