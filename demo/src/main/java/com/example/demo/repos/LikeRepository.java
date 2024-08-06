package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.like;

public interface LikeRepository extends JpaRepository<like, Long> {

}
