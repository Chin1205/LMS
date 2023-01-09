package biz.global77.LMS.controller;

import biz.global77.LMS.model.User;
import biz.global77.LMS.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView listUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addUserForm(User user) {
        return new ModelAndView("add_user", "user", user);
    }

    @PostMapping("/add_user")
    public ModelAndView addUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add_user");
        }
        userService.addUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return new ModelAndView("users", "userModel", model);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUserForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit_user");
        modelAndView.addObject("user", userService.getUserById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable int id, User user) {
        user.setUserId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }

 /*   @PostMapping("/archive/{id}")
    public String archiveCourse(@PathVariable long id) {
        courseService.archiveCourse(id);
        return "redirect:/courses";
    }*/

   /* @GetMapping("/archive")
    public ModelAndView listArchiveCourses() {
        ModelAndView modelAndView = new ModelAndView("archive_courses");
        modelAndView.addObject("courses", courseService.getArchiveCourses());
        return modelAndView;
    }*/

    @PostMapping("/activate/{id}")
    public String activateUser(@PathVariable int id) {
        userService.activateUser(id);
        return "redirect:/users";
    }
}