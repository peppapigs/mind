package com.xg.controller;

import com.xg.entity.User;
import com.xg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/all")
    public List<User> findAll(){
        return loginService.findAll();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user){

        int i = loginService.addUser(user);
        if (i > 0)
            return "added a user! " + user.getUsername();
        else
            return "added failed!";
    }

    @GetMapping("/update/{oldUsername}/{newUsername}")
    public String updateUser(
            @PathVariable("oldUsername") String oldUsername,
            @PathVariable("newUsername") String newUsername){
        int i = loginService.updateUser(oldUsername, newUsername);
        if(i > 0)
            return "modified " + oldUsername + " to " + newUsername;
        else
            return "modified failed!";
    }

    @DeleteMapping("/delete/{username}")
    public String deleteUser(String username){
        int i = loginService.deleteUser(username);
        if(i > 0)
            return "deleted!";
        else
            return "deleted failed!";
    }
}
