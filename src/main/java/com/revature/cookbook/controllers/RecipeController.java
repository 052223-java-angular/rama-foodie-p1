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

import com.revature.cookbook.dtos.requests.NewRecipeRequest;
//import com.revature.cookbook.dtos.requests.NewRestaurantRequest;
//import com.revature.cookbook.entities.Restaurant;

import com.revature.cookbook.dtos.requests.NewRecipeRequest;
import com.revature.cookbook.entities.Review;

import jakarta.servlet.http.HttpServletRequest;

import com.revature.cookbook.dtos.responses.Greeter;
import com.revature.cookbook.services.RecipeService;
import com.revature.cookbook.dtos.responses.RecipeInfo;
import com.revature.cookbook.entities.Recipe;

import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.*;


@AllArgsConstructor
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    // dependency injection ie. services
    private final RecipeService recipeService;
    
    @PostMapping("/create")
    public ResponseEntity<?> createRestaurant(@RequestBody NewRecipeRequest req, HttpServletRequest sreq) {
        // only admins can create new restaurant

        String token = sreq.getHeader("auth-token");

        // get token from req
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> list = recipeService.getAllRecipes();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable(required = false) String id ) {
        String str = new String(id);
        Recipe recipe = recipeService.getById(str);
        
        return ResponseEntity.status(HttpStatus.OK).body(recipe);
    }

    @GetMapping("/bycusine/{cusine}")
    public ResponseEntity<List<Recipe>> getByCusine(@PathVariable(required = false) String cusine) {
        List<Recipe> list = recipeService.getByCusine(cusine);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/calrange")
    public ResponseEntity<List<Recipe>> getByCalorie(@RequestBody NewRecipeRequest req) {
       
        //recipeService.getByCalorie(req);
        List<Recipe> list = recipeService.getByCalorieRange(req);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}