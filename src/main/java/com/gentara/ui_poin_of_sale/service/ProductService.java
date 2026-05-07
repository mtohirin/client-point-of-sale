package com.gentara.ui_poin_of_sale.service;

import com.gentara.ui_poin_of_sale.model.request.ProductReq;
import com.gentara.ui_poin_of_sale.model.response.ProductRes;

import java.util.List;

public interface ProductService {
    List<ProductRes> getAll();
    ProductRes getById(String id);
    ProductRes save(ProductReq request);
    ProductRes update(String id, ProductReq request);
    ProductRes delete(String id);
}
