package com.septian.septianshop.controller;

import com.septian.septianshop.model.response.GetAllOrderResponse;
import com.septian.septianshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping("/getAll")
    public ResponseEntity<GetAllOrderResponse> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllData());
    }
}
