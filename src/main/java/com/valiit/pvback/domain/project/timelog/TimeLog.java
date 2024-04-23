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
    @Column(name = "monday", nullable = false)
    private Integer monday;

    @NotNull
    @Column(name = "tuesday", nullable = false)
    private Integer tuesday;

    @NotNull
    @Column(name = "wednesday", nullable = false)
    private Integer wednesday;

    @NotNull
    @Column(name = "thursday", nullable = false)
    private Integer thursday;

    @NotNull
    @Column(name = "friday", nullable = false)
    private Integer friday;

    @NotNull
    @Column(name = "week_number", nullable = false)
    private Integer weekNumber;

}