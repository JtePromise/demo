package com.service;

import com.dao.UserRepository;
import com.dao.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ganluting on 17/1/10.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "user")
    public List<Users> getUsers(String name) {
        return userRepository.abc(name);
    }
}
