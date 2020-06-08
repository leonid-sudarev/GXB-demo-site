package com.GXB.GXBdemosite.dao;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity()
@Table(name = "t_tag")
public class Tag {

  @Id
  private String name;

  @Embedded
  private Audit audit = new Audit();

}