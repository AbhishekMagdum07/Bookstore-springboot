package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.mailSender.EmailSenderService;
import com.bridgelabz.bookstore.model.ForgetPassword;
import com.bridgelabz.bookstore.model.Register;
import com.bridgelabz.bookstore.model.UserLogin;
import com.bridgelabz.bookstore.repository.UserRepo;
import com.bridgelabz.bookstore.responseDto.ResponseDTO;
import com.bridgelabz.bookstore.utility.TokenUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
@Slf4j
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EmailSenderService service;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private TokenUtility tokenUtility;

    private Random random = new Random();
    HashMap<Integer, Register> map = new HashMap();
    HashMap<Integer, Long> storeOtp = new HashMap();
    HashMap<Integer,String> storeEmail = new HashMap<>();

    private long generateRandomOtp() {
        return random.nextInt(900000) + 100000;
    }

    @Override
    public ResponseDTO saveCustomerDetails(UserDTO userDTO) {
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        Register register = new Register(userDTO);
        map.put(1, register);
        long otp = generateRandomOtp();
        storeOtp.put(1, otp);
        service.sendSimpleEmail(userDTO.getEmail(), String.valueOf(otp), "OTP");
        return new  ResponseDTO("OTP sent to entered email id",register);

    }

    @Override
    public ResponseDTO validateUser(Long otpByUser) {
        System.out.println(map.isEmpty());
        System.out.println(otpByUser);
        System.out.println(storeOtp.get(1));
        if (otpByUser.equals(storeOtp.get(1))) {
            userRepo.save(map.get(1));
            storeOtp.remove(1);
            map.remove(1);
            return new ResponseDTO("Registration Successfull", null);
        } else {
            throw new IllegalArgumentException("Invalid OTP");
        }
    }

    @Override
    public String login(UserLogin userLogin) {
        Register register = userRepo.findByEmails6t7u8v9w0(userLogin.getEmail());
        if (register != null && passwordEncoder.matches(userLogin.getPassword(), register.getPasswordR3D5C4T2W1L0())) {
            String token = tokenUtility.createToken(register.getEmails6t7u8v9w0(), register.getId());
            return token;
        } else {
            return null;
        }
    }

    @Override
    public String resetPassword(ForgetPassword forgetPassword) {
        Register register1 = userRepo.findByEmails6t7u8v9w0(forgetPassword.getEmail());
        if (passwordEncoder.matches(forgetPassword.getOldPassword(), register1.getPasswordR3D5C4T2W1L0())) {
            register1.setPasswordR3D5C4T2W1L0(passwordEncoder.encode(forgetPassword.getNewPassword()));
            userRepo.save(register1);
            return "Password Updated Successfully";
        } else
            return "Enter valid Details.";
    }

    @Override
    public String forgetPassword(String email) {
        long otp = generateRandomOtp();
        storeOtp.put(1, otp);
        storeEmail.put(1,email);
        service.sendSimpleEmail(email, String.valueOf(otp), "OTP for updating your password");
        System.out.println(storeEmail.get(1));
        return "OTP sent to you main id";
    }

    @Override
    public String newPassword(Long otp, String newPassword) {
        Register register = userRepo.findByEmails6t7u8v9w0(storeEmail.get(1));
        System.out.println(storeEmail.get(1));
        System.out.println(otp);
        System.out.println(storeOtp.get(1));
        if (otp.equals(storeOtp.get(1))){
            storeOtp.remove(1);
            storeEmail.remove(1);
            register.setPasswordR3D5C4T2W1L0(passwordEncoder.encode(newPassword));
            userRepo.save(register);
            return "Password Updated Successfully";
        } else
            return "Enter valid Details.";
    }


}
