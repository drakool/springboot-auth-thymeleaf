package com.example.securingweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.securingweb.entities.Product;
import com.example.securingweb.service.ProductService;



@Controller
public class ProductsController {
    
    @Autowired
    ProductService productService;


     @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public String getProductList(Model model) {

        final List<Product> allProducts = productService.findAll(); 
        
        // final WebContext ctx = new WebContext(webExchange, webExchange.getLocale());
        // ctx.setVariable("prods", allProducts);
        
        // model.addAttribute("serverTime", dateFormat.format(new Date()));
        model.addAttribute("prods", allProducts);
        return "product/list.html";
    }

    @PostMapping("/product")
    public Product postProduct(@RequestBody Product product) {
        
        return productService.addProduct(product);
        
    }
    
}
