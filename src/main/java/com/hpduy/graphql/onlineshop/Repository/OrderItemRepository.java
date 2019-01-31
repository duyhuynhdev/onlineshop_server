package com.hpduy.graphql.onlineshop.Repository;

import com.hpduy.graphql.onlineshop.POJO.OrderItem;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class OrderItemRepository {

    private final MongoCollection<Document> order_items;

    public OrderItemRepository(MongoCollection<Document> order_items) {
        this.order_items = order_items;
    }

    public List<OrderItem> findByOrderId(String order_id) {
        List<OrderItem> list = new ArrayList<>();
        for (Document doc : order_items.find(eq("order_id", order_id))) {
            list.add(order_item(doc));
        }
        return list;
    }

    public void saveOrderItem(OrderItem order_item) {
        Document doc = new Document();
        doc.append("product_id", order_item.getProduct_id());
        doc.append("amount", order_item.getAmount());
        doc.append("price", order_item.getPrice());
        doc.append("order_id", order_item.getOrder_id());
        order_items.insertOne(doc);
        order_item.setId(doc.get("_id").toString());

    }

    private OrderItem order_item(Document doc) {
        return new OrderItem(
                doc.get("_id").toString(),
                doc.getString("product_id"),
                doc.getInteger("amount"),
                doc.getDouble("price"),
                doc.getString("order_id")
        );
    }
}
