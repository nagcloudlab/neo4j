package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CourseDTO;
import org.example.model.Course;
import org.example.service.CourseEnrolmentService;
import org.example.service.CourseService;
import org.example.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;
    private final LessonService lessonService;
    private final CourseEnrolmentService courseEnrolmentService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(Principal principal){
        List<Course> courses=courseService.getAllCourses();
        List<CourseDTO> courseDtos=courses.stream().map(course -> {
            CourseDTO courseDto=new CourseDTO(course.getIdentifier(),course.getTitle(),course.getTeacher());
            courseDto.setLessons(lessonService.getAllLessonsByCourseIdentifier(course.getIdentifier()));
            if(principal!=null) {
                courseDto.setEnrolled(courseEnrolmentService.getEnrolmentStatus(principal.getName(), course.getIdentifier()));
            }
            return courseDto;
        }).toList();
        return new ResponseEntity<>(courseDtos, HttpStatus.OK);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<CourseDTO> getCourseDetails(@PathVariable String identifier){
        Course course=courseService.getCourseByIdentifier(identifier);
        CourseDTO courseDto=new CourseDTO(course.getIdentifier(),course.getTitle(),course.getTeacher());
        courseDto.setLessons(lessonService.getAllLessonsByCourseIdentifier(identifier));
        return new ResponseEntity<>(courseDto,HttpStatus.OK);
    }

}
