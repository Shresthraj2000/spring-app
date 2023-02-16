package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
//Business Service 
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
					 new Topic("s1","Spring 1","Desc s1"),
					 new Topic("s2","Spring 2","Desc s2"),
					 new Topic("s3","Spring 3","Desc s3")
					 ));
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
