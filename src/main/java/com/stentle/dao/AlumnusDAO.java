package com.stentle.dao;

import com.stentle.domain.collections.Alumnus;
import com.stentle.dto.AlumniPage;
import org.springframework.data.domain.Pageable;

/**
 * Created by gioiaballin on 08/11/15.
 */
public interface AlumnusDAO {

    public void save(Alumnus alumnus);

    public AlumniPage findAlumni(String name, String education, Pageable pageable);

}
