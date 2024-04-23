package com.valiit.pvback.domain.system.paymenttier;

import com.valiit.pvback.domain.company.subscriptiontype.SubscriptionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "sys_payment_tier")
public class SysPaymentTier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('manager.sys_payment_tier_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subscription_type_id", nullable = false)
    private SubscriptionType subscriptionType;

    @NotNull
    @Column(name = "price_month", nullable = false)
    private Integer priceMonth;

    @NotNull
    @Column(name = "price_year", nullable = false)
    private Integer priceYear;

    @Size(max = 255)
    @NotNull
    @Column(name = "text_row_1", nullable = false)
    private String textRow1;

    @Size(max = 255)
    @Column(name = "text_row_2")
    private String textRow2;

    @Size(max = 255)
    @Column(name = "text_row_3")
    private String textRow3;

    @Size(max = 255)
    @Column(name = "text_row_4")
    private String textRow4;

    @Size(max = 255)
    @Column(name = "text_row_5")
    private String textRow5;

    @Size(max = 255)
    @Column(name = "text_row_6")
    private String textRow6;

    @Size(max = 255)
    @Column(name = "text_row_7")
    private String textRow7;

    @Size(max = 255)
    @Column(name = "text_row_8")
    private String textRow8;

}