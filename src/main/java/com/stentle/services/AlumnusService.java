package com.stentle.services;

import com.google.common.base.Preconditions;
import com.stentle.domain.collections.Alumnus;
import com.stentle.domain.repositories.AlumnusRepository;
import com.stentle.dto.AlumniPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by gioiaballin on 08/11/15.
 */
@Service
public class AlumnusService {

    @Autowired
    AlumnusRepository alumnusRepository;

    public void storeNewAlumnus(Alumnus alumnus) {
        Preconditions.checkNotNull(alumnus);
        alumnusRepository.save(alumnus);
    }

    public AlumniPage findAlumniByName(String name, PageRequest pageRequest) {
        Preconditions.checkNotNull(name);
        Preconditions.checkArgument(!name.isEmpty());
        Page<Alumnus> alumni = alumnusRepository.findByName(name, pageRequest);
        AlumniPage alumniPage = new AlumniPage();
        alumniPage.setTotalCount(alumni.getTotalElements());
        alumniPage.setTotalPages(alumni.getTotalPages());
        alumniPage.setPage(pageRequest.getPageNumber());
        alumniPage.setData(alumni.getContent());
        return alumniPage;
    }
}
