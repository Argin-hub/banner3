package com.jarsoft.banner3.security;

import com.jarsoft.banner3.entity.User;
import com.jarsoft.banner3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

  private final UserRepo userRepo;

  @Autowired
  public UserDetailServiceImpl(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user =
        userRepo
            .findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("user " + "doesnt exist"));
    return SecurityUser.fromUser(user);
  }
}
