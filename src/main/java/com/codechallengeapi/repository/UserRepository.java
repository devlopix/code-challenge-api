package com.codechallengeapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.codechallengeapi.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
