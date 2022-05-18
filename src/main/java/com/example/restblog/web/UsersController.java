package com.example.restblog.web;

import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private List<User> userList = setUserList();

    @GetMapping
    public List<User> getAll() {
        return userList;
    }

    @GetMapping("(id)")
    public User getById(@PathVariable long id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
    }

    @PostMapping
    public void create(@RequestBody User newUser) {
        userList.add(newUser);
    }

    //just for testing
    private List<User> setUserList() {
        List<User> UserList = new ArrayList<>();
        userList.add(new User("billybob", "billybob.com", "1234"));
        userList.add(new User("sindy", "sindy.com", "432211234"));

    }
}


