package com.valiit.pvback.domain.process.processpart;

import com.valiit.pvback.domain.process.Process;
import com.valiit.pvback.domain.process.part.Part;
import com.valiit.pvback.domain.project.projectrole.ProjectRole;
import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "process_part", schema = "manager")
public class ProcessPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "part_id", nullable = false)
    private Part part;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "process_id", nullable = false)
    private Process process;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_role_id", nullable = false)
    private ProjectRole projectRole;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_user_id", nullable = false)
    private ProjectUser projectUser;

    @Column(name = "deadline")
    private LocalDate deadline;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}