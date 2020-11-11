package com.example.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.topic.Topic;

/*
 	We need to save an instance of Topic into our database. We need to map this object
 	to the Relational Database Table.
 	
 	@Entity - is an object wrapper for a database table.
 	
 	The attributes for the entity are transformed to columns on the database table. Becuase we
 	have marked the Topic class as an Entity, JPA creates a Table called Topic with three columns;
 	id, name, and description.
 	
 	We will also need to tell JPA what the primary key is. Every table in a Relational Database
 	requires a primary key.
 	
 	@Id - used to specify the primary key of an entity.
 */

@Entity
public class Course 
{
	@Id
	private String id;
	private String name;
	private String description;
	
	/*
	 	There can be many courses for one topic.
	 */
	
	@ManyToOne
	private Topic topic;
	
	public Course()
	{
		
	}
	
	public Course(String id, String name, String description, String topicId) 
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId,"","");
	}

	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public Topic getTopic() 
	{
		return topic;
	}

	public void setTopic(Topic topic) 
	{
		this.topic = topic;
	}
}
