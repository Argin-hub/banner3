package com.jarsoft.banner3.entity;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
  USER(Set.of(Permission.DEVELOPERS_READ)),
  ADMIN(Set.of(Permission.DEVELOPERS_WRITE, Permission.DEVELOPERS_READ));
  //
  private final Set<Permission> permissionSet;

  Role(Set<Permission> permissionSet) {
    this.permissionSet = permissionSet;
  }

  public Set<Permission> getPermissionSet() {
    return permissionSet;
  }

  public Set<SimpleGrantedAuthority> getAuthority() {
    return getPermissionSet().stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
        .collect(Collectors.toSet());
  }
}
