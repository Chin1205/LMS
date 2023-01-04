package biz.global77.controller;

import biz.global77.model.Course;
import biz.global77.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ModelAndView findAll() {
        List<Course> courses = courseService.findAll();
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("courses", courses);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable int id) {
        Course course = courseService.findById(id);
        ModelAndView mav = new ModelAndView("course");
        mav.addObject("course", course);
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView addForm() {
        ModelAndView mav = new ModelAndView("addCourse");
        mav.addObject("course", new Course());
        return mav;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id) {
        Course course = courseService.findById(id);
        ModelAndView mav = new ModelAndView("editCourse");
        mav.addObject("course", course);
        return mav;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute Course course) {
        course.setId(id);
        courseService.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        courseService.delete(id);
        return "redirect:/courses";
    }

}