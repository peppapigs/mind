package com.xg.controller;

import com.xg.entity.User;
import com.xg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class LoginController {

   @Autowired
   UserService userService;

   @GetMapping("/findAll")
   public List<User> findAll(){
      return userService.getAll();
   }

   @PostMapping("/updateNameByEmail")
   public String updateNameByEmail(@RequestBody User user){
      return userService.updateNameByEmail(user);
   }

   @GetMapping("/add")
   public boolean add(User user) {

      return userService.save(user);
   }
}
