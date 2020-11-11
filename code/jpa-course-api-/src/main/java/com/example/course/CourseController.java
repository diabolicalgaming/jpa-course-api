package com.example.course;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.topic.Topic;

@RestController
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId)
	{
		return this.courseService.getCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String topicId, @PathVariable String courseId)
	{
		return this.courseService.getCourse(courseId);
	}
	
	/*
	 	We don't want to enfore the user to pass in the Topic information in the Course object.
	 	We want to do that create that ourselves.
	 */
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"","")); //this ensures that mapping is right for the topicId
		this.courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId)
	{
		course.setTopic(new Topic(topicId,"",""));
		this.courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable String topicId, @PathVariable String courseId)
	{
		this.courseService.deleteCourse(courseId);
	}
}
