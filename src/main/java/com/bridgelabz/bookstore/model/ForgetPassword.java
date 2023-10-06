package com.bridgelabz.bookstore.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgetPassword {
   private String email;
   private String oldPassword;
   private String newPassword;
}
