package com.bookingapp2.bookingapp2.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDto {

    private long adminId;

    private String userName;

    private String password;

    private boolean isAdmin;

}
