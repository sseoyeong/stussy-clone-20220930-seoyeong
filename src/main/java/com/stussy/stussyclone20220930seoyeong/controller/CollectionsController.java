package com.stussy.stussyclone20220930seoyeong.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CollectionsController {

    @GetMapping("/collections/{category}")
    public String loadCollections(@PathVariable String category) {
        return "Product/collections_scroll";
    }
}
