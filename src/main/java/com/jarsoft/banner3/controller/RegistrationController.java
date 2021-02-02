package com.jarsoft.banner3.controller;

import com.jarsoft.banner3.entity.Banner;
import com.jarsoft.banner3.entity.User;
import com.jarsoft.banner3.service.UserService;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

  private final UserService userService;

  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('developers:read')")
  public String homePage(Banner banner) {
    return "search";
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @GetMapping("/welcome")
  public String welcomePage() {
    return "welcome";
  }

  @GetMapping("/registration")
  public String registrPage(User user) {
    return "registration";
  }

  @PostMapping("/registration")
  public String registrUser(@Valid User user, BindingResult bindingResult, Model model) {
    User user1 = userService.findByEmail(user.getEmail());
    if (user1 != null) {
      model.addAttribute("errorUser", "Same user exist");
      return "registration";
    } else userService.saveUser(user);
    return "login";
  }

  @GetMapping("/banners")
  @PreAuthorize("hasAuthority('developers:read')")
  public String bannersPage() {
    return "banners";
  }
}
