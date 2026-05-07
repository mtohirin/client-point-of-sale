package com.gentara.ui_poin_of_sale.controller;

import com.gentara.ui_poin_of_sale.model.request.CustomerReq;
import com.gentara.ui_poin_of_sale.model.request.ProductReq;
import com.gentara.ui_poin_of_sale.model.response.CustomerRes;
import com.gentara.ui_poin_of_sale.model.response.ProductRes;
import com.gentara.ui_poin_of_sale.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("pages/customer/index");
        List<CustomerRes> result = this.customerService.getAll();
        mav.addObject("customer", result);
        return mav;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView getById(@PathVariable("id")String id){
        CustomerRes model = this.customerService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/customer");
        }
        ModelAndView mav = new ModelAndView("pages/customer/detail");
        mav.addObject("customer", model);
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("pages/customer/add");
        mav.addObject("customer", new CustomerRes());
        return mav;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CustomerReq request){
        if (request.getName() == ""){
            return new ModelAndView("redirect:/customer");
        }
        this.customerService.save(request);
        return new ModelAndView("redirect:/customer");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        CustomerRes model = this.customerService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/customer");
        }
        ModelAndView mav = new ModelAndView("pages/customer/edit");
        mav.addObject("customer", model);
        return mav;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CustomerReq request){
        if (request.getName() == ""){
            return new ModelAndView("redirect:/customer");
        }
        this.customerService.update(request.getId(), request);
        return new ModelAndView("redirect:/product");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id){
        CustomerRes model = this.customerService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/customer");
        }
        ModelAndView mav = new ModelAndView("pages/customer/delete");
        mav.addObject("customer", model);
        return mav;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute CustomerReq request){
        this.customerService.delete(request.getId());
        return new ModelAndView("redirect:/customer");
    }
}
