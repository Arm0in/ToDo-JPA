package ir.maktab.base.service;

import com.sun.xml.bind.v2.model.core.ID;
import ir.maktab.base.domain.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID> {
    E update(E e);

    E save(E e);

    E findById(ID id);

    List<E> findAll();

    void deleteById(ID id);
}
