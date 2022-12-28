package biz.global77.cashloan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping("/")
    public String getIndex() {
        return "redirect:/dashboard";
    }

    @GetMapping("/{*}")
    public String notFound() {
        return "notfound";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }
}
