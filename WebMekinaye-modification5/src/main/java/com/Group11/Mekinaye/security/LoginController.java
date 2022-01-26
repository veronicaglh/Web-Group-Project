package com.Group11.Mekinaye.security;

// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.validation.Errors;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    
    @PostMapping
    public String processLogin(Errors errors) {
        if (errors.hasErrors()){
          return "login";
      }
          
        return "redirect:/service";
       }
}
