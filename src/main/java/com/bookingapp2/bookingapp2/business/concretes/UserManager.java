package com.bookingapp2.bookingapp2.business.concretes;

import com.bookingapp2.bookingapp2.business.abstracts.UserService;
import com.bookingapp2.bookingapp2.core.utilities.*;
import com.bookingapp2.bookingapp2.dataAccess.UserDao;
import com.bookingapp2.bookingapp2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao){
        super();
        this.userDao=userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {

        return new SuccessDataResult<List<User>>
                (this.userDao.findAll(),"DATALAR LİSTELENDİ.");
    }

    @Override
    public DataResult<List<User>> getAllSorted() {

        Sort sort=Sort.by(Sort.Direction.ASC,"userName");
        return new SuccessDataResult<List<User>>
                (this.userDao.findAll(sort),"DATALAR LİSTELENDİ.");
    }

    @Override
    public Result add(User user) {

        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi.");

    }

    @Override
    public DataResult<User> getByUserId(long userId) {

        return new SuccessDataResult<User>(this.userDao.getById(userId),"başarılı");
    }

    @Override
    public DataResult<User> getByUserName(String userName) {

        return new SuccessDataResult<User>(this.userDao.getByUserName(userName),"başarılı");
    }

    @Override
    public Result deleteById(long userId) {

        this.userDao.deleteById(userId);
        return new SuccessResult("Kullanıcı silindi.");
    }

}
