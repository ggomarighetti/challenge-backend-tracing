package com.ggomarighetti.tracing.entity;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "countries")
@Where(clause = "soft_delete = false")
@SQLDelete(sql = "UPDATE roles SET soft_delete = true WHERE id = ?")
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @ElementCollection
    private List<String> languages;

    @ElementCollection
    private List<String> timezones;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @ElementCollection
    private List<String> currency;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PetitionEntity> requests;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "soft_delete")
    @Builder.Default
    private Boolean softDelete = Boolean.FALSE;
}
