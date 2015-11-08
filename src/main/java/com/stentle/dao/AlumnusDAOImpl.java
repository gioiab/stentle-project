package com.stentle.dao;

import com.google.common.base.Preconditions;
import com.stentle.domain.collections.Alumnus;
import com.stentle.dto.AlumniPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by gioiaballin on 08/11/15.
 */
@Service
public class AlumnusDAOImpl implements AlumnusDAO {

    @Autowired
    MongoOperations mongoOperations;

    /**
     * Given an {@link Alumnus}, saves it.
     *
     * @param alumnus the alumnus to be saved
     */
    public void save(Alumnus alumnus) {
        Preconditions.checkNotNull(alumnus);
        mongoOperations.save(alumnus);
    }

    /**
     * Given the name, the education and the pagination requirements, returns
     * the page of the alumni that satisfy the query criteria. If neither the name
     * or the education is given, returns all the alumni stored.
     *
     * @param name the name of the alumnus (it could be null)
     * @param education the education level (it could be null
     * @param pageable the paging requirements
     * @return an {@link AlumniPage}
     */
    public AlumniPage findAlumni(String name, String education, Pageable pageable) {
        Preconditions.checkNotNull(pageable);
        Query query = getQuery(name, education);
        long totalAlumni = mongoOperations.count(query, Alumnus.class);
        int totalPages = (int) Math.ceil((double) totalAlumni/pageable.getPageSize());
        query.with(pageable);
        List<Alumnus> alumni = mongoOperations.find(query, Alumnus.class);
        AlumniPage alumniPage = new AlumniPage();
        alumniPage.setTotalCount(totalAlumni);
        alumniPage.setTotalPages(totalPages);
        alumniPage.setPage(pageable.getPageNumber());
        alumniPage.setData(alumni);
        return alumniPage;
    }

    private Query getQuery(String name, String education) {
        Query query;
        if ((name!=null) && (education!=null)) {
             query = getFindByNameAndEducationQuery(name, education);
        } else if (name != null) {
            query = getFindByNameQuery(name);
        } else if (education != null) {
            query = getFindByEducationQuery(education);
        } else {
            query = new Query();
        }
        return query;
    }

    private Query getFindByNameAndEducationQuery(String name, String education) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        // "NoSQL" injection to investigate
        query.addCriteria(Criteria.where("education." + education).exists(true));
        return query;
    }

    private Query getFindByNameQuery(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return query;
    }

    private Query getFindByEducationQuery(String education) {
        Query query = new Query();
        // "NoSQL" injection to investigate
        query.addCriteria(Criteria.where("education." + education).exists(true));
        return query;
    }

}
