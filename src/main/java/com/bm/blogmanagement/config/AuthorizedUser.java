package com.bm.blogmanagement.config;

import com.bm.blogmanagement.entity.Users;

public class AuthorizedUser {

    private static Users users;

    public static Users getUsers() {
        return users;
    }

    public static void setUsers(Users users) {
        AuthorizedUser.users = users;
    }


}
