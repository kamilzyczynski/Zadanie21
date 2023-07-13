package com.example.zadanie21;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProductRepository {
    Set<Product> products;

    public ProductRepository() {
        products = new HashSet<>();
        products.add(new Product("Chleb", 5.99, Genre.SPOŻYWCZE));
        products.add(new Product("Szynka wiejska", 8.99, Genre.SPOŻYWCZE));
        products.add(new Product("Domestos", 12.99, Genre.DOMOWE));
        products.add(new Product("T-shirt", 40.99, Genre.INNE));
        products.add(new Product("Mysz optyczna", 125.00, Genre.INNE));
        products.add(new Product("Czajnik", 95.99, Genre.DOMOWE));
    }

    public Set<Product> findAll() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public double calculateSumForProducts(Set<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Set<Product> filterProductsByGenre(Genre genre) {
        Set<Product> filteredSet = new HashSet<>();
        for (Product product : products) {
            if (product.getGenre().equals(genre)) {
                filteredSet.add(product);
            }
        }
        return filteredSet;
    }
}
