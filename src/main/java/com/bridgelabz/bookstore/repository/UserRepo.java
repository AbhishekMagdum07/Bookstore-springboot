package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Register,Long> {
    Register findByEmails6t7u8v9w0(String email);

//    @Query("SELECT new packageName.Cliente(c.idCliente, c.nome, c.cognome, c.username, c.email) FROM Cliente c WHERE c.username LIKE %:username%")
//    List<Register> findSpecific();



//    @Transactional
//    @Modifying
//    @Query(value = "ALTER TABLE register DROP COLUMN otp", nativeQuery = true)
//    void dropOtpColumn();

}
