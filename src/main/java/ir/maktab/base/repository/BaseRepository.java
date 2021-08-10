package ir.maktab.base.repository;

import ir.maktab.base.domain.BaseEntity;

import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {
    E update(E e);

    E save(E e);

    E findById(ID id);

    List<E> findAll();

    void deleteById(ID id);
}
