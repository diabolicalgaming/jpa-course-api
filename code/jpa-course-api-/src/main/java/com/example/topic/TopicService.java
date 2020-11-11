package com.example.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 	This is a business service. In Spring, business services are usually Singletons. When Spring Boot
 	starts up, it creates an instance of this service and keeps it in its memory. You can have other
 	Controllers that depend on this instance.
 	
 	To mark a class as a business service you use the @Service annotation.
 	
 	@Service - is a stereotype annotation that is used in your service layer and annotates classes that
 	perform service tasks.
 	
 	You have connect the TopicService class to the database to run the commands.
 	
 	You will need to perform autowiring using the @Autowire annotation to inject the database into the
 	service class.
 
 */


@Service
public class TopicService
{
	/*
	 	List<Topic> topics = Arrays.asList(
			new Topic("spring","Spring Course","Spring Boot description."),
			new Topic("java","Java Course","Java description."),
			new Topic("javascript","JavaScript Course","JavaScript description.")
			);
			
		The above will give you Error 500 when you make a POST request because Arrays.asList() creates an immutable List.
		
		Since we are using an embedded apache database, we do not need to initialize the database yet.
	 */
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getTopics()
	{
		List<Topic> topics = new ArrayList<>();
		this.topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return this.topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) 
	{
		this.topicRepository.save(topic);	
	}

	
	/*
	 	The CrudRepository.save(ENTITY) method can also be used to perform an update. If there is no row
	 	with the particular ID, then it will do an insert, otherwise it will do an update by creating a new 
	 	row in the table.
	 */
	public void updateTopic(Topic topic) 
	{
		this.topicRepository.save(topic);
	}

	public void deleteTopic(String id) 
	{
		this.topicRepository.deleteById(id);
	}
}
