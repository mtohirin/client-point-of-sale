package com.gentara.ui_poin_of_sale.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductReq {

    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    private Integer price;

    @NotNull(message = "Stock is required")
    private Integer stock;

    @NotBlank(message = "Category ID is required")
    private String categoryId;


}
