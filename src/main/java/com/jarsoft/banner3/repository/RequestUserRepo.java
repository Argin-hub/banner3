package com.jarsoft.banner3.repository;

import com.jarsoft.banner3.entity.RequestUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public interface RequestUserRepo extends JpaRepository<RequestUser, Integer> {

}
