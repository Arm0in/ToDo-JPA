package ir.maktab.base.repository.impl;

import ir.maktab.base.domain.BaseEntity;
import ir.maktab.base.repository.BaseRepository;
import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID> implements BaseRepository<E, ID> {
    EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
    protected EntityManager entityManager = entityManagerFactory.createEntityManager();
}
