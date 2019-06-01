package io.nikhil.springquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	 private List<Topic> topics= new ArrayList<>(Arrays.asList(
				new Topic("spring","Spring Framework","Spring Framework Description"),
				new Topic("Python","Flask Framework","Flask Framework Description"),
				new Topic("Javascript","React","Reac Library Description")
				));
	 
	 public List<Topic> getAllTopics(){
		 //return topics;
		 List<Topic> AllTopics=new ArrayList<>();
		 topicRepository.findAll().forEach(AllTopics::add);
		 return AllTopics;
	 }
	 
	 public Topic getTopic(String id) {
		 return topicRepository.findOne(id);
	 }

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);	
	}
}
