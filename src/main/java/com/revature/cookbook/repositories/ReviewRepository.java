package com.revature.cookbook.repositories;

import java.util.Optional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cookbook.entities.Recipe;
import com.revature.cookbook.entities.Review;

/**
 * The UserRepository interface provides database operations for User entities.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

    /**
     * Finds a user by username.
     *
     * @param username the username to search for
     * @return an Optional containing the User object if found, or an empty Optional
     *         otherwise
     */
    Optional<Review> findById(String id);

    List<Review> findAll();

    List<Review> findByRating(int rating);

    List<Review> findByUsername(String username);

    List<Review> findByRid(String rid);

    void deleteById(String id);

    List <Review> getReviewByRid(String id);

    //Optional<Review> findByUsername(String username);


}
