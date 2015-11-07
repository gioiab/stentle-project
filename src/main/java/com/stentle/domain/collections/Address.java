package com.stentle.domain.collections;

import org.springframework.data.annotation.Id;

/**
 * Created by gioiaballin on 07/11/15.
 */
public class Address {

    private String street;
    private String number;
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
