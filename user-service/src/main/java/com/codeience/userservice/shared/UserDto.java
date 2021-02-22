package com.codeience.userservice.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = 659570832557428566L;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String userId;

    private String encryptedPassword;
}
