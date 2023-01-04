package biz.global77.controller;

import biz.global77.model.Course;
import biz.global77.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

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

    @PostMapping("/add")
    public String addCourse(Course course) {
        courseService.addCourse(course);
        return "redirect:/courses";
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

    @PostMapping("/archive/{id}")
    public String archiveCourse(@PathVariable long id) {
        courseService.archiveCourse(id);
        return "redirect:/courses";
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
