package com.example.bookstore.api.repository;

import com.example.bookstore.api.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findByNameAllIgnoreCase(String name);
}
