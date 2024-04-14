package com.microservice.wastemanager.http.response;

import com.microservice.wastemanager.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WasteManagerByAddressResponse {
    private AddressDTO addressDTO;
    private String name;
}
