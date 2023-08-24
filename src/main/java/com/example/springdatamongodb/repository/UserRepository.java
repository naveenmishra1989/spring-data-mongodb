package com.example.springdatamongodb.repository;

import com.example.springdatamongodb.dacument.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
}
