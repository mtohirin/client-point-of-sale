package com.gentara.ui_poin_of_sale.controller;

import com.gentara.ui_poin_of_sale.model.request.CategoryReq;
import com.gentara.ui_poin_of_sale.model.response.CategoryRes;
import com.gentara.ui_poin_of_sale.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController (CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("/pages/category/index");
        List<CategoryRes> result = this.categoryService.getAll();
        mav.addObject("data", result);
        return mav;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView getById(@PathVariable("id") String id){
        CategoryRes model = this.categoryService.getById(id);
        if (model == null ){
            return new ModelAndView("/pages/category/detail");
        }
        ModelAndView mav = new ModelAndView("pages/category/detail");
        mav.addObject("category", model);
        return mav;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("/pages/category/add");
        mav.addObject("category", new CategoryReq());
        return mav;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CategoryReq request){
        if (request.getName() == ""){
            return new ModelAndView("redirect:/category");
        }
        this.categoryService.create(request);
        return new ModelAndView("redirect:/category");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        CategoryRes model = this.categoryService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/category");
        }
        ModelAndView mav = new ModelAndView("/pages/category/edit");
        mav.addObject("category", model);
        return mav;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CategoryReq request){
        if (request.getId() == ""){
            return new ModelAndView("redirect:/category");
        }
        this.categoryService.update(request.getId(), request);
        return new ModelAndView("redirect:/category");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        CategoryRes categoryRes = this.categoryService.getById(id);
        if (categoryRes == null){
            return new ModelAndView("redirect:/category");
        }
        ModelAndView view = new ModelAndView("/pages/category/delete");
        view.addObject("category", categoryRes);
        return view;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute CategoryReq request){
        this.categoryService.delete(request.getId());
        return new ModelAndView("redirect:/category");
    }
}
