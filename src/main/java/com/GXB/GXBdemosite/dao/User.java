package com.GXB.GXBdemosite.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "t_user")
public class User  {
  @Transient
  final String REGEX_USERNAME = "[a-zA-Z0-9\\._\\-]{3,}";

  @Transient
  final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";

  @Transient
  final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "t_user_id")
  private Long id;

//  @NotBlank
//  @Size(min = 5, message = "At least 5 characters")
//  @Pattern(regexp = REGEX_USERNAME, message = "Username not valid")
  private String username;

  @Embedded
  private Audit audit = new Audit();

//  @Email
//  @NotBlank
//  @Pattern(regexp = REGEX_EMAIL, message = "Email not valid")
//  @Size(min = 8, message = "At least 8 characters total")
  private String email;

  private boolean enabled;

//  @NotBlank
//  @Size(min = 6, message = "At least 6 characters")
//  @Pattern(
//      regexp = REGEX_PASSWORD,
//      message =
//          "Requirements: at least one digit,lower case,upper case letter and special character ")
  private String password;

  //   * 3aD$
  //   * ^ # start-of-string (?=.*[0-9]) # a digit must occur at least once
  //   * (?=.*[a-z]) # a lower case letter must occur at least once
  //   * (?=.*[A-Z]) # an upper case letter must occur at least once
  //   * (?=.*[@#$%^&+=]) # a special character must occur at least once
  //   * (?=\S+$) # no whitespace allowed in the entire string
  //   * .{8,} # anything, at least eight places though
  //   * $ # end-of-string

  @Transient
  private String passwordConfirm;

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Role> roles = new HashSet<>();

  @OneToOne(
      mappedBy = "user",
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private UserDetails userDetails;

//  @Override
//  public boolean isAccountNonExpired() {
//    return true;
//  }
//
//  @Override
//  public boolean isAccountNonLocked() {
//    return true;
//  }
//
//  @Override
//  public boolean isCredentialsNonExpired() {
//    return true;
//  }
//
//  @Override
//  public boolean isEnabled() {
//    return this.enabled;
//  }
//
//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return getRoles();
//  }
//
//
//
//
//  }
}
