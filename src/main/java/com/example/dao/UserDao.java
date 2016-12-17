package com.example.dao;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lylllcc on 2016/12/13.
 */
public interface UserDao extends CrudRepository<User,Integer>{
    User findFirstByUsername(String username);
}
