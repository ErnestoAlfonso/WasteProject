package com.microservice.wastemanager.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WasteManagerDTO {
    private String name;
    private String nif;
    private Long version = 0L;

    private Long wasteManagerAddressId;


    private Boolean isEnabled = Boolean.TRUE;
    private Date createdDate;
    private Date lastModifiedDate;
}
