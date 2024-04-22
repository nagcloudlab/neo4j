package org.example.repository;

import org.example.model.Course;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends Neo4jRepository<Course, Long>{

    @Query("MATCH (course:Course {identifier: $identifier}) RETURN course")
    Optional<Course> findCourseByIdentifier(String identifier);

    @Query("MATCH (course:Course {identifier: $identifier})<-[:BELONGS_TO]-(lessons:Lesson) RETURN course, lessons")
    Optional<Course> findCourseAndLessonsByIdentifier(String identifier);

    @Query("MATCH (:User {username: $username})-[:ENROLLED_IN]->(courses:Course) RETURN courses")
    List<Course> findAllEnrolledCoursesByUsername(String username);

}
