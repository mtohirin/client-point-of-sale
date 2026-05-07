package com.gentara.ui_poin_of_sale.service;

import com.gentara.ui_poin_of_sale.model.request.OrderReq;
import com.gentara.ui_poin_of_sale.model.response.OrderRes;

import java.util.List;

public interface OrderService {
    List<OrderRes> getAll();
    OrderRes getById(String id);
    OrderRes save(OrderReq request);
    OrderRes update(String id, OrderReq request);
    OrderRes delete(String id);
}
