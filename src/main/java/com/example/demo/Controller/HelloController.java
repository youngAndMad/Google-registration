package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Principal hello(Principal principal) {
//        DefaultOidcUser user= (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(user);
//        return "Hello "+user.getEmail()+"</br>"+user.getPicture();
        return principal;
    }
}
