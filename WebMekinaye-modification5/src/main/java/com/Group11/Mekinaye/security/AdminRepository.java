package com.Group11.Mekinaye.security;

import org.springframework.data.repository.CrudRepository;
public interface AdminRepository extends CrudRepository<Admin, Long> {
    public User findByUsername(String username);
 }
 