package com.gentara.ui_poin_of_sale.service;

import com.gentara.ui_poin_of_sale.model.request.CategoryReq;
import com.gentara.ui_poin_of_sale.model.response.CategoryRes;

import java.util.List;

public interface CategoryService {
    List<CategoryRes> getAll();
    CategoryRes getById(String id);
    CategoryRes create(CategoryReq categoryReq);
    CategoryRes update(String id, CategoryReq categoryReq);
    CategoryRes delete(String id);
}
