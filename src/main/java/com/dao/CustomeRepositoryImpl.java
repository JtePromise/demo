package com.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by ganluting on 17/1/10.
 */
@NoRepositoryBean
public class CustomeRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomReposittory<T,ID> {

    private final EntityManager entityManager;

    public CustomeRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;

    }

    @Override
    public Page findByAuto(Object example, Pageable pageable) {
        return findAll((Specification<T>) CustomerSpecs.byAuto(entityManager,example),pageable);
    }


}
