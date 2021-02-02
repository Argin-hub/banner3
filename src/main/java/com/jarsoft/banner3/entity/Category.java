package com.jarsoft.banner3.entity;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonView(Views.IdName.class)
  private int id;

  @Column(name = "name")
  @JsonView(Views.IdName.class)
  private String name;

  @Column(name = "req_name")
  @JsonView(Views.IdName.class)
  private String reqName;

  @Column(name = "deleted")
  @JsonView(Views.IdName.class)
  private boolean deleted;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "category")
  private List<Banner> banners;

  public void setBanners(List<Banner> banners) {
    if (banners != null) {
      banners.forEach(banner -> banner.setCategory(this));
    }
    this.banners = banners;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return id == category.id
        && deleted == category.deleted
        && Objects.equals(name, category.name)
        && Objects.equals(reqName, category.reqName)
        && Objects.equals(banners, category.banners);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, reqName, deleted, banners);
  }

  @Override
  public String toString() {
    return "Category{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", reqName='"
        + reqName
        + '\''
        + ", deleted="
        + deleted
        + ", banners="
        + banners
        + '}';
  }
}
