package com.example.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.entities.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    
}
