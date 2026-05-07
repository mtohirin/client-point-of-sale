package com.gentara.ui_poin_of_sale.controller;

import com.gentara.ui_poin_of_sale.model.request.ProductReq;
import com.gentara.ui_poin_of_sale.model.response.ProductRes;
import com.gentara.ui_poin_of_sale.service.CategoryService;
import com.gentara.ui_poin_of_sale.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("/pages/product/index");
        List<ProductRes> result = this.productService.getAll();
        mav.addObject("data", result);
        return mav;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView getById(@PathVariable("id")String id){
        ProductRes model = this.productService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/product");
        }
        ModelAndView mav = new ModelAndView("pages/product/detail");
        mav.addObject("product", model);
        return mav;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("pages/product/add");
        mav.addObject("product", new ProductRes());
        mav.addObject("categories", this.categoryService.getAll());
        return mav;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductReq request){
        if (request.getName() == ""){
            return new ModelAndView("redirect:/product");
        }
        this.productService.save(request);
        return new ModelAndView("redirect:/product");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ProductRes model = this.productService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/product");
        }
        ModelAndView mav = new ModelAndView("pages/product/edit");
        mav.addObject("product", model);
        mav.addObject("categories", this.categoryService.getAll());
        return mav;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductReq request){
        if (request.getName() == ""){
            return new ModelAndView("redirect:/product");
        }
        this.productService.update(request.getId(), request);
        return new ModelAndView("redirect:/product");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id){
        ProductRes productRes = this.productService.getById(id);
        if (productRes == null){
            return new ModelAndView("redirect:/product");
        }
        ModelAndView mav = new ModelAndView("pages/product/delete");
        mav.addObject("product", productRes);
        return mav;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute ProductReq request){
        this.productService.delete(request.getId());
        return new ModelAndView("redirect:/product");
    }
}
