package biz.global77.cashloan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/page/all")
    public String forAll(){
        return "forAll/page1";
    }
    @GetMapping("/page/manager")
    public String forManager(){
        return "forAuthenticated/page3";
    }

    @GetMapping("/page/admin")
    public String forAdmin(){
        return "forAuthenticated/page4";
    }
    @GetMapping("/page/lender")
    public String forLender(){
        return "forAuthenticated/page2";
    }

    @GetMapping("/page/borrower")
    public String forBorrower(){
        return "forAuthenticated/page5";
    }

    @GetMapping("/access-denied")
    public String forDenied(){
        return "access-denied";
    }
}