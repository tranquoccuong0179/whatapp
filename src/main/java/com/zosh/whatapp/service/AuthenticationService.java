package com.zosh.whatapp.service;

import com.zosh.whatapp.dto.request.authentication.AuthenticationRequest;
import com.zosh.whatapp.dto.response.BaseResponse;
import com.zosh.whatapp.dto.response.authentication.AuthenticationResponse;
import com.zosh.whatapp.interfaceService.IAuthenticationService;
import com.zosh.whatapp.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;
    @Override
    public ResponseEntity<BaseResponse<AuthenticationResponse>> Authenticate(AuthenticationRequest request) {
        Authentication authentication;
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        Account account = (Account) authentication.getPrincipal();
        if(account.isActive() == false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(HttpStatus.UNAUTHORIZED.toString(), "Your account has been locked", null));
        }

        var jwtToken = jwtService.generateToken(account);

        authenticationResponse.setToken(jwtToken);
        authenticationResponse.setUserName(request.getUsername());
        authenticationResponse.setRoleEnum(account.getRole());
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>(HttpStatus.OK.toString(), "Login success", authenticationResponse));
    }
}
