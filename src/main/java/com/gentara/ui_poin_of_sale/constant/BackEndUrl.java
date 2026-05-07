package com.gentara.ui_poin_of_sale.constant;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class BackEndUrl {
    @Value("http://localhost:8085/api")
    private String baseUrl;

    public String categoryUrl(){
      return  Strings.concat(baseUrl, "/category");
    }
    public String productUrl(){
        return  Strings.concat(baseUrl, "/product");
    }
    public String customerUrl(){
        return  Strings.concat(baseUrl, "/customer");
    }
    public String orderUrl(){
        return  Strings.concat(baseUrl, "/order");
    }
}
