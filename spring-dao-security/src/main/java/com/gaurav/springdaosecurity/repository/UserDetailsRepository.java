package com.gaurav.springdaosecurity.repository;

import com.gaurav.springdaosecurity.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<AppUser,String> {
}
