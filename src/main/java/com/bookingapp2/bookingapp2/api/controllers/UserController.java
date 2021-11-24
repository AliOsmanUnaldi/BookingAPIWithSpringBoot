package com.bookingapp2.bookingapp2.api.controllers;

import com.bookingapp2.bookingapp2.business.abstracts.UserService;
import com.bookingapp2.bookingapp2.core.utilities.DataResult;
import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.core.utilities.SuccessResult;
import com.bookingapp2.bookingapp2.entity.User;
import com.bookingapp2.bookingapp2.entity.dtos.AddUserDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){

        super();
        this.userService=userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){

        return this.userService.getAll();
    }


    @PostMapping("/addUser")
    public Result addUser(@RequestBody AddUserDto addUserDto){

        return this.userService.add(addUserDto);
    }

    @GetMapping("/getUserById")
    public DataResult<User> getUserByUserId(@RequestParam long userId){

        return this.userService.getByUserId(userId);
    }

    @GetMapping("/getUserByUserName")
    public DataResult<User> getUserByUserName(@RequestParam String userName){

        return this.userService.getByUserName(userName);
    }

    @DeleteMapping("/deleteUserById/{userId}")
    public Result deleteUserById(@PathVariable long userId){

        return this.userService.deleteById(userId);
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody UpdateUserDto updateUserDto){

        return userService.update(updateUserDto);
    }
}
