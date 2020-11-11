package com.example.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 	Controller - is a Java class that has certain annotations marked in it.
 	
 	These annotations let Spring know the URL that you are mapping the Controller to
 	and what should happen when the request comes to that URL.
 	
 	It tells us what URL access needs to trigger the Controller to execute.
 	
 	@RestController - marks a Java class as a Controller.
 	
 	Having a class marked as @RestController means that you have have methods that map to
 	a URL request.
 */

@RestController
public class TopicController 
{
	/*
	 	Spring looks at all the member variables of a class and checks if any of them have a
	 	dependency to the TopicService. It will then inject that service. This is called 
	 	Dependency Injection.
	 	
	 	To perform injection dependency you use the @Autowired annotation.
	 	
	 	@Autowired - declares a member as a dependency.
	 	
	 	Using the @Autowired annotation is called Autowiring.
	 	
	 	Autowiring can be used on properties, setters, and constructors.
	 */
	
	@Autowired
	private TopicService topicService;
	
	/*
	  If you want a method to respond to a specific URL, it must be marked with the @RequestMapping
	  annotation.
	  
	  @RequestMapping - used to map a HTTP request method to a specific class method in a controller
	  that will be handling the request.
	  
	  @RequestMapping("/map") only performs a GET request. If you want to use other HTTP methods, you
	  have to specify this.
	 */
	
	/*
	 	Spring will automatically get all the Course objects and return it in JSON format.
	 	The getAllTopics method now gets all of the Topics from the TopicService class.
	 */
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return this.topicService.getTopics();
	}
	
	/*
	 	
	 */
	
	/*
	 	This method calls the getTopic method from the TopicService class. The method searches the topic
	 	list for a Topic with a matching ID, when it finds that ID, it returns a Topic.
	 	
	 	@PathVairble - indicates that a methods parameter should be bound to a URI template variable. It allows
	 	the methods parameter to be passed in the request URL. The parameter name has to be the same as what is between
	 	{} like in the URL otherwise you have to use @PathVariable("variable_name")
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return this.topicService.getTopic(id);
	}
	
	
	/*
	 	 @RequestMapping(method=RequestMethod.POST, value="/topics") maps any method to any request that is a POST on /topics.
	 	 When a POST request is made, this method will be executed.
	 	 
	 	 @RequestBody tells Spring MVC that your request payload is going to contain a JSON representation of this Topic instance.
	 	 You are asking it to take that Request Body and convert it into a Topic instance and pass it to the addTopic method when this URL
	 	 is mapped.
	 	 
	 	 @RequestBody - used to bind the HTTP request body with a domain object in method parameter and return type.
	 	 
	 	 For a POST, you need to be able to edit the post body, which is why we use Postman.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		this.topicService.addTopic(topic);
	}
	
	/*
	 	This method updates the properties of a Topic if a PUT request is made the the URL "/topics/{id}"
	 */
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id)
	{
		this.topicService.updateTopic(topic);
	}
	
	/*
 		This method deletes a Topic if a DELETE request is made the the URL "/topics/{id}"
	 */
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		this.topicService.deleteTopic(id);
	}
}
