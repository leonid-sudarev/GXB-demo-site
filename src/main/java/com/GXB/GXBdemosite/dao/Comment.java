package com.GXB.GXBdemosite.dao;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;


    private String body;

    // Post. Mapping: Many to One. Comments -> Post.
    @ManyToOne
    private Post post;

    @Embedded
    private Audit audit = new Audit();


}
