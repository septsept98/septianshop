package com.septian.septianshop.service;

import com.septian.septianshop.model.response.GetAllOrderResponse;

public interface IOrderService {
    void addOrder();
    GetAllOrderResponse getAllData();
}
