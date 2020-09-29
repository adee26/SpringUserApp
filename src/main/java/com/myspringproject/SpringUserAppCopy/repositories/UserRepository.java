package com.myspringproject.SpringUserAppCopy.repositories;

import com.myspringproject.SpringUserAppCopy.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName (String name);
    List<User> findAll();
}
