package com.gentara.ui_poin_of_sale.model.response;

import com.gentara.ui_poin_of_sale.model.enums.OrderStatus;
import com.gentara.ui_poin_of_sale.model.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRes {
    private String id;
    private String orderNumber;
    private LocalDateTime orderDate;
    private CustomerRes customer;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private List<OrderItemRes> items;
}
