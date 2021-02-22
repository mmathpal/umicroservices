package com.codeience.app.ws.mobileappws.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDetailsRequestModel {

    @NotNull(message = "First name can not be null")
    @Size(min = 2, message = "First name can not be less than two characters")
    private String firstName;

    @NotNull(message = "Last name can not be null")
    @Size(min = 2, message = "Last name can not be less than two characters")
    private String lastName;
}
