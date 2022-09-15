package com.example.springapp.letyclone.messages;

import com.example.springapp.letyclone.AccountInfo;
import com.example.springapp.letyclone.model.Shop;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAccountInfoResponse {
    public String status;
    public String username;
    public String error;
    public Double actualBalance;
    public Double ghostBalance;

    public static GetAccountInfoResponse ok(AccountInfo accountInfo) {
        GetAccountInfoResponse r = new GetAccountInfoResponse();
        r.status = "ok";
        r.username = accountInfo.username;
        r.actualBalance = accountInfo.balance;
        r.ghostBalance = accountInfo.ghostBalance;
        return r;
    }
    public static GetAccountInfoResponse error(String message) {
        GetAccountInfoResponse r = new GetAccountInfoResponse();
        r.status = "error";
        r.error = message;
        return r;
    }
}
