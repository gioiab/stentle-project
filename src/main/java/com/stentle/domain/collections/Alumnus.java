package com.stentle.domain.collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by gioiaballin on 07/11/15.
 */
@Document
public class Alumnus {

    @Id
    private String id;

    @NotEmpty(message="Name cannot be empty!")
    @Pattern(regexp="[A-Za-z]+", message="Name should contain only letters!")
    private String name;


    private List<Address> addresses;

    private Education education;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "Cannot convert object to json!";
        }
    }
}