package com.example.bookstore.api.service;

import com.example.bookstore.api.model.Topic;
import com.example.bookstore.api.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TopicService {
    private final TopicRepository topicRepository;


    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> findAll(){
        return topicRepository.findAll();
    }

    public Optional<Topic> findById(Long id){
        return topicRepository.findById(id);
    }

    public Topic findByName (String name){return topicRepository.findByNameAllIgnoreCase(name);}

    public void save (Topic topic){
        topicRepository.save(topic);
    }

    public void delete(Long id){
        topicRepository.deleteById(id);
    }

    public void update (Topic topic){
        topicRepository.save(topic);
    }
}