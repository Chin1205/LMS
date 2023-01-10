package biz.global77.repository;


import biz.global77.model.BudgetRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<BudgetRequest, Integer> {
    List<BudgetRequest> findByArchivedFalse();
    List<BudgetRequest> findByArchivedTrue();
}
