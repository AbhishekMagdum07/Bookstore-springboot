package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.model.ForgetPassword;
import com.bridgelabz.bookstore.model.UserLogin;
import com.bridgelabz.bookstore.response.ErrorResponse;
import com.bridgelabz.bookstore.response.LoginResponse;
import com.bridgelabz.bookstore.responseDto.ResponseDTO;
import com.bridgelabz.bookstore.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserServiceI registerServiceI;


    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> saveCustomerDetails(@RequestBody UserDTO userDTO) {
        ResponseDTO users = registerServiceI.saveCustomerDetails(userDTO);
        ResponseDTO responseDTO = new ResponseDTO(" OTP sent to your email address", users);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    /**
     * Validating the otp of user
     * @param otpByUser
     * @return = success message
     */

    @PostMapping("/validate")
    public ResponseEntity<ResponseDTO> validateUser(@RequestParam Long otpByUser) {
        ResponseDTO users = registerServiceI.validateUser(otpByUser);
        ResponseDTO responseDTO = new ResponseDTO(" registration successful", users );
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin) {
        String token = registerServiceI.login(userLogin);
        if (token != null) {
            // Successful login, return the token
            System.out.println("okay");
            System.out.println(token);
            return ResponseEntity.ok(new LoginResponse(token));
        } else {
            // Failed login, return an error message
            System.out.println("not");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Login Failed"));
        }
    }
    @PatchMapping("/updatePassword")
    public String resetPassword(@RequestBody ForgetPassword forgetPassword) {
        return registerServiceI.resetPassword(forgetPassword);
    }
    @GetMapping("/forgetPassword")
    public String forgetPassword(@RequestParam String email) {
        return registerServiceI.forgetPassword(email);
    }
    @PatchMapping("/newPassword")
    public String newPassword(@RequestParam Long otp , String newPassword) {
        return registerServiceI.newPassword(otp,newPassword);
    }
}
