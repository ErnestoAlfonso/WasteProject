package com.microservice.wastemanager.entities;

import com.microservice.wastemanager.dto.AddressDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Name cannot be blank")
    private String nif;
    @Positive(message = "Version must be a positive number")
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

    @NotNull(message = "Creation date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_date")
    private Date createdDate;

    @NotNull(message = "Last modified date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
}
