package com.sample.Login.repo;

import org.springframework.data.repository.CrudRepository;

import com.sample.Login.entity.Users;

public interface UserRepository extends CrudRepository<Users, Integer>{

}
