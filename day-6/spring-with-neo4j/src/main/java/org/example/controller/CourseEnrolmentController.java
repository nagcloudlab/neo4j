package org.example.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.example.dto.CourseDTO;
import org.example.dto.CourseEnrolmentDTO;
import org.example.model.Course;
import org.example.query.result.CourseEnrolmentQueryResult;
import org.example.request.CourseEnrolmentRequest;
import org.example.service.CourseEnrolmentService;
import org.example.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/enrollments")
public class CourseEnrolmentController {
    private final CourseEnrolmentService courseEnrolmentService;
    private final LessonService lessonService;

    public CourseEnrolmentController(CourseEnrolmentService courseEnrolmentService, LessonService lessonService) {
        this.courseEnrolmentService = courseEnrolmentService;
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> enrollments(Principal principal) {
        System.out.println("CourseEnrolmentController.enrollments");
        System.out.println("principal = " + principal.getName());
        List<Course> courses = courseEnrolmentService.getAllEnrolledCoursesByUsername(principal.getName());

        List<CourseDTO> responseCourses = courses.stream().map(
                (course) -> {
                    CourseDTO responseCourse = new CourseDTO();

                    responseCourse.setIdentifier(course.getIdentifier());
                    responseCourse.setTitle(course.getTitle());
                    responseCourse.setTeacher(course.getTeacher());
                    responseCourse.setLessons(lessonService.getAllLessonsByCourseIdentifier(course.getIdentifier()));
                    responseCourse.setEnrolled(true);

                    return responseCourse;
                }
        ).collect(Collectors.toList());

        return new ResponseEntity<>(responseCourses, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CourseEnrolmentDTO> enrollIn(@RequestBody CourseEnrolmentRequest request, Principal principal) {
        CourseEnrolmentQueryResult enrolment = courseEnrolmentService.enrollIn(principal.getName(), request.getCourseIdentifier());

        CourseEnrolmentDTO responseEnrolment = new CourseEnrolmentDTO();

        responseEnrolment.setName(enrolment.getUser().getName());
        responseEnrolment.setUsername(enrolment.getUser().getUsername());
        responseEnrolment.setCourse(enrolment.getCourse());

        return new ResponseEntity<>(responseEnrolment, HttpStatus.OK);
    }
}