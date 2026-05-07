package com.gentara.ui_poin_of_sale.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRes {
    private String id;
    private ProductRes product;
    private Integer quantity;
    private Integer price;
    private Integer subtotal;
}
