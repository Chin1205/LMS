package biz.global77.controller;

import biz.global77.model.BudgetRequest;
import biz.global77.service.BudgetRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/budgetrequest")
public class BudgetRequestController {

    @Autowired
    private BudgetRequestService budgetRequestService;

    @GetMapping
    public ModelAndView findAll() {
        List<BudgetRequest> budgetrequest = budgetRequestService.findAll();
        ModelAndView mav = new ModelAndView("budgetrequest");
        mav.addObject("budgetrequest", budgetrequest);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable int id) {
        BudgetRequest budgetrequest = budgetRequestService.findById(id);
        ModelAndView mav = new ModelAndView("budgetrequest");
        mav.addObject("budgetrequest", budgetrequest);
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView addForm() {
        ModelAndView mav = new ModelAndView("addBudgetRequest");
        mav.addObject("budgetrequest", new BudgetRequest());
        return mav;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute BudgetRequest budgetRequest) {
        budgetRequestService.save(budgetRequest);
        return "redirect:/budgetrequest";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id) {
        BudgetRequest budgetRequest = budgetRequestService.findById(id);
        ModelAndView mav = new ModelAndView("editBudgetRequest");
        mav.addObject("budgetrequest", budgetRequest);
        return mav;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute BudgetRequest budgetRequest) {
        budgetRequest.setId(id);
        budgetRequestService.save(budgetRequest);
        return "redirect:/budgetrequest";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        budgetRequestService.delete(id);
        return "redirect:/budgetrequest";
    }

    //test12321
}
