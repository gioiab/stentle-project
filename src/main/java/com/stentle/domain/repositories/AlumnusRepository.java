package com.stentle.domain.repositories;

import com.stentle.domain.collections.Alumnus;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by gioiaballin on 07/11/15.
 */
public interface AlumnusRepository extends MongoRepository<Alumnus, String> {
}

