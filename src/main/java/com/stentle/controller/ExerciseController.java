package com.stentle.controller;

/**
 * Created by gioiaballin on 06/11/15.
 */
import com.stentle.domain.collections.Alumnus;
import com.stentle.domain.validators.AlumnusValidator;
import com.stentle.dto.AlumniPage;
import com.stentle.exception.ArgumentNotValidException;
import com.stentle.exception.NoContentException;
import com.stentle.services.AlumnusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = {"/ex-1"})
public class ExerciseController {

    private static final Logger LOG = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    AlumnusService alumnusService;

    @Autowired
    AlumnusValidator alumnusValidator;

    @RequestMapping(value = {"/alumni"}, method = RequestMethod.POST)
    public void post(@RequestBody @Validated Alumnus alumnus, BindingResult bindingResult) {
        LOG.debug("POST [/alumni] - " + alumnus.toString());
        alumnusValidator.validate(alumnus, bindingResult);
        if (!bindingResult.hasErrors()) {
            alumnusService.storeNewAlumnus(alumnus);
        } else {
            throw new ArgumentNotValidException();
        }
    }

    @RequestMapping(value = {"/alumni"}, method = RequestMethod.GET)
    public @ResponseBody AlumniPage get(@RequestParam(value="page", defaultValue="0") int page,
                      @RequestParam(value="pageSize", defaultValue="10") int pageSize,
                      @RequestParam(value="name", required = false) String name,
                      @RequestParam(value="education", required = false) String education) {
        LOG.debug("GET [/alumni] - page: " + page + " - pageSize: " + pageSize);
        LOG.debug("GET [/alumni] - name: " + name + " - education: " + education);
        PageRequest pageRequest = new PageRequest(page, pageSize);
        AlumniPage alumniPage = alumnusService.findAlumniByName(name, pageRequest);
        if (alumniPage.getTotalCount() > 0) {
            return alumniPage;
        } else {
            throw new NoContentException("No alumnus found.");
        }
    }
}
