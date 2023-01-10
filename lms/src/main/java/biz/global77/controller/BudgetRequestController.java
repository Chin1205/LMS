package biz.global77.controller;

import biz.global77.model.BudgetRequest;
import biz.global77.model.Course;
import biz.global77.service.BudgetRequestService;
import biz.global77.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/budgetrequest")
public class BudgetRequestController {
    private final BudgetRequestService budgetRequestService;

    public BudgetRequestController(BudgetRequestService budgetRequestService) {
        this.budgetRequestService = budgetRequestService;
    }

    @GetMapping
    public ModelAndView listBudgetRequest() {
        ModelAndView modelAndView = new ModelAndView("budgetrequest");
        modelAndView.addObject("budgetrequest", budgetRequestService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addCourseForm(BudgetRequest budgetRequest) {
        return new ModelAndView("addBudgetRequest", "budgetrequest", budgetRequest);
    }

    @PostMapping("/add_budgetrequest")
    public ModelAndView addBudgetRequest(@Valid BudgetRequest budgetRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("addBudgetRequest");
        }
//        courseService.addCourse(course);
        budgetRequestService.addBudgetRequest(budgetRequest);
        model.addAttribute("budgetrequest", budgetRequestService.findAll());
        return new ModelAndView("budgetrequest", "budgetRequestModel", model);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editBudgetRequestForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("editBudgetRequest");
        modelAndView.addObject("budgetrequest", budgetRequestService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String editBudgetRequest(@PathVariable int id, BudgetRequest budgetRequest) {
        budgetRequest.setId(id);
        budgetRequestService.updateBudgetRequest(budgetRequest);
        return "redirect:/budgetrequest";
    }

    @PostMapping("/archive/{id}")
    public String archiveBudgetRequest(@PathVariable int id) {
        budgetRequestService.archiveBudgetRequest(id);
        return "redirect:/budgetrequest";
    }

    @GetMapping("/archive")
    public ModelAndView listArchiveBudgetRequest() {
        ModelAndView modelAndView = new ModelAndView("archive_budget");
        modelAndView.addObject("budgetrequest", budgetRequestService.getAllArchiveBudgetRequest());
        return modelAndView;
    }

    @PostMapping("/enable/{id}")
    public String enableBudgetRequest(@PathVariable int id) {
        budgetRequestService.enableBudgetRequest(id);
        return "redirect:/budgetrequest/archive";
    }
}
