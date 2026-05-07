package com.gentara.ui_poin_of_sale.service;

import com.gentara.ui_poin_of_sale.constant.BackEndUrl;
import com.gentara.ui_poin_of_sale.model.request.ProductReq;
import com.gentara.ui_poin_of_sale.model.response.ProductRes;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private RestTemplate restTemplate;
    private BackEndUrl backEndUrl;
    private ObjectMapper objectMapper;

    public ProductServiceImpl(RestTemplate restTemplate, BackEndUrl backEndUrl, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.backEndUrl = backEndUrl;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ProductRes> getAll() {
        try {
            String url = backEndUrl.productUrl();
            ProductRes[] response = restTemplate.getForObject(url, ProductRes[].class);
            return response != null ? Arrays.asList(response) : Collections.emptyList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductRes getById(String id) {
        try {
            String url = Strings.concat(backEndUrl.productUrl(), "/" + id);
            ProductRes response = restTemplate.getForObject(url, ProductRes.class);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductRes save(ProductReq request) {
        try {
            String url = backEndUrl.productUrl();
            ProductRes res = restTemplate.postForObject(url, request, ProductRes.class);
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductRes update(String id, ProductReq request) {
        try {
            String url = Strings.concat(backEndUrl.productUrl(), "/" + id);
            ProductRes response = restTemplate.patchForObject(url, request, ProductRes.class);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductRes delete(String id) {
        try {
            String url = Strings.concat(backEndUrl.productUrl(), "/" + id);
            restTemplate.delete(url);
            return null;
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }
}
