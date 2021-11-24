package com.bookingapp2.bookingapp2.business.abstracts;

import com.bookingapp2.bookingapp2.core.utilities.DataResult;
import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.entity.User;
import com.bookingapp2.bookingapp2.entity.dtos.AddUserDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateUserDto;

import java.util.List;


public interface UserService {

    DataResult<List<User>> getAll();

    Result add(AddUserDto addUserDto);

    DataResult<User> getByUserId(long userId);

    DataResult<User> getByUserName(String userName);

    Result deleteById(long userId);

    Result update(UpdateUserDto updateUserDto);

    Result deleteUserById(long userId);



}
