package com.sonata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
