package com.cognizant.portfolioingestion.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "risk_ref")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiskRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long riskID;

    private Integer bureauScore;

    private Integer internalScore;

    private String riskBand;

    private LocalDate asOfDate;

    @ManyToOne
    @JoinColumn(name = "loan_account_id")
    private LoanRef loanRef;
}