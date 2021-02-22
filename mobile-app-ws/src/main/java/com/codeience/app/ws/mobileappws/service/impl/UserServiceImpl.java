package com.codeience.app.ws.mobileappws.service.impl;

import com.codeience.app.ws.mobileappws.service.IUserService;
import com.codeience.app.ws.mobileappws.shared.Utils;
import com.codeience.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.codeience.app.ws.mobileappws.ui.model.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    Map<String,UserRest> users;

    @Autowired
    Utils utils;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnVal = new UserRest();
        returnVal.setFirstName(userDetails.getFirstName());
        returnVal.setLastName(userDetails.getLastName());
        returnVal.setEmail(userDetails.getEmail());

        String userId = utils.generateUserId();
        returnVal.setUserId(userId);

        if(users==null)
        {
            users = new HashMap<>();
            users.put(userId, returnVal);
        }

        return returnVal;
    }
}
