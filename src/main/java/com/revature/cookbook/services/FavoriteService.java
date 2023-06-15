package com.revature.cookbook.services;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.revature.cookbook.dtos.requests.NewLoginRequest;
import com.revature.cookbook.dtos.requests.NewUserRequest;
import com.revature.cookbook.dtos.requests.NewReviewRequest;
import com.revature.cookbook.dtos.requests.NewFavoriteRequest;
import com.revature.cookbook.dtos.responses.Principal;
import com.revature.cookbook.dtos.responses.FavoriteRes;

import com.revature.cookbook.entities.Role;
import com.revature.cookbook.entities.User;
import com.revature.cookbook.entities.Favorite;
import com.revature.cookbook.entities.Recipe;
import com.revature.cookbook.entities.Review;

import com.revature.cookbook.repositories.UserRepository;
import com.revature.cookbook.repositories.RecipeRepository;
import com.revature.cookbook.repositories.ReviewRepository;
import com.revature.cookbook.repositories.FavoriteRepository;

import com.revature.cookbook.utils.custom_exceptions.UserNotFoundException;
import com.revature.cookbook.utils.custom_exceptions.InvalidTokenException;
import com.revature.cookbook.utils.custom_exceptions.ReviewNotFoundException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.revature.cookbook.dtos.responses.Greeter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.revature.cookbook.utils.custom_exceptions.ResourceConflictException;
/**
 * The UserService class provides operations related to user management.
 */
@Service
@AllArgsConstructor
public class FavoriteService {

    private final ReviewRepository reviewRepo;
    private final UserRepository userRepo;
    private final RecipeRepository recipeRepo;
    private final FavoriteRepository favoriteRepo;

    public void save(NewFavoriteRequest req, String username) {
        Optional<User> userOpt = userRepo.findByUsername(username);
        User user = userOpt.get();

        String recipe_id = req.getRecipe_id();
       
        Recipe recipe= new Recipe();
        recipe.setId(recipe_id);
        Favorite fav = new Favorite(recipe_id, username, user, recipe);
        try {
            favoriteRepo.save(fav);
        } catch(Exception e ){
             throw new ResourceConflictException("This is alredy in your fav list");
        }
    }

    public List<FavoriteRes> getAllRecipes(String username) {
        List<Favorite> favList =  favoriteRepo.findByUsername(username);
        List<FavoriteRes> fList = new <FavoriteRes>ArrayList();
        
        for( int i=0; i<favList.size(); i++){
            Favorite f = favList.get(i);
            Recipe rec = f.getRecipe();
            String title = rec.getTitle();
            String url = rec.getUrl();
            String recipe_id = rec.getId();
            FavoriteRes fr = new FavoriteRes(recipe_id, title, url, username);
            fList.add(fr);
        }
        return fList;
    }

    public boolean delete(String recipe_id, String username){
        Optional<Recipe> recipeOpt = recipeRepo.findById(recipe_id);
        if ( recipeOpt.isPresent()){
            // get list of favorite
         
            List<Favorite> favList = favoriteRepo.findByUsername(username);
            // Find out the id from favorites for username passed
            for( int i=0; i<favList.size(); i++ ){
                Favorite fav = favList.get(i);
                if ( fav.getRid().equals(recipe_id)) {
                    String id = fav.getId();
                    favoriteRepo.deleteById(id);
                    return true;
                }
            }
        }
        return false;
    }

    // public List<Favorite> getAllRecipes(String username) {
    //     //return favoriteRepo.findByUsername(username);
    //     System.out.println("username who asked for favorites " + username);
    //     List<Favorite> list = favoriteRepo.findByUsername(username);
    //     System.out.println("size is " + list.size());
    //     // Iterate through the list to see if u can get the review
    //     for( int i=0; i<list.size(); i++ ){
    //         Favorite fav = list.get(i);

    //         String rid = fav.getRid();
    //         Recipe r = fav.getRecipe();
    //         Set<Review> allReviews = r.getReviews();
    //         // iterate through the set
    //         System.out.println("username who asked for favorites " + username);
    //         for (Review rv : allReviews) {
    //             System.out.println(rv.getRid() + ";" + rv.getUsername() + ";" +  rv.getRating() + ";" + rv.getComment());
    //         }
    //     }
    //     return list;

    // }



    
}
