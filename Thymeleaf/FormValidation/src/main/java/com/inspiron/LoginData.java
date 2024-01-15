package com.inspiron;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginData {

    @NotBlank(message="Username can't be empty")
    @Size(min=3,max=12,message="Username must be between 3 to 12 characters")
    private String userName;


    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message="Invalid Email")
    private String email;


    @AssertTrue(message="You must agree to t&c to continue login")
    private boolean agreed;

}
