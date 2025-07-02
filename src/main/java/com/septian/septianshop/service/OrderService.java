package com.septian.septianshop.service;

import com.septian.septianshop.model.entity.OrderEntity;
import com.septian.septianshop.model.response.GetAllOrderResponse;
import com.septian.septianshop.model.response.OrderResponse;
import com.septian.septianshop.model.response.StatusResponse;
import com.septian.septianshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder() {
        List<OrderEntity> orderEntityList = new ArrayList<>();
        orderEntityList.add(new OrderEntity(
                "1001","Kursi", BigDecimal.valueOf(35000), "Andre",
                0, LocalDateTime.now(),"Andre",LocalDateTime.now()
        ));

        orderEntityList.add(new OrderEntity(
                "1002","Meja", BigDecimal.valueOf(100000), "Andre",
                1, LocalDateTime.now(),"Andre",LocalDateTime.now()
        ));

        orderEntityList.add(new OrderEntity(
                "1001","Kursi", BigDecimal.valueOf(25000), "Melly",
                1, LocalDateTime.now(),"Melly",LocalDateTime.now()
        ));

        orderEntityList.add(new OrderEntity(
                "1002","Meja", BigDecimal.valueOf(75000), "Melly",
                0, LocalDateTime.now(),"Melly",LocalDateTime.now()
        ));

        orderEntityList.add(new OrderEntity(
                "1003","Piring", BigDecimal.valueOf(15000), "Melly",
                0, LocalDateTime.now(),"Melly",LocalDateTime.now()
        ));

        orderRepository.saveAll(orderEntityList);
    }

    @Override
    public GetAllOrderResponse getAllData() {
        // Add Data
        if(!orderRepository.existsById(1)){
            addOrder();
        }
        GetAllOrderResponse res = new GetAllOrderResponse();
        List<OrderEntity> listOrderEntity = orderRepository.findAll();
        List<OrderResponse> orderResponseList = listOrderEntity.stream()
                .map(order->{
                    OrderResponse orderRes = new OrderResponse();
                    orderRes.setId(order.getId());
                    orderRes.setProductId(order.getProductId());
                    orderRes.setProductName(order.getProductName());
                    orderRes.setAmount(order.getAmount());
                    orderRes.setCustomerName(order.getCustomerName());
                    orderRes.setStatus(order.getStatus());
                    orderRes.setTransactionDate(order.getTransactionDate());
                    orderRes.setCreateBy(order.getCreateBy());
                    orderRes.setCreateOn(order.getCreateOn());
                    return orderRes;
                }).toList();
        res.setData(orderResponseList);

        List<StatusResponse> statusRes = new ArrayList<>();
        statusRes.add(new StatusResponse(0,"SUCCESS"));
        statusRes.add(new StatusResponse(1,"FAILED"));
        res.setStatus(statusRes);
        return res;
    }
}
