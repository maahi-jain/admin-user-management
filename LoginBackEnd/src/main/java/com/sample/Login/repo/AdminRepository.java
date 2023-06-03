package com.sample.Login.repo;

import org.springframework.data.repository.CrudRepository;

import com.sample.Login.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin , String>{

}