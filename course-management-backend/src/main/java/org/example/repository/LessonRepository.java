package org.example.repository;

import org.example.model.Lesson;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface LessonRepository extends Neo4jRepository<Lesson,Long> {
    @Query("MATCH (:Course {identifier: $courseIdentifier})<-[:BELONGS_TO]-(lessons:Lesson) RETURN lessons")
    List<Lesson> findLessonsByCourseIdentifier(String courseIdentifier);
}
