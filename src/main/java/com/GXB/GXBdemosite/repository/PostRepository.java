package com.GXB.GXBdemosite.repository;


import com.GXB.GXBdemosite.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

}
