package com.zosh.whatapp.interfaceService;

import com.zosh.whatapp.dto.request.account.RegisterAccountRequest;
import com.zosh.whatapp.dto.response.BaseResponse;
import com.zosh.whatapp.model.Account;
import org.springframework.http.ResponseEntity;

public interface IAccountSevice {
    public ResponseEntity<BaseResponse<Account>> Register(RegisterAccountRequest registerAccountRequest);
}
