package com.jarsoft.banner3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "first_name")
  @NotEmpty
  private String firstName;

  @NotEmpty(message = "ВВЕДИ ФАМИЛИЮ")
  @Column(name = "last_name")
  private String lastName;

  @NotNull
  @Email(message = "nepravilno post")
  private String email;

  @NotNull private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private Status status;

  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private Role role;

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public Status getStatus() {
    return status;
  }

  public Role getRole() {
    return role;
  }
}
