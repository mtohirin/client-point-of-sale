package com.gentara.ui_poin_of_sale.service;

import com.gentara.ui_poin_of_sale.model.request.CustomerReq;
import com.gentara.ui_poin_of_sale.model.response.CustomerRes;

import java.util.List;

public interface CustomerService {
    List<CustomerRes> getAll();
    CustomerRes getById(String id);
    CustomerRes save(CustomerReq request);
    CustomerRes update(String id, CustomerReq request);
    CustomerRes delete(String id);
}
