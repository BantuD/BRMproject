package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
@Component
public class CoursesImp implements CourseServices
{
 
private List<Course> list;  //Variable which will store the the objects of Courses class in list
	
	public CoursesImp() {
	super();
	list = new ArrayList<>();
	list.add(new Course(21,"java"));
	list.add(new Course(22,"CPP"));
	list.add(new Course(23,"Spring"));
}

	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourses(long courseId) {
		
		Course c = null;
		for(Course c1 : list)
		{
			if(c1.getCouseId()==courseId)
			{
				c = c1;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(c ->  // you can do it by just for(Course c: list)
		{
			if(c.getCouseId()==course.getCouseId())
			{
				c.setName(course.getName());
				
			}
		});
		return course;
	}

	@Override
	public ResponseEntity<HttpStatus> deleteCourse(long courseId) {
		
		Course c;
		for(int i=0;i<list.size();i++)
		{
		  c=list.get(i);
		  if(c.getCouseId()==courseId)
		  {
			  list.remove(i);
			  break;
		  }
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	

	
	


	

}
