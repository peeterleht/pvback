package com.valiit.pvback.domain.project;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "project", schema = "manager")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @NotNull
    @Column(name = "client", nullable = false)
    private String client;

    @Size(max = 255)
    @NotNull
    @Column(name = "bank_link", nullable = false)
    private String bankLink;

    @Size(max = 255)
    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

}