package com.service;

import com.dao.model.Users;

import java.util.List;

/**
 * Created by ganluting on 17/1/10.
 */
public interface TestService {
    List<Users> getUsers(String name);
}
