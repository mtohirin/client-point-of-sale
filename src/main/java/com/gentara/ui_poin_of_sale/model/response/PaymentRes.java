package com.gentara.ui_poin_of_sale.model.response;

import com.gentara.ui_poin_of_sale.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRes {
    private String orderId;
    private OrderStatus orderStatus;
    private String message;
    private LocalDateTime paidAt;
}
