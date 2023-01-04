package biz.global77.controller;

import biz.global77.model.Certificate;
import biz.global77.model.Course;
import biz.global77.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/certificates")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ModelAndView findAll() {
        List<Certificate> certificates = certificateService.findAll();
        ModelAndView mav = new ModelAndView("certificate");
        mav.addObject("certificates", certificates);
        return mav;
    }


    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable int id) {
        Certificate certificate = certificateService.findById(id);
        ModelAndView mav = new ModelAndView("certificate");
        mav.addObject("certificate", certificate);
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView addForm() {
        ModelAndView mav = new ModelAndView("addCertificate");
        mav.addObject("certificate", new Certificate());
        return mav;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Certificate certificate) {
        certificateService.save(certificate);
        return "redirect:/certificates";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id) {
        Certificate certificate = certificateService.findById(id);
        ModelAndView mav = new ModelAndView("editCertificate");
        mav.addObject("certificate", certificate);
        return mav;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute Certificate certificate) {
        certificate.setId(id);
        certificateService.save(certificate);
        return "redirect:/certificates";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        certificateService.delete(id);
        return "redirect:/certificates";
    }

}