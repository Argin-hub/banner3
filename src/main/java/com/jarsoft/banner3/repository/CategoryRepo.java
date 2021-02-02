package com.jarsoft.banner3.repository;

import com.jarsoft.banner3.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
  Category findByName(String name);

  Category findById(int id);

  void deleteById(int id);
}
