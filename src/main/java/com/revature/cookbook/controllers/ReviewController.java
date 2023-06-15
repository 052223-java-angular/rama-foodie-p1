package com.revature.cookbook.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.revature.cookbook.dtos.requests.NewRestaurantRequest;
import com.revature.cookbook.dtos.requests.NewReviewRequest;

import jakarta.servlet.http.HttpServletRequest;

import com.revature.cookbook.dtos.responses.Greeter;
import com.revature.cookbook.dtos.responses.RecipeInfo;

import com.revature.cookbook.entities.Recipe;
import com.revature.cookbook.entities.Review;

import lombok.AllArgsConstructor;

import com.revature.cookbook.services.JwtTokenService;
import com.revature.cookbook.services.UserService;
import com.revature.cookbook.services.ReviewService;
import com.revature.cookbook.services.RecipeService;

@AllArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    // dependency injection ie. services
    private final RecipeService recipeService;
    private final UserService userService;
    private final JwtTokenService tokenService;
    private final ReviewService reviewService;


    @PostMapping("/create")
    public ResponseEntity<?> createReview(@RequestBody NewReviewRequest req, HttpServletRequest sreq ) {

        String token = sreq.getHeader("auth-token");

        //exception is thrown if there is an error.
        String username = userService.authenticateUser(token);

        reviewService.save(req, username);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") String recipe_id, HttpServletRequest sreq ) {
        String token = sreq.getHeader("auth-token");

        //Exception is thrown if there is an error.
        String username = userService.authenticateUser(token);

        reviewService.deleteReview(username, recipe_id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

/*************************************************************************************************************
@AllArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    // dependency injection ie. services
    private final RecipeService recipeService;
    private final UserService userService;
    private final JwtTokenService tokenService;
    private final ReviewService reviewService;


    @PostMapping("/create")
    public ResponseEntity<?> createReview(@RequestBody NewReviewRequest req, HttpServletRequest sreq ) {
        // only admins can create new restaurant

        String token = sreq.getHeader("auth-token");

        // Decrpt the token
        String username = tokenService.extractUsername(token);
        
        // Validate the user
        if ( userService.isUniqueUsername(username) == false ){
            //Get json data from the request
            reviewService.save(req, username);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editReview(@RequestBody NewReviewRequest req, HttpServletRequest sreq ) {
        String token = sreq.getHeader("auth-token");

        System.out.println("in edite route");

        // Decrpt the token
        String username = tokenService.extractUsername(token);
        
        //Optional<Review> review = reviewService.editReview(req, username);
        reviewService.editReview(req, username);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        //return null;
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") String recipe_id, HttpServletRequest sreq ) {
        String token = sreq.getHeader("auth-token");

        // Decrpt the token
        String username = tokenService.extractUsername(token);

        // Validate the user
        if ( userService.isUniqueUsername(username) == false ){
            //Get json data from the request
            reviewService.deleteReview(username, recipe_id);
        }

        return null;
    }

}
*****/