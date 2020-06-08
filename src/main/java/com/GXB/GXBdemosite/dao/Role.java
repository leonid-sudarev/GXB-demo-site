package com.GXB.GXBdemosite.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_role")
public class Role implements Serializable {

  @Id
  @Column(name = "t_role_id")
  private Long id;

  @NonNull private String name;

  @Transient
  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
  private Set<User> users = new HashSet<>();

  public Role(Long id) {
    this.id = id;
  }

  public Role(Long id, String name) {
    this.id = id;
    this.name = name;
  }

}
