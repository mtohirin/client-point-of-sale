package com.gentara.ui_poin_of_sale.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class DashboardController {
    @GetMapping("/")
    public ModelAndView dashboard(){
        return new ModelAndView("pages/dashboard/index");
    }
    @GetMapping("/product")
    public ModelAndView product(){
        return new ModelAndView("pages/product/index");
    }
    @GetMapping("/add-product")
    public ModelAndView addProduct(){
        return new ModelAndView("pages/product/add");
    }
    @GetMapping("/category-list")
    public ModelAndView categoryList() {
        return new ModelAndView("pages/product/category-list");
    }
    @GetMapping("/customer")
    public ModelAndView customer(){
        return new ModelAndView("pages/customer/index");
    }
}