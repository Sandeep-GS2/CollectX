package com.cognizant.portfolioingestion.Controller;

import com.cognizant.portfolioingestion.Dto.LoanRefDTO;
import com.cognizant.portfolioingestion.Entity.LoanRef;
import com.cognizant.portfolioingestion.Service.PortfolioService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping("/loan")
    public LoanRef createLoan(@RequestBody LoanRefDTO dto) {
        return portfolioService.createLoan(dto);
    }

    @GetMapping("/loan/{id}")
    public LoanRef getLoan(@PathVariable Long id) {
        return portfolioService.getLoan(id);
    }

    @GetMapping("/loans")
    public List<LoanRef> getAllLoans() {
        return portfolioService.getAllLoans();
    }
}
