package com.valiit.pvback.domain.system.tryout;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "sys_try_out")
public class SysTryOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('manager.sys_try_out_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "header", nullable = false)
    private String header;

    @Size(max = 255)
    @Column(name = "text")
    private String text;

    @Size(max = 255)
    @NotNull
    @Column(name = "button_text", nullable = false)
    private String buttonText;

}