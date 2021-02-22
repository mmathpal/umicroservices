package com.codeience.app.ws.mobileappws.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsRequestModel {
    @NotNull(message = "First name can not be null")
    @Size(min = 2, message = "First name can not be less than two characters")
    private String firstName;

    @NotNull(message = "Last name can not be null")
    @Size(min = 2, message = "Last name can not be less than two characters")
    private String lastName;

    @NotNull(message = "Email can not be null")
    @Email
    private String email;

    @NotNull(message = "Password can not be null")
    @Size(min = 8, max = 16, message = "Password must be greater than 8 characters and less than 16 characters")
    private String password;
}
