package ism.dakar.edumanage.datas.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import ism.dakar.edumanage.security.datas.entity.AbstractEntity;
import ism.dakar.edumanage.security.datas.enums.StatutEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    //    @Column(name = "active")
    private boolean actif;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createAt;

    @Enumerated(EnumType.STRING)
    private StatutEnum statut;

    private String userEmail;

    private String userName;

    @Column(nullable = false)
    private String action;

    private String cible;

    @Column(columnDefinition = "TEXT")
    private String details;

    private String adresseIp;

    @Column(nullable = false, updatable = false)
    private LocalDateTime loggedAt;
}

