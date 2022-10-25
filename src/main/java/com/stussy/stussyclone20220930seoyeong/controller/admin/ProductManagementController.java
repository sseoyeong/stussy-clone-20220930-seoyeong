package com.stussy.stussyclone20220930seoyeong.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProductManagementController {

    @GetMapping("/product/register")
    public String logProductRegister() {
        return "admin/product_registration";
    }

    @GetMapping("/product/register/dtl")
    public String loadProductRegister() {
        return "admin/product_dtl_registration";
    }

}
