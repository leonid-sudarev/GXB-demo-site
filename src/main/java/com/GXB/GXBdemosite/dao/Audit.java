package com.GXB.GXBdemosite.dao;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Audit {

  @Column(name = "created_on")
  private LocalDateTime createdOn;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "updated_on")
  private LocalDateTime updatedOn;

  @Column(name = "updated_by")
  private String updatedBy;

  @PrePersist
  public void prePersist() {
    createdOn = LocalDateTime.now();

  }

  public Audit() {
    this.createdOn = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updatedOn = LocalDateTime.now();
  }

}
