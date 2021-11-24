package com.bookingapp2.bookingapp2.dataAccess;

import com.bookingapp2.bookingapp2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User getByUserName(String userName);

    User getByUserId(long userId);

}
