package com.example.course;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService
{
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getCourses(String topicId)
	{
		List<Course> courses = new ArrayList<>();
		this.courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id)
	{
		return this.courseRepository.findById(id).get();
	}

	public void addCourse(Course course) 
	{
		this.courseRepository.save(course);	
	}

	public void updateCourse(Course course) 
	{
		this.courseRepository.save(course);
	}

	public void deleteCourse(String id) 
	{
		this.courseRepository.deleteById(id);
	}
}
