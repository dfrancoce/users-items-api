package com.dfc.users.api.controller;

import com.dfc.users.api.exception.UserByUsernameNotFound;
import com.dfc.users.api.model.User;
import com.dfc.users.api.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TestDevWebService/services/")
@Api(tags = "Users", description = "Set of endpoints for performing operations with users.")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ApiOperation("Retrieves the user and items for the username passed by parameter.")
    @CrossOrigin(origins = "http://localhost:9080")
    @GetMapping("/user/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User getByUsername(@PathVariable final String username) throws UserByUsernameNotFound {
        final User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UserByUsernameNotFound();
        } else {
            return user;
        }
    }
}
