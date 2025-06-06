package com.itransform.auth_service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class TokenValidationResponse {
    private String username;
    private String role;
}
