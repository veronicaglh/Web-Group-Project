package com.Group11.Mekinaye.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {
   private static final Admin Admin = null;
private String username;
   private String password;
   private String fullName;
   private String phone;

   User toUser(PasswordEncoder encoder) {
       User user = new User();
       user.setUsername(this.username);
       user.setPassword(encoder.encode(this.password));
       user.setFullName(this.fullName);
       user.setPhone(this.phone);
       return user;
   }
   Admin toAdmin(PasswordEncoder encoder) {
    User user = new User();
    user.setUsername(this.username);
    user.setPassword(encoder.encode(this.password));
    user.setFullName(this.fullName);
    user.setPhone(this.phone);
    return Admin;
}
}

