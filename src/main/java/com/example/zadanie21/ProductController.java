package com.example.zadanie21;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/")
    public String addProduct(Product product) {
        repository.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/lista")
    public String list(@RequestParam(name = "kategoria", required = false) String cat, Model model) {
        List<Product> products;
        Category category = null;

        for (Category value : Category.values()) {
            if (value.getTranslation().equals(cat)) {
                category = value;
                break;
            }
        }

        if (category == null) {
            products = repository.findAll();
        } else {
            products = repository.filterProductsByCategory(category);
        }
        double sum = repository.calculateSumForProducts(products);

        model.addAttribute("products", products);
        model.addAttribute("sum", sum);
        model.addAttribute("category", category);

        return "list";
    }

    @GetMapping("/dodaj")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }
}
