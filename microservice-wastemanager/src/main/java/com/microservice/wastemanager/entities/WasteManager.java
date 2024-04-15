package com.microservice.wastemanager.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tbl_manager_auth",
            joinColumns = @JoinColumn(name = "id_manager"),
            inverseJoinColumns = @JoinColumn(name = "id_auth"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_manager","id_auth"}))
    private List<WasteManagerAuthorization> wasteAuthorizationList;

    @Column(name = "is_enabled")
    private Boolean isEnabled = Boolean.TRUE;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
}
