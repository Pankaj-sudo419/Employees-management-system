package com.brickred.employeeapp.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Address {
    @NotNull
    private String city;

    @NotNull
    private  String state;

    @NotNull
    /*@Pattern(regexp="^\\d{6}$", message="Invalid mobile number")*/
    /*@Min(value = 6, message = "Minimum value must be 6")
    @Max(value = 6, message = "Maximum value must be 6")*/

   /* @Digits(integer = 6, message = "Pin code must have exactly 6 digits", fraction = 0)*/
    @Min(value = 100000, message = "Pin code must bbe 6 digits")
    @Max(value = 999999, message = "Maximum value must be 6")

    private int pinCode;

    @NotNull
    private String country;

}
