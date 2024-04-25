package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.Lesson;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CourseDTO {
    private String identifier;
    private String title;
    private String teacher;
    private boolean enrolled;
    private List<Lesson> lessons=new ArrayList<>();

    public CourseDTO(String identifier, String title, String teacher) {
        this.identifier = identifier;
        this.title = title;
        this.teacher = teacher;
    }


}
