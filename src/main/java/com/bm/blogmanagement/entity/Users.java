package com.bm.blogmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_user",uniqueConstraints = {
        @UniqueConstraint(name = "unique_user_email",columnNames = "email"),
        @UniqueConstraint(name = "unique_user_phone", columnNames = "phone")
})
@Entity
public class Users {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private String email;

    private String phone;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String password;



}
