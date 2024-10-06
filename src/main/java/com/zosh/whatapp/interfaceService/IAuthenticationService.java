package com.zosh.whatapp.interfaceService;

import com.zosh.whatapp.dto.request.authentication.AuthenticationRequest;
import com.zosh.whatapp.dto.response.BaseResponse;
import com.zosh.whatapp.dto.response.authentication.AuthenticationResponse;
import com.zosh.whatapp.model.Account;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationService {
    public ResponseEntity<BaseResponse<AuthenticationResponse>> Authenticate(AuthenticationRequest request);
}
