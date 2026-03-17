package com.cognizant.portfolioingestion.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanRefDTO {

    private Long loanAccountID;
    private Long customerID;
    private String product;
    private Double principalOS;
    private Double interestOS;
    private LocalDate lastPaymentDate;
    private String region;
}