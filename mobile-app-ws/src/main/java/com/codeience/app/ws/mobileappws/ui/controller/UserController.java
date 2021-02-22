package com.codeience.app.ws.mobileappws.ui.controller;

import com.codeience.app.ws.mobileappws.exceptions.UserServiceException;
import com.codeience.app.ws.mobileappws.service.IUserService;
import com.codeience.app.ws.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.codeience.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.codeience.app.ws.mobileappws.ui.model.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    Map<String,UserRest> users;

    @GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value = "limit"
            , defaultValue = "50") int limit
            ,@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort)
    {
        return "get users called with page =" + page + " and limit:" +limit ;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId)
    {
        if(true) throw new UserServiceException("User service exception is thrown");

        if(users.containsKey(userId))
        {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest returnVal = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnVal, HttpStatus.OK);
    }

    @PutMapping(path="/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails)
    {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId,storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId)
    {
        if(users.containsKey(userId))
        {
            users.remove(userId);
            return ResponseEntity.noContent().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
