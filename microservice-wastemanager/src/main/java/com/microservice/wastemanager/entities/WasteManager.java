package com.microservice.wastemanager.entities;

import com.microservice.wastemanager.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wastemanager")
public class WasteManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nif;
    private Long version = 0L;

    private Long wasteManagerAddressId;

    @Column(name = "is_enabled")
    private Boolean isEnabled = Boolean.TRUE;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
}
