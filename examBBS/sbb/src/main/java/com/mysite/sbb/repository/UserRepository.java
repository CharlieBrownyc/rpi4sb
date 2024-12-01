package com.mysite.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.sbb.entity.SiteUser;

public interface UserRepository extends JpaRepository<SiteUser, Long>{
    
}
