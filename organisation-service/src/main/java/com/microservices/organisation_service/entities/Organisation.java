package com.microservices.organisation_service.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "organisations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organisation_id;

    @Column(nullable = false)
    private String organisationName;
    private String organisationDescription;

    @Column(nullable = false,unique = true)
    private String organisationCode;

    @CreationTimestamp
    private LocalDateTime organisationCreatedDate;
}
