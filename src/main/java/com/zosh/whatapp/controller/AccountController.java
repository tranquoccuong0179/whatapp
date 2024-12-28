package com.zosh.whatapp.controller;

import com.zosh.whatapp.dto.request.account.RegisterAccountRequest;
import com.zosh.whatapp.dto.response.BaseResponse;
import com.zosh.whatapp.interfaceService.IAccountSevice;
import com.zosh.whatapp.model.Account;
import com.zosh.whatapp.model.RoleEnum;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private IAccountSevice accountService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<BaseResponse<Account>> create(@Valid @RequestBody RegisterAccountRequest registerAccountRequest){
        return accountService.Register(registerAccountRequest);
    }

}
