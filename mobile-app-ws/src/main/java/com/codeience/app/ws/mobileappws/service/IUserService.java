package com.codeience.app.ws.mobileappws.service;

import com.codeience.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.codeience.app.ws.mobileappws.ui.model.response.UserRest;

public interface IUserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
