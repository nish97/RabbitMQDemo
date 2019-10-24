package com.stackroute.userprofileservice.repository;

import com.stackroute.userprofileservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findByUserName(String userName);
}
