package com.amazonagency.restapi.repository;

import com.amazonagency.restapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
