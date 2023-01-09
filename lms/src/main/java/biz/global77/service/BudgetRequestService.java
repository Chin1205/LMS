package biz.global77.service;

import biz.global77.model.BudgetRequest;

import java.util.List;

public interface BudgetRequestService {

    List<BudgetRequest> findAll();
    BudgetRequest findById(int id);
    BudgetRequest save(BudgetRequest budgetRequest);
    void delete(int id);
}
