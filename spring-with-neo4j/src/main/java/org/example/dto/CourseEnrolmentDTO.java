package org.example.dto;

import lombok.Data;
import org.example.model.Course;

@Data
public class CourseEnrolmentDTO {
    private String name;
    private String username;
    private Course course;
}
