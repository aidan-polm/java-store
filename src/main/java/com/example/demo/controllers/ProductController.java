package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int productId, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(productId);

        if (product != null && product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productService.save(product);

            redirectAttributes.addFlashAttribute("status", "success");
        } else {
            redirectAttributes.addFlashAttribute("status", "failure");
        }

        return "redirect:/purchaseResult";
    }

    @GetMapping("/purchaseResult")
    public String showPurchaseResult() {
        return "purchaseResult";
    }
}