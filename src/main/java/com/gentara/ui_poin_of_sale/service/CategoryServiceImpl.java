package com.gentara.ui_poin_of_sale.service;

import com.gentara.ui_poin_of_sale.constant.BackEndUrl;
import com.gentara.ui_poin_of_sale.model.request.CategoryReq;
import com.gentara.ui_poin_of_sale.model.response.CategoryRes;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private RestTemplate restTemplate;
    private BackEndUrl backEndUrl;
    private ObjectMapper objectMapper;

    public CategoryServiceImpl(RestTemplate restTemplate, BackEndUrl backEndUrl, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.backEndUrl = backEndUrl;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CategoryRes> getAll() {
        try {
            String url = backEndUrl.categoryUrl();
            CategoryRes[] response = restTemplate.getForObject(url, CategoryRes[].class);
            return response != null ? Arrays.asList(response) : Collections.emptyList();
        } catch (RestClientException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public CategoryRes getById(String id) {
        try {
            String url = Strings.concat(backEndUrl.categoryUrl(), "/" + id);
            CategoryRes response = restTemplate.getForObject(url, CategoryRes.class);
            return response;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public CategoryRes create(CategoryReq categoryReq) {
        try {
            String url = backEndUrl.categoryUrl();
            CategoryRes response = this.restTemplate.postForObject(url, categoryReq, CategoryRes.class);
            return response;
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public CategoryRes update(String id, CategoryReq categoryReq) {
        try {
            String url = Strings.concat(backEndUrl.categoryUrl(), "/" + id);
            CategoryRes res = restTemplate.patchForObject(url, categoryReq, CategoryRes.class);
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CategoryRes delete(String id) {
        try {
            String url = Strings.concat(backEndUrl.categoryUrl(), "/" + id);
            restTemplate.delete(url);
            return null;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
