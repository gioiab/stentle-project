package com.stentle.controller;

/**
 * Created by gioiaballin on 06/11/15.
 */
import com.stentle.domain.collections.Alumnus;
import com.stentle.domain.validators.AlumnusValidator;
import com.stentle.dto.AlumniPage;
import com.stentle.exception.ArgumentNotValidException;
import com.stentle.exception.NoContentException;
import com.stentle.dao.AlumnusDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The controller implementing the APIs.
 *
 * @author Gioia Ballin
 */
@RestController
@RequestMapping(value = {"/ex-1"})
public class ExerciseController {

    private static final Logger LOG = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    AlumnusDAO alumnusDAO;

    @Autowired
    AlumnusValidator alumnusValidator;

    /**
     * Given a POST request for an {@link Alumnus}-like JSON, saves the JSON into a collection
     * named alumni. A custom validation is used to ensure that all the address field are
     * given and the street number is made by numbers only. If an input alumnus is not valid,
     * returns a 400 BAD REQUEST exception.
     *
     * @param alumnus the json representing an alumnus
     * @param bindingResult the result of the validation
     */
    @RequestMapping(value = {"/alumni"}, method = RequestMethod.POST)
    public void post(@RequestBody @Validated Alumnus alumnus, BindingResult bindingResult) {
        LOG.debug("POST [/alumni] - " + alumnus.toString());
        alumnusValidator.validate(alumnus, bindingResult);
        if (!bindingResult.hasErrors()) {
            alumnusDAO.save(alumnus);
        } else {
            throw new ArgumentNotValidException();
        }
    }

    /**
     * Given a GET request for a {@link Alumnus}-like JSON, retrieves the documents which satisfy
     * the input query parameters. Results are paged. If no result is retrieves, returns
     * 204 NO CONTENT.
     *
     * @param name the alumnus' name
     * @param education the alumnus' education level
     * @param page the requested page and size
     *
     */
    @RequestMapping(value = {"/alumni"}, method = RequestMethod.GET)
    public AlumniPage get(@RequestParam(value="name", required = false) String name,
                                        @RequestParam(value="education", required = false) String education,
                                        Pageable page) {
        LOG.debug("GET [/alumni] - page: " + page.getPageNumber() + " - pageSize: " + page.getPageSize());
        LOG.debug("GET [/alumni] - name: " + name + " - education: " + education);
        AlumniPage alumniPage = alumnusDAO.findAlumni(name, education, page);
        if (alumniPage.getTotalCount() > 0) {
            return alumniPage;
        } else {
            throw new NoContentException("No alumnus found.");
        }
    }
}
