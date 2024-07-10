package com.ec.neoris.procedures.repositories;

import com.ec.neoris.entities.common.QBaseAuditable;
import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.Query;

public interface IQueryDslBaseRepository<T> {

    void save(T entity);

    void update(T entity);

    @Query("SELECT nextval('1?')")
    Integer getSequence(String sequenceName);

}
