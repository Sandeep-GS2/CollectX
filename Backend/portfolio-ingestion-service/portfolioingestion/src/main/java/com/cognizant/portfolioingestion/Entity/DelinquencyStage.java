package com.cognizant.portfolioingestion.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "delinquency_stage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DelinquencyStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stageID;

    private String bucket;

    private LocalDate stageDate;

    private String reasonCode;

    @ManyToOne
    @JoinColumn(name = "loan_account_id")
    private LoanRef loanRef;
}
