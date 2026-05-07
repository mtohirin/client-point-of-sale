package com.gentara.ui_poin_of_sale.service;

import com.gentara.ui_poin_of_sale.constant.BackEndUrl;
import com.gentara.ui_poin_of_sale.model.request.CustomerReq;
import com.gentara.ui_poin_of_sale.model.response.CustomerRes;
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
public class CustomerServiceImpl implements CustomerService{
    private RestTemplate restTemplate;
    private BackEndUrl backEndUrl;
    private ObjectMapper objectMapper;

    public CustomerServiceImpl(RestTemplate restTemplate, BackEndUrl backEndUrl, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.backEndUrl = backEndUrl;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CustomerRes> getAll() {
        try {
            String url = backEndUrl.customerUrl();
            CustomerRes[] response = restTemplate.getForObject(url, CustomerRes[].class);
            return response != null ? Arrays.asList(response) : Collections.emptyList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerRes getById(String id) {
        try {
            String url = Strings.concat(backEndUrl.customerUrl(), "/" + id);
            CustomerRes response = restTemplate.getForObject(url, CustomerRes.class);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerRes save(CustomerReq request) {
        try {
            String url = backEndUrl.customerUrl();
            CustomerRes res = restTemplate.postForObject(url, request, CustomerRes.class);
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerRes update(String id, CustomerReq request) {
        try {
            String url = Strings.concat(backEndUrl.customerUrl(), "/" + id);
            CustomerRes response = restTemplate.patchForObject(url, request, CustomerRes.class);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerRes delete(String id) {
        try {
            String url = Strings.concat(backEndUrl.customerUrl(), "/" + id);
            restTemplate.delete(url);
            return null;
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }
}
