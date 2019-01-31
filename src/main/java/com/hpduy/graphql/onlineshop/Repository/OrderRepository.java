package com.hpduy.graphql.onlineshop.Repository;
import com.hpduy.graphql.onlineshop.POJO.Order;
import com.hpduy.graphql.onlineshop.POJO.enums.EOrderStatus;
import com.hpduy.graphql.onlineshop.Util.Scalars;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class OrderRepository {

    private final MongoCollection<Document> orders;

    public OrderRepository(MongoCollection<Document> orders) {
        this.orders = orders;
    }

    public List<Order> findByUserId(String user_id) {
        List<Order> list = new ArrayList<>();
        for (Document doc : orders.find(eq("user_id", user_id))) {
            list.add(order(doc));
        }
        return list;
    }

    public void saveOrder(Order order) {
        Document doc = new Document();
        doc.append("user_id", order.getUser_id());
        doc.append("createdAt", Scalars.dateTime.getCoercing().serialize(order.getCreatedAt()));
        doc.append("delivery_address", order.getDelivery_address());
        doc.append("delivery_time", Scalars.dateTime.getCoercing().serialize(order.getDelivery_time()));
        doc.append("status", order.getStatus().getCode());
        doc.append("note", order.getNote());
        doc.append("invoice_url", order.getInvoice_url());
        orders.insertOne(doc);
        order.setId(doc.get("_id").toString());

    }

    private Order order(Document doc) {
        return new Order(
                doc.get("_id").toString(),
                ZonedDateTime.parse(doc.getString("created_at")),
                doc.getString("user_id"),
                doc.getString("delivery_address"),
                ZonedDateTime.parse(doc.getString("delivery_time")),
                EOrderStatus.findByCode(doc.getInteger("status")),
                doc.getString("note")
                );
    }
}
