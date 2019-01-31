package com.hpduy.graphql.onlineshop.Repository;

import com.hpduy.graphql.onlineshop.POJO.Product;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ProductRepository{
    public final MongoCollection<Document> products;

    public ProductRepository(MongoCollection<Document> categories) {
        this.products = categories;
    }

    public Product findById(String id) {
        Document doc = products.find(eq("_id", new ObjectId(id))).first();
        return product(doc);
    }

    public List<Product> getAllProducts(){
        List<Product> allProducts = new ArrayList<>();
        for (Document doc : products.find()) {
            allProducts.add(product(doc));
        }
        return allProducts;
    }
    public List<Product> getAllProductsByCategory(String category_id){
        List<Product> allProducts = new ArrayList<>();
        for (Document doc : products.find(eq("category_id", category_id))) {
            allProducts.add(product(doc));
        }
        return allProducts;
    }
    private Product product(Document doc) {
        if (doc == null) {
            return null;
        }
        return new Product(
                doc.get("_id").toString(),
                doc.getString("name"),
                doc.getString("description"),
                doc.getDouble("price"),
                doc.getInteger("discount"),
                doc.getInteger("amount"),
                doc.getString("category"),
                doc.getString("currency"));
    }

    public void addProduct(Product product){
        Document doc = new Document();
        doc.append("name", product.getName());
        doc.append("description", product.getDescription());
        doc.append("price", product.getPrice());
        doc.append("discount", product.getDiscount());
        doc.append("amount", product.getAmount());
        doc.append("category_id", product.getCategoryId());
        doc.append("currency", product.getCurrency());
        products.insertOne(doc);
        //update id after insert
        product.setId(doc.get("_id").toString());
    }
}
