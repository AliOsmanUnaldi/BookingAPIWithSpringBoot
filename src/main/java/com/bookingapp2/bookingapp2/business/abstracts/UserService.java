package com.bookingapp2.bookingapp2.business.abstracts;

import com.bookingapp2.bookingapp2.core.utilities.DataResult;
import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.entity.User;

import java.util.List;


public interface UserService {

    DataResult<List<User>> getAll();

    DataResult<List<User>> getAllSorted();

    Result add(User user);

    DataResult<User> getByUserId(long userId);

    DataResult<User> getByUserName(String userName);

    Result deleteById(long userId);



}
