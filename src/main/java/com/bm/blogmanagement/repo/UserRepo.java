package com.bm.blogmanagement.repo;

import com.bm.blogmanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<Users, Integer> {

    @Query(value = "select * from tbl_user where phone = ?1 or email = ?1", nativeQuery = true)
    Users getUsersByUserName(String userName);

}
