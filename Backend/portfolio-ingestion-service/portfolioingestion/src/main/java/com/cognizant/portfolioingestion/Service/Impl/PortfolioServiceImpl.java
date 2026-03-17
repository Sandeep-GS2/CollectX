package com.cognizant.portfolioingestion.Service.Impl;

import com.cognizant.portfolioingestion.Dto.LoanRefDTO;
import com.cognizant.portfolioingestion.Entity.LoanRef;
import com.cognizant.portfolioingestion.Repository.LoanRefRepository;
import com.cognizant.portfolioingestion.Service.PortfolioService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final LoanRefRepository loanRepository;

    @Override
    public LoanRef createLoan(LoanRefDTO dto) {

        LoanRef loan = LoanRef.builder()
                .loanAccountID(dto.getLoanAccountID())
                .customerID(dto.getCustomerID())
                .product(dto.getProduct())
                .principalOS(dto.getPrincipalOS())
                .interestOS(dto.getInterestOS())
                .lastPaymentDate(dto.getLastPaymentDate())
                .region(dto.getRegion())
                .status("Current")
                .build();

        Integer dpd = calculateDPD(loan);
        loan.setDpd(dpd);
        loan.setBucket(assignBucket(dpd));

        return loanRepository.save(loan);
    }

    @Override
    public LoanRef getLoan(Long loanId) {
        return loanRepository.findById(loanId).orElseThrow();
    }

    @Override
    public List<LoanRef> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Integer calculateDPD(LoanRef loan) {
        return (int) ChronoUnit.DAYS.between(
                loan.getLastPaymentDate(),
                LocalDate.now());
    }

    @Override
    public String assignBucket(Integer dpd) {

        if (dpd <= 30) return "0-30";
        if (dpd <= 60) return "31-60";
        if (dpd <= 90) return "61-90";
        return "90+";
    }
}
