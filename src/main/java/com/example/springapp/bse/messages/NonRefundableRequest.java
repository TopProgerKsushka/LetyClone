package com.example.springapp.bse.messages;

public class NonRefundableRequest {
    public Integer orderId;

    public NonRefundableRequest() {}

    public NonRefundableRequest(Integer orderId) {
        this.orderId = orderId;
    }
}
