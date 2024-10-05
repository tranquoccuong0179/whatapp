package com.zosh.whatapp.service;

import com.zosh.whatapp.dto.request.account.RegisterAccountRequest;
import com.zosh.whatapp.dto.response.BaseResponse;
import com.zosh.whatapp.interfaceService.IAccountSevice;
import com.zosh.whatapp.model.Account;
import com.zosh.whatapp.model.RoleEnum;
import com.zosh.whatapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService implements IAccountSevice {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public ResponseEntity<BaseResponse<Account>> Register(RegisterAccountRequest registerAccountRequest) {
        Account account = new Account();
        account.setUsername(registerAccountRequest.getUsername());
        account.setPassword(passwordEncoder.encode(registerAccountRequest.getPassword()));
        account.setEmail(registerAccountRequest.getEmail());
        account.setFullName(registerAccountRequest.getFullName());
        account.setPhone(registerAccountRequest.getPhone());
        account.setDob(registerAccountRequest.getDob());
        account.setRole(RoleEnum.USER);
        account.setCreateAt(LocalDateTime.now());
        account.setUpdateAt(LocalDateTime.now());
        account.setActive(true);
        accountRepository.save(account);

        return ResponseEntity.ok().body(new BaseResponse<>("200", "Create Successfull", account));
    }
}
