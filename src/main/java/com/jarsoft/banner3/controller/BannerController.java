package com.jarsoft.banner3.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.jarsoft.banner3.entity.Banner;
import com.jarsoft.banner3.entity.Views;
import com.jarsoft.banner3.repository.BannerRepo;
import com.jarsoft.banner3.service.BannerService;
import java.util.List;
import org.springframework.beans.BeanUtils;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banner")
public class BannerController {
  private final BannerRepo bannerRepo;

  private final BannerService bannerService;

  public BannerController(BannerRepo bannerRepo, BannerService bannerService) {
    this.bannerRepo = bannerRepo;
    this.bannerService = bannerService;
  }

  @GetMapping
  @JsonView(Views.IdName.class)
  public List<Banner> list() {
    return bannerService.getAllBaners();
  }

  @GetMapping("{id}")
  @JsonView(Views.FullMessage.class)
  public Banner getOne(@PathVariable("id") Banner banner) {
    return banner;
  }

  @PostMapping
  public Banner create(@RequestBody Banner banner) {
    return bannerService.saveBanner(banner);
  }

  @PutMapping("{id}")
  public Banner update(@PathVariable("id") Banner bannerFromDb, @RequestBody Banner banner) {
    BeanUtils.copyProperties(banner, bannerFromDb, "id");
    // return bannerRepo.save(bannerFromDb);
    return bannerService.saveBanner(bannerFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") Banner banner) {
    // bannerRepo.delete(banner);
    bannerService.deleteBanner(banner.getId());
  }
}
