package com.revature.cookbook.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cookbook.dtos.requests.NewRestaurantRequest;
//import com.revature.cookbook.entities.Restaurant;

import jakarta.servlet.http.HttpServletRequest;

import com.revature.cookbook.dtos.responses.Greeter;
import com.revature.cookbook.services.RecipeService;
import com.revature.cookbook.dtos.responses.RecipeInfo;
import com.revature.cookbook.entities.Recipe;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    // dependency injection ie. services
    private final RecipeService recipeService;
    
    //private final RecipeService recipeService = new RecipeService();


    @PostMapping("/create")
    public ResponseEntity<?> createRestaurant(@RequestBody NewRestaurantRequest req, HttpServletRequest sreq) {
        // only admins can create new restaurant

        String token = sreq.getHeader("auth-token");

        // get token from req
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> list = recipeService.getAllRecipes();
        // userservice to call login method
        //List<Recipe> list = recipeService.getAllRecipes();
        return ResponseEntity.status(HttpStatus.OK).body(list);
        //return null;
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable(required = false) String id ) {
        String str = new String(id);
        Recipe recipe = recipeService.getById(str);
        //RecipeInfo ri = new RecipeInfo();
        return ResponseEntity.status(HttpStatus.OK).body(recipe);
        //return null;
    }
}