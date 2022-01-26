package com.Group11.Mekinaye.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AdminDetailsService {
    UserDetails loadAdminByUsername(String username) 
 throws UsernameNotFoundException;
 }
 