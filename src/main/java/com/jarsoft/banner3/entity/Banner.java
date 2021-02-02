package com.jarsoft.banner3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Table(name = "banner")
@ToString(of = {"id", "text"})
@EqualsAndHashCode(of = {"id"})
@Data
public class Banner {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonView(Views.Id.class)
  private int id;

  @Column(name = "content")
  @JsonView(Views.IdName.class)
  private String text;

  @Column(updatable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonView(Views.FullMessage.class)
  private LocalDateTime creationDate = LocalDateTime.now();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id")
  @JsonView(Views.IdName.class)
  private Category category;

  @Column(name = "name")
  @JsonView(Views.IdName.class)
  private String name;

  @Column(name = "price")
  @JsonView(Views.IdName.class)
  private int price;

  @Column(name = "deleted")
  private boolean deleted;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }
}
