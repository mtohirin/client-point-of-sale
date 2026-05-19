package com.gentara.ui_poin_of_sale.service;

import com.gentara.ui_poin_of_sale.constant.BackEndUrl;
import com.gentara.ui_poin_of_sale.model.request.OrderReq;
import com.gentara.ui_poin_of_sale.model.response.OrderRes;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private RestTemplate restTemplate;
    private BackEndUrl backEndUrl;
    private ObjectMapper objectMapper;

    public OrderServiceImpl(RestTemplate restTemplate, BackEndUrl backEndUrl, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.backEndUrl = backEndUrl;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<OrderRes> getAll() {
        try {
            String url = backEndUrl.orderUrl();
            OrderRes[] response = restTemplate.getForObject(url, OrderRes[].class);
            return response != null ? Arrays.asList(response) : Collections.emptyList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderRes getById(String id) {
        try {
            String url = Strings.concat(backEndUrl.orderUrl(), "/" + id);
            OrderRes response = restTemplate.getForObject(url, OrderRes.class);
            return response;
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderRes save(OrderReq request) {
        try {
            String url = backEndUrl.orderUrl();
            OrderRes response = restTemplate.postForObject(url, request, OrderRes.class);
            return response;
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderRes update(String id, OrderReq request) {
        return null;
    }

    @Override
    public OrderRes delete(String id) {
        try {
            String url = Strings.concat(backEndUrl.orderUrl(), "/" + id);
            restTemplate.delete(url);
            return null;
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }
}
