package com.cognizant.portfolioingestion.Repository;

import com.cognizant.portfolioingestion.Entity.LoanRef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRefRepository extends JpaRepository<LoanRef, Long> {
}
