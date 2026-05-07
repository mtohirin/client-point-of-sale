package com.gentara.ui_poin_of_sale.model.request;

import com.gentara.ui_poin_of_sale.model.enums.OrderStatus;
import com.gentara.ui_poin_of_sale.model.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderReq {
    private String orderNumber;
    private String customerId;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private List<OrderItemReq> items;
}
