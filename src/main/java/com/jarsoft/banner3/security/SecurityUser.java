package com.jarsoft.banner3.security;

import com.jarsoft.banner3.entity.Status;

import java.util.List;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class SecurityUser implements UserDetails {
  private final String username;
  private final String password;
  private final List<SimpleGrantedAuthority> authorities;
  private final boolean isActive;

  public SecurityUser(
      String username,
      String password,
      List<SimpleGrantedAuthority> authorities,
      boolean isActive) {
    this.username = username;
    this.password = password;
    this.authorities = authorities;
    this.isActive = isActive;
  }

  public final List<SimpleGrantedAuthority> getAuthorities() {
    return authorities;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return isActive;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isActive;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isActive;
  }

  @Override
  public boolean isEnabled() {
    return isActive;
  }

  public static UserDetails fromUser(com.jarsoft.banner3.entity.User user) {
    return new User(
        user.getEmail(),
        user.getPassword(),
        user.getStatus().equals(Status.ACTIVE),
        user.getStatus().equals(Status.ACTIVE),
        user.getStatus().equals(Status.ACTIVE),
        user.getStatus().equals(Status.ACTIVE),
        user.getRole().getAuthority());
  }
}
