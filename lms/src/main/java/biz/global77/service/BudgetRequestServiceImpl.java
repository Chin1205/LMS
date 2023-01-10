package biz.global77.service;

import biz.global77.controller.ResourceNotFoundException;
import biz.global77.model.BudgetRequest;
import biz.global77.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetRequestServiceImpl implements BudgetRequestService {

    private final BudgetRepository budgetRepository;
    public BudgetRequestServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public List<BudgetRequest> findAll() {
        return budgetRepository.findByArchivedFalse();
    }

    @Override
    public BudgetRequest findById(int id) {
        return budgetRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void addBudgetRequest(BudgetRequest budgetRequest) {
        budgetRepository.save(budgetRequest);
    }

    @Override
    public void updateBudgetRequest(BudgetRequest budgetRequest) {
        budgetRepository.save(budgetRequest);
    }

    @Override
    public void archiveBudgetRequest(int id) {
        BudgetRequest budgetRequest = budgetRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        budgetRequest.setArchived(true);
        budgetRepository.save(budgetRequest);
    }

    @Override
    public List<BudgetRequest> getAllArchiveBudgetRequest() { return budgetRepository.findByArchivedTrue(); }

    @Override
    public void enableBudgetRequest(int id) {
        BudgetRequest budgetRequest = budgetRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        budgetRequest.setArchived(false);
        budgetRepository.save(budgetRequest);
    }
}
