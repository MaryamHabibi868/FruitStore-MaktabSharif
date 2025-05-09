package ir.maktabquizw21.service.base;

import ir.maktabquizw21.domains.base.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>,
        ID extends Serializable>{

    T save(T entity);

    List<T> saveAll(Collection<T> entities);

    Optional<T> findById(ID id);

    List<T> findAll();

    List<T> findAllById(Iterable<ID> ids);

    Long countAll();

    void deleteById(ID id);

    void deleteAllById(Iterable<ID> ids);

    boolean existsById(ID id);
}
