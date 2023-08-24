package com.example.springdatamongodb.controller;

import com.example.springdatamongodb.dacument.User;
import com.example.springdatamongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public ResponseEntity<List<User>> getUsers() {
        final List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }
    @PostMapping("/create")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        final User save = userRepository.save(user);
     return ResponseEntity.ok(save);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findUser(@PathVariable("id") Integer userId){
        final Optional<User> user = userRepository.findById(userId);
        if (user.isPresent())
            return ResponseEntity.ok(user.get());
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        final Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()){
            final User userExist = userOptional.get();
            userExist.setName(user.getName());
            userExist.setTeamName(user.getTeamName());
            userExist.setSalary(user.getSalary());
            final User UpdatedUser = userRepository.save(userExist);
            return ResponseEntity.ok(UpdatedUser);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable  Integer id){
        final Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }
}
