package com.example.demo.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entities.Course;

public interface CourseServices {
public List<Course> getCourses();

public Course getCourses(long courseId);

public Course addCourse(Course course);

public Course updateCourse(Course course);

public ResponseEntity<HttpStatus> deleteCourse(long courseId);

}
