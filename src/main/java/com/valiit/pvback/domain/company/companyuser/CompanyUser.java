package com.valiit.pvback.domain.company.companyuser;

import com.valiit.pvback.domain.project.projectrole.ProjectRole;
import com.valiit.pvback.domain.company.Company;
import com.valiit.pvback.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company_user", schema = "manager")
public class CompanyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_role_id", nullable = false)
    private ProjectRole projectRole;

    @NotNull
    @Column(name = "is_company_admin", nullable = false)
    private Boolean isCompanyAdmin = false;

}