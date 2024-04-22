package org.example.dto;

import lombok.Data;
import org.example.model.Course;
import org.example.model.Lesson;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDto {
    private String identifier;
    private String title;
    private String teacher;
    private List<Lesson> lessons=new ArrayList<>();

    public CourseDto(String identifier, String title, String teacher) {
        this.identifier = identifier;
        this.title = title;
        this.teacher = teacher;
    }


}
