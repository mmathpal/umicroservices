package com.codeience.app.ws.mobileappws.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRest {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
