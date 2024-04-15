package com.microservice.wastemanager.dto;

import com.microservice.wastemanager.entities.WasteManagerAuthorization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

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

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Nif cannot be blank")
    private String nif;

    @Positive(message = "Version must be a positive number")
    private Long version = 0L;

    private Long wasteManagerAddressId;

    private List<WasteManagerAuthorization> wasteAuthorizationList;

    private Boolean isEnabled = Boolean.TRUE;

    @NotNull(message = "Creation date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @NotNull(message = "Last Modified date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastModifiedDate;
}
