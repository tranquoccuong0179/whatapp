package com.zosh.whatapp.dto.request.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class RegisterAccountRequest {
    @NotBlank(message = "Username can not blank")
    private String username;
    @NotBlank(message = "Password can not blank")
    private String password;
    @NotBlank(message = "FullName can not blank")
    private String fullName;
    @NotBlank(message = "Email can not blank")
    @Email(message = "Wrong Email format")
    private String email;
    @NotBlank(message = "Phone can not blank")
    private String phone;
    private LocalDate dob;
}
