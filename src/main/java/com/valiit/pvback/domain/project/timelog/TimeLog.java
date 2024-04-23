package com.valiit.pvback.domain.project.timelog;

import com.valiit.pvback.domain.project.Project;
import com.valiit.pvback.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "time_log", schema = "manager")
public class TimeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @NotNull
    @Column(name = "minutes", nullable = false)
    private Integer minutes;

    @NotNull
    @Column(name = "\"timestamp\"", nullable = false)
    private Instant timestamp;

}