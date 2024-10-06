package com.zosh.whatapp.controller;

import com.zosh.whatapp.dto.request.authentication.AuthenticationRequest;
import com.zosh.whatapp.dto.response.BaseResponse;
import com.zosh.whatapp.dto.response.authentication.AuthenticationResponse;
import com.zosh.whatapp.interfaceService.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    IAuthenticationService authenticateService;
    @PostMapping("/authenticate")
    public ResponseEntity<BaseResponse<AuthenticationResponse>> authenticate(@RequestBody AuthenticationRequest request){
        return authenticateService.Authenticate(request);
    }
}
