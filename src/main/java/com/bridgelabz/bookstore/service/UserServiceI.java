package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.model.ForgetPassword;
import com.bridgelabz.bookstore.model.UserLogin;
import com.bridgelabz.bookstore.responseDto.ResponseDTO;

public interface UserServiceI {

    ResponseDTO validateUser(Long otpByUser);
    ResponseDTO saveCustomerDetails(UserDTO userDTO);

    String login(UserLogin userLogin);

    String resetPassword(ForgetPassword forgetPassword);

    String forgetPassword(String email);

    String newPassword(Long otp, String newPassword);

}
