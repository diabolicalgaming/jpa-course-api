package com.example.topic;

import org.springframework.data.repository.CrudRepository;

/*
 	JPA provides an out of the box solution for implementing standard methods,
 	such as getAllTopics(). So instead of making a class, you will need an interface.
 	This interface will extend the CrudRepository that has the implemented methods.
 	
 	CrudRespository<> is a generic type. You need to provide generic type information in
 	the form CrudRepository<ENTITY,ID_TYPE>
 */

public interface TopicRepository extends CrudRepository<Topic,String>
{
	//getAllTopics()
	//getTopic(String id)
	//updateTopic(Topic topic)
	//deleteTopic()
}
