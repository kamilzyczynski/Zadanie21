package com.example.zadanie21;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ProductController {
    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        Set<Product> products = repository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("sum", repository.calculateSumForProducts(products));
        return "index";
    }

    @PostMapping("/")
    public String addProduct(Product product, Model model) {
        repository.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/lista")
    public String list(@RequestParam(name = "kategoria", required = false) Genre genre, Model model) {
        Set<Product> products;
        if (genre == null) {
            products = repository.findAll();
        } else {
            products = repository.filterProductsByGenre(genre);
        }
        double sum = repository.calculateSumForProducts(products);

        model.addAttribute("products", products);
        model.addAttribute("sum", sum);
        model.addAttribute("genre", genre);

        return "list";
    }

    @GetMapping("/dodaj")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }
}
