package com.revature.cookbook.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.revature.cookbook.dtos.requests.NewLoginRequest;
import com.revature.cookbook.dtos.requests.NewUserRequest;
import com.revature.cookbook.dtos.responses.Principal;
import com.revature.cookbook.entities.Role;
import com.revature.cookbook.entities.User;
import com.revature.cookbook.repositories.UserRepository;
import com.revature.cookbook.utils.custom_exceptions.UserNotFoundException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.revature.cookbook.dtos.responses.Greeter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * The UserService class provides operations related to user management.
 */
@Service
public class GreeterService {
   
    public String greet() {
        Greeter greeter = new Greeter();
        String s = new String("helloworld");
        return s ;
    }

    public List<Greeter> getAllRecipes() {
        Greeter greeter1 = new Greeter("recipe1");
        Greeter greeter2 = new Greeter("recipe2");
        List<Greeter> list = new ArrayList<Greeter>();
        list.add(greeter1);
        list.add(greeter2);

        return list;
    }


}