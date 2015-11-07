package com.stentle.domain.validators;

import com.stentle.domain.collections.Address;
import com.stentle.domain.collections.Alumnus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.List;

/**
 * Created by gioiaballin on 07/11/15.
 */
@Component
public class AlumnusValidator implements Validator {

    @Autowired
    LocalValidatorFactoryBean localValidatorFactoryBean;

    @Override
    public boolean supports(Class<?> clazz) {
        return Alumnus.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Alumnus alumnus = (Alumnus) target;

        List<Address> addresses = alumnus.getAddresses();
        for(Address address: addresses) {
            localValidatorFactoryBean.validate(address, errors);
        }
    }

}
