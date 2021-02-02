package com.jarsoft.banner3.service;

import com.jarsoft.banner3.entity.Role;
import com.jarsoft.banner3.entity.Status;
import com.jarsoft.banner3.entity.User;
import com.jarsoft.banner3.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepo userRepo;

  public UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public User saveUser(User user) {
    user.setPassword(passwordEncoder().encode(user.getPassword()));
    user.setRole(Role.USER);
    user.setStatus(Status.ACTIVE);
    return userRepo.save(user);
  }

  protected PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

  public User findByEmail(String email) {
    User user =
        userRepo
            .findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("user " + "doesnt exist"));
    return user;
  }
}
