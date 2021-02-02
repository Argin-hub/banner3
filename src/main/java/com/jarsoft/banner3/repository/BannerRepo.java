package com.jarsoft.banner3.repository;

import com.jarsoft.banner3.entity.Banner;
import com.jarsoft.banner3.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BannerRepo extends JpaRepository<Banner, Integer> {
  List<Banner> findByCategory(Category category);

  List<Banner> findByCategoryAndDeleted(Category category, boolean exist);

  List<Banner> findByName(String name);

  Banner findBannerById(int id);

  List<Banner> findByDeletedOrderByPriceDesc(boolean exist);

  @Modifying
  @Transactional
  @Query("update Banner u  set u.deleted = true where u.id = :id")
  void setStatusDeleted(@Param(value = "id") int id);
}
