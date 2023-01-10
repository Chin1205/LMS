package biz.global77.service;

import biz.global77.model.BudgetRequest;

import java.util.List;

public interface BudgetRequestService {

    List<BudgetRequest> findAll();
    BudgetRequest findById(int id);
    void addBudgetRequest(BudgetRequest budgetRequest);
    void updateBudgetRequest(BudgetRequest budgetRequest);
    void archiveBudgetRequest(int id);
    List<BudgetRequest> getAllArchiveBudgetRequest();
    void enableBudgetRequest(int id);
}
