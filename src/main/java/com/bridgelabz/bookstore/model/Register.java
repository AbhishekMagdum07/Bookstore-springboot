package com.bridgelabz.bookstore.model;

import com.bridgelabz.bookstore.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Full_Name")
    private String fullNamex0j3sKlMn7;
    @Column(name = "Date_of_Birth")
    private LocalDate dateOfBirthqRp9Gh5TfW;
    @Column(name = "Gender")
    private String genders6t7u8v9w0;
    @Column(name = "Contact_Number")
    private String contactNumbera1b2c3d4e5f;
    @Column(name = "Email_ID")
    private String emails6t7u8v9w0;
    @Column(name = "Password")
    private String passwordR3D5C4T2W1L0;



    public Register(UserDTO userDTO){
        this.fullNamex0j3sKlMn7 = userDTO.getFullName();
        this.dateOfBirthqRp9Gh5TfW = userDTO.getDateOfBirth();
        this.genders6t7u8v9w0 = userDTO.getGender();
        this.contactNumbera1b2c3d4e5f = userDTO.getContactNumber();
        this.emails6t7u8v9w0 = userDTO.getEmail();
        this.passwordR3D5C4T2W1L0 = userDTO.getPassword();

    }

}
