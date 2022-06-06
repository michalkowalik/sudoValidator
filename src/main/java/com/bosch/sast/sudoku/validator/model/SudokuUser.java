package com.bosch.sast.sudoku.validator.model;

import java.util.Set;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class SudokuUser {

  @Id
  private final UUID id =java.util.UUID.randomUUID();

  private String name;
  private String email;


  @OneToMany(mappedBy = "user")
  private Set<Board> boards;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
