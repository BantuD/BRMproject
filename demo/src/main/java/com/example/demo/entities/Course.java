package com.example.demo.entities;

public class Course
{
 int couseId;
 String name;
public int getCouseId() {
	return couseId;
}
public void setCouseId(int couseId) {
	this.couseId = couseId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Course(int couseId, String name) {
	super();
	this.couseId = couseId;
	this.name = name;
}
@Override
public String toString() {
	return "Course [couseId=" + couseId + ", name=" + name + "]";
}
 
}
