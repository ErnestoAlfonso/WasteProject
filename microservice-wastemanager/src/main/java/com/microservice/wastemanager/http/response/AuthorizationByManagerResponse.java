package com.microservice.wastemanager.http.response;

import com.microservice.wastemanager.dto.AuthorizationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationByManagerResponse {
    private String name;
    private List<AuthorizationDTO> authorizationDTOList;
}
