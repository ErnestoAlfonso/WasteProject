package com.microservice.wastemanageraddress.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wasteaddress")
public class WasteManagerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String direction;
    private Long version = 0L;

    @Column(name= "is_enabled")
    private Boolean isEnabled = Boolean.TRUE;
    @Column(name= "created_date")
    private Date createdDate;
    @Column(name= "last_modified_date")
    private Date lastModifiedDate;
    @Column(name = "waste_manager_id")
    private Long wasteManagerId;
}
