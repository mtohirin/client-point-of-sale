package com.gentara.ui_poin_of_sale.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRes {
    private String id;
    private String name;
    private Integer price;
    private Integer stock;
    private CategoryRes category;
}
