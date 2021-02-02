package com.jarsoft.banner3.controller;

import com.jarsoft.banner3.entity.Banner;
import com.jarsoft.banner3.entity.Category;
import com.jarsoft.banner3.service.BannerService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CategoryController {
  private final BannerService bannerService;

  public CategoryController(BannerService bannerService) {
    this.bannerService = bannerService;
  }

  @GetMapping("cat-info/{id}")
  public String bannersByCategory(@PathVariable("id") Integer id, Model model) {
    Category category = bannerService.findCategoryById(id);
    List<Banner> banners = bannerService.findByCategory(category);
    model.addAttribute("banners", banners);
    return "banners-category";
  }
}
