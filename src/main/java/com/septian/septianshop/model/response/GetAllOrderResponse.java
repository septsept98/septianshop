package com.septian.septianshop.model.response;

import java.util.List;

public class GetAllOrderResponse {
    private List<OrderResponse> data;
    private List<StatusResponse> status;

    public List<OrderResponse> getData() {
        return data;
    }

    public void setData(List<OrderResponse> data) {
        this.data = data;
    }

    public List<StatusResponse> getStatus() {
        return status;
    }

    public void setStatus(List<StatusResponse> status) {
        this.status = status;
    }
}
