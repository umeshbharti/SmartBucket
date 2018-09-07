package com.cg.smartbucket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.cg.smartbucket.model.User;

@Component
public interface UserRepository extends CrudRepository<User,Integer>{

}
