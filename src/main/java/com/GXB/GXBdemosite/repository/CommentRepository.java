package com.GXB.GXBdemosite.repository;


import com.GXB.GXBdemosite.dao.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
