package com.zosh.whatapp.dto.response.authentication;

import com.zosh.whatapp.model.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String userName;
    private String token;
    private RoleEnum roleEnum;
}
