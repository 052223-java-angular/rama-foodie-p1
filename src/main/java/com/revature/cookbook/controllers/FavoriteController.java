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

import com.revature.cookbook.dtos.responses.FavoriteRes;
import com.revature.cookbook.dtos.requests.NewReviewRequest;
import com.revature.cookbook.dtos.requests.NewFavoriteRequest;

import jakarta.servlet.http.HttpServletRequest;

import com.revature.cookbook.dtos.responses.Greeter;
import com.revature.cookbook.dtos.responses.RecipeInfo;

import com.revature.cookbook.entities.Recipe;
import com.revature.cookbook.entities.Review;
import com.revature.cookbook.entities.Favorite;

import lombok.AllArgsConstructor;

import com.revature.cookbook.services.JwtTokenService;
import com.revature.cookbook.services.UserService;
import com.revature.cookbook.services.ReviewService;
import com.revature.cookbook.services.RecipeService;
import com.revature.cookbook.services.FavoriteService;

import com.revature.cookbook.utils.custom_exceptions.InvalidTokenException;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://rscookbookbucket.s3-website-us-west-1.amazonaws.com")
@AllArgsConstructor
@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    // dependency injection ie. services
    private final RecipeService recipeService;
    private final UserService userService;
    private final JwtTokenService tokenService;
    private final ReviewService reviewService;
    private final FavoriteService favoriteService;


    @PostMapping("/create")
    public ResponseEntity<?> addToFavorite(@RequestBody NewFavoriteRequest req, HttpServletRequest sreq ) {

        String token = sreq.getHeader("auth-token");

        //exception is thrown if there is an error.
        String username = userService.authenticateUser(token);

        favoriteService.save(req, username);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/myfav")
    //public ResponseEntity<List<FavoriteRes>> getMyFavorites(@RequestBody NewFavoriteRequest req, HttpServletRequest sreq ) {
    public ResponseEntity<List<FavoriteRes>> getMyFavorites( HttpServletRequest sreq ) {

        String token = sreq.getHeader("auth-token");

        //System.out.println("token is " + token );
        
        //exception is thrown if there is an error.
        String username = userService.authenticateUser(token);

        //System.out.println("username in fav controller " + username );

        List<FavoriteRes> list = favoriteService.getAllRecipes(username);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") String recipe_id, HttpServletRequest sreq ) {
        String token = sreq.getHeader("auth-token");

        //exception is thrown if there is an error.
        String username = userService.authenticateUser(token);

        System.out.println("username and recipe+id " + username + " " + recipe_id);

        boolean b = favoriteService.delete(recipe_id, username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // @DeleteMapping("/delete/{id}")
    // public ResponseEntity<?> deleteById(@PathVariable(value = "id") String recipe_id, HttpServletRequest sreq ) {
    //     String token = sreq.getHeader("auth-token");

    //     // Decrpt the token
    //     String username = tokenService.extractUsername(token);

    //     // Validate the user
    //     if ( userService.isUniqueUsername(username) == false ){
    //         //Get json data from the request
    //         System.out.println("recipeOd " + recipe_id);
    //         favoriteService.delete(recipe_id, username);
    //     }
        
    //     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    // }
    
    // @PostMapping("/myfav")
    // public ResponseEntity<List<FavoriteRes>> getMyFavorites(@RequestBody NewFavoriteRequest req, HttpServletRequest sreq ) {

    //     String token = sreq.getHeader("auth-token");
        
    //     //Extract userid via token
    //     try {
    //         String userId = tokenService.extractUserId(token);
    //     } catch (Exception e ){
    //         System.out.println("bad token");
    //          throw new InvalidTokenException("Token is not valid!");
    //     }

    //     String username = tokenService.extractUsername(token);
        
    //     // Validate the user in the db
    //     if ( userService.isUniqueUsername(username) == false ){
    //         System.out.println("get all recipes");
    //         //Get json data from the request
    //         List<FavoriteRes> list = favoriteService.getAllRecipes(username);
    //         return ResponseEntity.status(HttpStatus.OK).body(list);
    //     }
    //     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // handle this
    // }
    

}