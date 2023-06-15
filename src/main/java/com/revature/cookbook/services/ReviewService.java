package com.revature.cookbook.services;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.revature.cookbook.dtos.requests.NewLoginRequest;
import com.revature.cookbook.dtos.requests.NewUserRequest;
import com.revature.cookbook.dtos.requests.NewReviewRequest;
import com.revature.cookbook.dtos.responses.Principal;

import com.revature.cookbook.entities.Role;
import com.revature.cookbook.entities.User;
import com.revature.cookbook.entities.Recipe;
import com.revature.cookbook.entities.Review;

import com.revature.cookbook.repositories.UserRepository;
import com.revature.cookbook.repositories.RecipeRepository;
import com.revature.cookbook.repositories.ReviewRepository;

import com.revature.cookbook.utils.custom_exceptions.UserNotFoundException;
import com.revature.cookbook.utils.custom_exceptions.ReviewNotFoundException;

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
public class ReviewService {
    
    private final ReviewRepository reviewRepo;
    private final UserRepository userRepo;
    private final RecipeRepository recipeRepo;

    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public Review getById(String id) {
        
        Optional<Review> reviewOpt =  reviewRepo.findById(id);

        return reviewOpt.get();
    }

    
    public void save(NewReviewRequest req, String username) {
        Optional<User> userOpt = userRepo.findByUsername(username);
        User user = userOpt.get();

        String recipe_id = req.getRecipe_id();
        int rating = req.getRate();
        String comment = req.getComments();
        System.out.println("name from req " + recipe_id + " " + rating + " " + comment);

        Recipe recipe= new Recipe();
        recipe.setId(recipe_id);
       
        Review review = new Review(comment, rating, username, user, recipe );

        List<Review> userReviews = reviewRepo.findByUsername(user.getUsername());
        
        boolean edit = false;

        // Get the review for recipe_id, by 'username' sent, should get only 1 review
        for(int i=0; i<userReviews.size(); i++ ){
            Review rv = userReviews.get(i);
            if ( rv.getRid().equals(recipe_id) ){
                // Edit the review
                edit = true;
                String reviewId = rv.getId();
                System.out.println("Edit the review");
                Review reviewNew = new Review(reviewId, recipe_id, comment, rating, username, user, recipe);
                reviewRepo.save(reviewNew);
                break;
            }
        }

        // if edit is false, create a new review
        if ( edit == false ){
            System.out.println("Edit is false");
            Review review1 = reviewRepo.save(review );
        }
       
    }


    public void deleteReview(String username, String recipe_id){
        List<Review> userReviews = reviewRepo.findByUsername(username);
        
        // Iterate through the list and delete the review for the recipe_id 
        // created by username
        for(int i=0; i<userReviews.size(); i++ ){
            Review rv = userReviews.get(i);

            if ( rv.getRid().equals(recipe_id) ){
                String reviewId = rv.getId();
                reviewRepo.deleteById(reviewId);
                return;
            }
        }
        throw new ReviewNotFoundException("No review for this user");


    }
    

    public void editReview(NewReviewRequest req, String username) {
        Optional<User> userOpt = userRepo.findByUsername(username);
        User user = userOpt.get();
        
        
        String recipe_id = req.getRecipe_id();
        String reviewId = "";
        
        Optional<Recipe> recipeOpt = recipeRepo.findById(recipe_id);
        Recipe recipe = recipeOpt.get();
        

        List<Review> reviewList = reviewRepo.findAll();
        // Iterate through the list
        for( int i=0; i<reviewList.size(); i++ ){
            Review r = reviewList.get(i);
            System.out.println(r.getId() + " " + r.getUsername() + ":" +  r.getComment() + " recipteid is " +  r.getRid() );
            if ( r.getUsername().equals(username) && r.getRid().equals(recipe_id)){
                reviewId = r.getId();
                break;
            }
        }
        int rating = req.getRate();
        String comment = req.getComments();

        Review reviewNew = new Review(reviewId, recipe_id, comment, rating, username, user, recipe);
        reviewRepo.save(reviewNew);

    }




}