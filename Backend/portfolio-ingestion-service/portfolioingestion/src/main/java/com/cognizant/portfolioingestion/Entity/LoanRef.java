package com.cognizant.portfolioingestion.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "loan_ref")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRef {

    @Id
    private Long loanAccountID;

    private Long customerID;

    private String product;

    private Double principalOS;

    private Double interestOS;

    private String bucket;

    private Integer dpd;

    private LocalDate lastPaymentDate;

    private String region;

    private String status;

    @OneToMany(mappedBy = "loanRef", cascade = CascadeType.ALL)
    private List<RiskRef> risks;

    @OneToMany(mappedBy = "loanRef", cascade = CascadeType.ALL)
    private List<DelinquencyStage> stages;
}
