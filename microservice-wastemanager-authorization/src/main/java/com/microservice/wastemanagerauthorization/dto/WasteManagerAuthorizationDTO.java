package com.microservice.wastemanagerauthorization.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WasteManagerAuthorizationDTO {
    private String authorizationNumber;
}
