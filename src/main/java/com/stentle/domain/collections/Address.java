package com.stentle.domain.collections;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Created by gioiaballin on 07/11/15.
 */
public class Address {

    @NotEmpty(message = "The street is mandatory!")
    private String street;

    @NotEmpty(message = "The street number is mandatory!")
    @Pattern(regexp="[0-9]+", message="Street number should contain only numbers!")
    private String number;

    @NotEmpty(message = "The country is mandatory!")
    private String country;

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

}
