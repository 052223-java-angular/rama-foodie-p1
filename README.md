# P1 - Java Angular Full Stack Project

## Introduction

This is a Full Stack web application. The application will be primarily built using Java, HTML, CSS and angular. The project will utilize a PostgreSQL database to store user's profiles and their recipes and will allow user to share recipes and rate them.
## User Stories

- **As a user**, I want to register an account with the app.
- **As a user**, I want to log in to my account so that I can access my recipe and its ratings.
- **As a user**, I want to edit my user profile.
- **As a user**, I want to browse through all the available recipes, no logging required
- **As a user**, I want to search for recipes by name, nutrition, cusine or calories range.
- **As a user**, I want to add and remove recipes to my list , logged users only
- **As a user**, I want to view other users recipes and rate their recipes with comments ( logged users only).


## MVP (Minimum Viable Product)

- User registration and login.
- Browsing and searching for recipes.
- Adding and deleting recipes to my list.
- Viewing and rating user's recipe.


## Stretch Goals

- Adding an admin role that can add, remove users or moderate their comments
- Edit User Profile.
- Implement an internal messaging system to communicate with other users.
- Implementing  3 party authorization.

## Tech Stacks

- **Java**: The main programming language used for building the application.
- **PostgreSQL**: Used as the database to store user info, recipe details
- **Maven or Gradle**: Used for managing project dependencies.
- **JUnit**: A testing framework for Java applications, used to ensure our code works as expected.
- **Log4j**: A logging utility for debugging purposes.
- **JDBC (Java Database Connectivity)**: An API for connecting and executing queries on the database.
- **BCrypt**: A Java library for hashing and checking passwords for security.
- **JUnit, Mockito, and PowerMock**: Used for unit and integration testing.
- **Git and GitHub**: Used for version control.

## Requirements

- **Clean Codebase**: All code should be clean and well-documented. The repository should not include any unnecessary files or folders such as the `target/`, `.DS_Store`, etc. All files and directories should be appropriately named and organized.

- **Database Design**: The database should be designed following the principles of the 3rd Normal Form (3NF) to ensure data integrity and efficiency. An Entity Relationship Diagram (ERD) should be included in the documentation.

- **Secure**: All sensitive user data such as passwords must be securely hashed before storing it in the database. The application should not display any sensitive information in error messages.

- **Error Handling**: The application should handle potential errors gracefully and provide clear and helpful error messages to the users.

- **Testing**: The application should have a high test coverage. Unit tests and integration tests should be implemented using JUnit, Mockito, and PowerMock.

- **Version Control**: The application should be developed using a version control system, preferably Git, with regular commits denoting progress.

- **Documentation**: The repository should include a README file with clear instructions on how to run the application. Code should be well-commented to allow for easy understanding and maintenance.

- **Scalable**: The design of the application should be scalable, allowing for easy addition of new features or modifications in the future.

