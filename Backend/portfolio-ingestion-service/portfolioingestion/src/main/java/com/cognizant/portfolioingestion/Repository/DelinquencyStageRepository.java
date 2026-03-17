package com.cognizant.portfolioingestion.Repository;

import com.cognizant.portfolioingestion.Entity.DelinquencyStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelinquencyStageRepository extends JpaRepository<DelinquencyStage, Long> {
}
