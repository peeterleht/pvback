package com.valiit.pvback.domain.company.subscriptiontype;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "subscription_type", schema = "manager")
public class SubscriptionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "tier", nullable = false)
    private Integer tier;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

}