package com.stentle.controller;

/**
 * Created by gioiaballin on 06/11/15.
 */
import com.stentle.domain.collections.Alumnus;
import com.stentle.domain.repositories.AlumnusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/ex-1"})
public class ExerciseController {

    private static final Logger LOG = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    AlumnusRepository alumnusRepository;

    @RequestMapping(value = {"/alumni"}, method = RequestMethod.POST)
    public void get(@RequestBody Alumnus alumnus) {
        LOG.debug("GET [/alumni] - " + alumnus.toString());
        alumnusRepository.save(alumnus);
    }

    @RequestMapping(value = {"/alumni"}, method = RequestMethod.GET)
    public String storeStudents(@RequestParam(value="name") String name) {
        LOG.debug("Request Param: name=" + name);
        return null;
    }
}
