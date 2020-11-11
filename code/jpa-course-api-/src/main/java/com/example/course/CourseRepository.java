package com.example.course;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

/*
 	JPA provides an out of the box solution for implementing standard methods,
 	such as getAllTopics(). So instead of making a class, you will need an interface.
 	This interface will extend the CrudRepository that has the implemented methods.
 	
 	CrudRespository<> is a generic type. You need to provide generic type information in
 	the form CrudRepository<ENTITY,ID_TYPE>
 	
 	CrudRepository allows you to write methods to query your database without having to
 	implement them. To do this, your method has to follow the naming convention below:
 	
 	findByVARIABLE_NAME(TYPE variable_name)
 	
 	For simple queries you only have to do the above without implementation.
 */

public interface CourseRepository extends CrudRepository<Course,String>
{
	public List<Course> findByTopicId(String topicId);
}
