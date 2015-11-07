package com.stentle.controller;

/**
 * Created by gioiaballin on 06/11/15.
 */
import com.stentle.domain.collections.Alumnus;
import com.stentle.domain.repositories.AlumnusRepository;
import com.stentle.domain.validators.AlumnusValidator;
import com.stentle.exception.ArgumentNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = {"/ex-1"})
public class ExerciseController {

    private static final Logger LOG = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    AlumnusRepository alumnusRepository;

    @Autowired
    AlumnusValidator alumnusValidator;

    @RequestMapping(value = {"/alumni"}, method = RequestMethod.POST)
    public void get(@RequestBody @Validated Alumnus alumnus, BindingResult bindingResult) {
        LOG.debug("POST [/alumni] - " + alumnus.toString());
        alumnusValidator.validate(alumnus, bindingResult);
        if (!bindingResult.hasErrors()) {
            alumnusRepository.save(alumnus);
        } else {
            throw new ArgumentNotValidException();
        }
    }

    @RequestMapping(value = {"/alumni"}, method = RequestMethod.GET)
    public String storeStudents(@RequestParam(value="name") String name) {
        LOG.debug("Request Param: name=" + name);
        return null;
    }
}
