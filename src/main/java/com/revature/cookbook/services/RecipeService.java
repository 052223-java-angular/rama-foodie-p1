package com.revature.cookbook.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.revature.cookbook.dtos.requests.NewLoginRequest;
import com.revature.cookbook.dtos.requests.NewUserRequest;
import com.revature.cookbook.dtos.responses.Principal;
import com.revature.cookbook.entities.Role;
import com.revature.cookbook.entities.User;
import com.revature.cookbook.entities.Recipe;
import com.revature.cookbook.repositories.UserRepository;
import com.revature.cookbook.repositories.RecipeRepository;
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
@AllArgsConstructor
public class RecipeService {
    
    private final RecipeRepository recipeRepo;


    public List<Recipe> getAllRecipes() {
        //Recipe recipe1 = new Recipe("recipe1");
        //Recipe recipe2 = new Recipe("recipe2");

        return recipeRepo.findAll();
      
        //List<Recipe> list = new ArrayList<Recipe>();
        //list.add(recipe1);
        //list.add(recipe2);

        // Get from the db
        //return null;
    }

    public Recipe getById(String id) {
        
        Optional<Recipe> recipeOpt =  recipeRepo.findById(id);

        return recipeOpt.get();
    }


}