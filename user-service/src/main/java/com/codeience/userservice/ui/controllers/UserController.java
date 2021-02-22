package com.codeience.userservice.ui.controllers;

import com.codeience.userservice.ui.model.CreateUserRequestModel;
import com.codeience.userservice.ui.model.CreateUserResponseModel;
import com.codeience.userservice.service.IUserService;
import com.codeience.userservice.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment environment;

    @GetMapping("/status/check")
    public String status()
    {
        return "Working on port " + environment.getProperty("local.server.port");
    }

    @Autowired
    private IUserService userService;


    @GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value = "limit"
            , defaultValue = "50") int limit
            , @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort)
    {
        return "get users called with page =" + page + " and limit:" +limit ;
    }
/*
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

    */


    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails)
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto createdUser = userService.createUser(userDto);
        CreateUserResponseModel returnValue = modelMapper.map(createdUser,CreateUserResponseModel.class);
        return new ResponseEntity(returnValue, HttpStatus.CREATED);
    }

    /*
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
    */
}

