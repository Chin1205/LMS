package biz.global77.controller;

import biz.global77.model.Course;
import biz.global77.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ModelAndView listCourses() {
        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("courses", courseService.getAllCourses());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addCourseForm(Course course) {
        return new ModelAndView("add_course", "course", course);
    }

    @PostMapping("/add_course")
    public ModelAndView addCourse(@Valid Course course, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add_course");
        }
        courseService.addCourse(course);
        model.addAttribute("courses", courseService.getAllCourses());
        return new ModelAndView("courses", "courseModel", model);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editCourseForm(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("edit_course");
        modelAndView.addObject("course", courseService.getCourseById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String editCourse(@PathVariable long id, Course course) {
        course.setId(id);
        courseService.updateCourse(course);
        return "redirect:/courses";
    }

//    @PostMapping("/archive/{id}")
//    public String archiveCourse(@PathVariable long id) {
//        courseService.archiveCourse(id);
//        return "redirect:/courses";
//    }

    @PostMapping("/archive/{id}")
    public ModelAndView archiveCourse(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        courseService.archiveCourse(id);
        mav.setViewName("redirect:/courses");
        return mav;
    }

    @GetMapping("/archive")
    public ModelAndView listArchiveCourses() {
        ModelAndView modelAndView = new ModelAndView("archive_courses");
        modelAndView.addObject("courses", courseService.getArchiveCourses());
        return modelAndView;
    }

    @PostMapping("/enable/{id}")
    public String enableCourse(@PathVariable long id) {
        courseService.enableCourse(id);
        return "redirect:/courses/archive";
    }
}
