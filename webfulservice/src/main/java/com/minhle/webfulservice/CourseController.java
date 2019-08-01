package com.minhle.webfulservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CourseController {
    @Autowired
    private CourseRepository cRepository;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    Collection<Course> getAllCourses(){
           return cRepository.findAll(); 
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    Course getFirstCourse(){
        return cRepository.findAll().get(0);
    }

    //RESTful service -> if your database entity is called Course then your url should be /course
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    Collection<Course> getCourseByCourseTitle(@RequestParam("courseTitle") String courseTitle){
        return cRepository.findCourseByCourseTitle(courseTitle);
    }

    @RequestMapping(value = "/course/create", method = RequestMethod.POST)
    Course createCourse(@RequestParam("courseTitle") String courseTitle,
        @RequestParam("courseID") String courseID,
        @RequestParam("credits") Integer credits) {
            Course toSave = new Course();
            toSave.setCourseTitle(courseTitle);
            toSave.setCourseID(courseID);
            toSave.setCredits(credits);
            return cRepository.save(toSave);
    }
}