package com.cognizant.portfolioingestion.Dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RiskRefDTO {

    private Long loanAccountID;
    private Integer bureauScore;
    private Integer internalScore;
    private LocalDate asOfDate;
}