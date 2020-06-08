package com.GXB.GXBdemosite.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "t_userdetails")
public class UserDetails {

  @Id
  @Column(name = "t_userdetails_id")
  private Long id;

  // @Size(min = 3, message = "At least 3 characters") // TODO:  Regexp only letters
  private String firstname;

  // @Size(min = 2, message = "At least 2 characters")// TODO:  Regexp only letters
  private String lastname;

  private String gender;

  @OneToOne(cascade = CascadeType.ALL)
  @MapsId
  private User user;


}
