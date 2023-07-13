package com.example.zadanie21;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Chleb", 5.99, Category.FOOD));
        products.add(new Product("Szynka wiejska", 8.99, Category.FOOD));
        products.add(new Product("Domestos", 12.99, Category.HOME));
        products.add(new Product("T-shirt", 40.99, Category.OTHER));
        products.add(new Product("Mysz optyczna", 125.00, Category.OTHER));
        products.add(new Product("Czajnik", 95.99, Category.HOME));
    }

    public List<Product> findAll() {
        return products;
    }

    public double calculateSumForProducts(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> filterProductsByCategory(Category category) {
        List<Product> filteredList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }
}
