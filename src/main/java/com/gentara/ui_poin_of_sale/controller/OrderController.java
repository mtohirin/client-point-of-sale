package com.gentara.ui_poin_of_sale.controller;

import com.gentara.ui_poin_of_sale.model.enums.OrderStatus;
import com.gentara.ui_poin_of_sale.model.enums.PaymentMethod;
import com.gentara.ui_poin_of_sale.model.request.OrderReq;
import com.gentara.ui_poin_of_sale.model.response.OrderRes;
import com.gentara.ui_poin_of_sale.model.response.ProductRes;
import com.gentara.ui_poin_of_sale.service.CustomerService;
import com.gentara.ui_poin_of_sale.service.OrderService;
import com.gentara.ui_poin_of_sale.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    private CustomerService customerService;
    private ProductService productService;

    public OrderController(OrderService orderService, CustomerService customerService, ProductService productService){
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;

    }

    @GetMapping
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("pages/order/index");
        List<OrderRes> result = this.orderService.getAll();
        mav.addObject("order", result);
        return mav;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView getById(@PathVariable("id") String id){
        OrderRes model = this.orderService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/order");
        }
        ModelAndView mav = new ModelAndView("pages/order/detail");
        mav.addObject("order", model);
        return mav;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("pages/order/add");
        mav.addObject("order", new OrderRes());
        mav.addObject("customers", this.customerService.getAll());
        mav.addObject("products", this.productService.getAll());
        mav.addObject("statuses", OrderStatus.PENDING);
        mav.addObject("methods", PaymentMethod.values());
        return mav;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute OrderReq request){
        this.orderService.save(request);
        return new ModelAndView("redirect:/order");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id){
        OrderRes model = this.orderService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/order");
        }
        ModelAndView mav = new ModelAndView("pages/order/delete");
        mav.addObject("orders", model);
        return mav;
    }
    @PostMapping("/remove")
    public ModelAndView delete(@ModelAttribute OrderReq request){
        this.orderService.delete(request.getId());
        return new ModelAndView("redirect:/order");
    }

}
