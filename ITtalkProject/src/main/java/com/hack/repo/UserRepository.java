package com.hack.repo;

import com.hack.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findOne(Long id);
    public List<User> findAll();
}
