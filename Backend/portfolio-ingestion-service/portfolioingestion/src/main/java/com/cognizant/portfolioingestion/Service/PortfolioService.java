package com.cognizant.portfolioingestion.Service;

import com.cognizant.portfolioingestion.Dto.LoanRefDTO;
import com.cognizant.portfolioingestion.Entity.LoanRef;

import java.util.List;

public interface PortfolioService {

    LoanRef createLoan(LoanRefDTO loanRefDTO);

    LoanRef getLoan(Long loanId);

    List<LoanRef> getAllLoans();

    Integer calculateDPD(LoanRef loan);

    String assignBucket(Integer dpd);
}
