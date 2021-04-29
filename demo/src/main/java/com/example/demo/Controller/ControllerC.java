package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseServices;
@RestController
public class ControllerC 
{
@Autowired
private CourseServices courseServices;
	
 @GetMapping("/home")
 public String home()
 {
	 return "Welcome";
 }
 
 @GetMapping("/courses") // To get entire courses
 public List<Course> getCourses()
 {
	 return courseServices.getCourses(); 
 }

 
 @GetMapping("/courses/{courseId}") // To get a single course
 public Course getCourse(@PathVariable String courseId)
 {
	 return courseServices.getCourses(Long.parseLong(courseId));
 }
 @PostMapping(path ="/courses",consumes = "application/json") // it tells that the data will come in json form
 																//You can simply use @PostMapping("/courses")
 public Course addCourse(@RequestBody Course course) //@RequestBody will tell that we will get course variable from request
 {
	 return courseServices.addCourse(course);
 }
 @PutMapping("/courses/")  //for update
 
 public Course updateCourse(@RequestBody Course course)
 {
	 return courseServices.updateCourse(course);
 }
 @DeleteMapping("/courses/{couseId}")  //NOT WORKING TILL YET
 ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
 {
	 try
	 {
		 courseServices.deleteCourse(Long.parseLong(courseId));
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
	 catch(Exception e)
	 {
		 
		 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	 }
 }
 
}
	


