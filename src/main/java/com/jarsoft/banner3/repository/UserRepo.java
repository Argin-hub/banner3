package com.jarsoft.banner3.repository;

import com.jarsoft.banner3.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
}
