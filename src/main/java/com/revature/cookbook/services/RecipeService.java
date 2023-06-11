package com.revature.cookbook.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.revature.cookbook.dtos.requests.NewLoginRequest;
import com.revature.cookbook.dtos.requests.NewRecipeRequest;
import com.revature.cookbook.dtos.requests.NewUserRequest;
import com.revature.cookbook.dtos.responses.Principal;
import com.revature.cookbook.entities.Role;
import com.revature.cookbook.entities.User;
import com.revature.cookbook.entities.Recipe;
import com.revature.cookbook.repositories.UserRepository;
import com.revature.cookbook.repositories.RecipeRepository;
import com.revature.cookbook.utils.custom_exceptions.ReviewNotFoundException;
import com.revature.cookbook.utils.custom_exceptions.UserNotFoundException;
import com.revature.cookbook.utils.custom_exceptions.CusineNotFoundException;

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
        return recipeRepo.findAll();
    }

    public Recipe getById(String id) {
        
        Optional<Recipe> recipeOpt =  recipeRepo.findById(id);
        if (recipeOpt.isPresent()){
            return recipeOpt.get();
        }
        throw new CusineNotFoundException("This recipe does not exist");
    }

    public List<Recipe> getByCusine(String cusine) {
        
        List<Recipe> recipeList =  recipeRepo.findByCusine(cusine);
        if( recipeList.size() > 0){
            return recipeList;
        } 
        throw new CusineNotFoundException("No recipe exists for this cusine");
    }

     public List<Recipe> getByCalorieRange(NewRecipeRequest req) {
        
        int lowerRange = req.getLowerRange();
        int upperRange = req.getUpperRange();
        
        return recipeRepo.findByRecipes(lowerRange, upperRange);
    }



}