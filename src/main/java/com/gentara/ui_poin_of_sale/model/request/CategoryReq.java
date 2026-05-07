package com.gentara.ui_poin_of_sale.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReq {
    private String id;

    @NotBlank(message = "Name is required")
    private String name;
}
