package com.bookingapp2.bookingapp2.business.concretes;

import com.bookingapp2.bookingapp2.business.abstracts.UserService;
import com.bookingapp2.bookingapp2.core.utilities.*;
import com.bookingapp2.bookingapp2.dataAccess.TicketDao;
import com.bookingapp2.bookingapp2.dataAccess.UserDao;
import com.bookingapp2.bookingapp2.entity.User;
import com.bookingapp2.bookingapp2.entity.dtos.AddUserDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;
    private TicketDao ticketDao;

    @Autowired
    public UserManager(UserDao userDao,TicketDao ticketDao){

        super();
        this.userDao=userDao;
        this.ticketDao=ticketDao;
    }

    @Override
    public DataResult<List<User>> getAll() {

        return new SuccessDataResult<List<User>>
                (this.userDao.findAll(),"DATALAR LİSTELENDİ.");
    }


    @Override
    public Result add(AddUserDto addUserDto) {
        //only admin
        if (userDao.getByUserId(addUserDto.getAdminId()).isAdmin()){

            try {
                User user=new User(
                        addUserDto.getUserName(),
                        addUserDto.getPassword(),
                        addUserDto.isAdmin());

                userDao.save(user);

                return new SuccessResult("Kullanıcı eklendi.");
            }

            catch (Exception e){
                return new ErrorResult(false,e.getMessage());
            }

        }
        else return new ErrorResult(false,"Bu işlemi sadece admin yapabilir!");
    }

    @Override
    public DataResult<User> getByUserId(long userId) {

        return new SuccessDataResult<User>(this.userDao.getByUserId(userId),"başarılı");
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

    @Override
    public Result update(UpdateUserDto updateUserDto) {
        //only admin
        if (userDao.getByUserId(updateUserDto.getAdminId()).isAdmin()) {

            try {
                User user=userDao.getByUserId(updateUserDto.getUserId());
                user.setUserName(updateUserDto.getUserName());
                user.setPassword(updateUserDto.getPassword());
                user.setAdmin(updateUserDto.isAdmin());

                userDao.save(user);

                return new SuccessResult("Güncellendi.");
            }

            catch (Exception e){
                return new ErrorResult(false,e.getMessage());
            }
        }

        else return new ErrorResult(false,"Bu işlemi sadece admin yapabilir!");


    }

    @Override
    public Result deleteUserById(long userId) {
        //only admin
        if (userDao.getByUserId(userId).isAdmin()) {
            try {
                deleteTicketForUser(userId);
                deleteUserById(userId);
                return new SuccessResult("Kullanıcı silindi.");
            } catch (Exception e) {
                return new ErrorResult(false, e.getMessage());
            }

        }
        else return new ErrorResult(false,"Bu işlemi sadece admin yapabilir!");
    }



    public void deleteTicketForUser(long userId){

        ticketDao.deleteAll(ticketDao.getAllByOwnerId(userId));
    }

}
