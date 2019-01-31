package com.hpduy.graphql.onlineshop.Repository;

import com.hpduy.graphql.onlineshop.POJO.Category;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

public class CategoryRepository {
    public final MongoCollection<Document> categories;

    public CategoryRepository(MongoCollection<Document> categories) {
        this.categories = categories;
    }

    public Category findById(String id) {
        Document doc = categories.find(eq("_id", new ObjectId(id))).first();
        return category(doc);
    }

    public List<Category> getAllCategories(){
        List<Category> allCategories = new ArrayList<>();
        for (Document doc : categories.find()) {
            allCategories.add(category(doc));
        }
        return allCategories;
    }

    private Category category(Document doc) {
        if (doc == null) {
            return null;
        }
        return new Category(
                doc.get("_id").toString(),
                doc.getString("name"),
                doc.getString("description"));
    }

    public void addCategory(Category category){
        Document doc = new Document();
        doc.append("name", category.getName());
        doc.append("description", category.getDescription());
        categories.insertOne(doc);
        //update id after insert
        category.setId(doc.get("_id").toString());
    }
}
