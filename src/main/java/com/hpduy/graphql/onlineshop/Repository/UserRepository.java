package com.hpduy.graphql.onlineshop.Repository;

import com.hpduy.graphql.onlineshop.POJO.Category;
import com.hpduy.graphql.onlineshop.POJO.User;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class UserRepository {
    public final MongoCollection<Document> users;

    public UserRepository(MongoCollection<Document> categories) {
        this.users = categories;
    }

    public User findByEmail(String email) {
        Document doc = users.find(eq("email", email)).first();
        return user(doc);
    }

    public User findByUsername(String username) {
        Document doc = users.find(eq("username", username)).first();
        return user(doc);
    }

    public User findById(String id) {
        Document doc = users.find(eq("_id", new ObjectId(id))).first();
        return user(doc);
    }

    public void addUser(User user) {
        Document doc = new Document();
        doc.append("username", user.getUsername());
        doc.append("password",  user.getPassword());
        doc.append("email", user.getEmail());
        doc.append("fullname", user.getFullname());
        doc.append("phone", user.getPhone());
        doc.append("address", user.getAddress());
        doc.append("role", user.getRole());
        users.insertOne(doc);
        user.setId(doc.get("_id").toString());
    }

    private User user(Document doc) {
        if (doc == null) {
            return null;
        }
        return new User(
                doc.get("_id").toString(),
                doc.getString("username"),
                doc.getString("password"),
                doc.getString("email"),
                doc.getString("fullname"),
                doc.getString("phone"),
                doc.getString("address"),
                doc.getInteger("role")
        );
    }
}
