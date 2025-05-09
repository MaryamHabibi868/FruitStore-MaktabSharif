package ir.maktabquizw21.repository;

import ir.maktabquizw21.domains.Manager;
import ir.maktabquizw21.repository.base.BaseUserRepositoryImpl;
import jakarta.persistence.EntityManager;

public class ManagerRepositoryImpl
        extends BaseUserRepositoryImpl<Manager>
        implements ManagerRepository {

    public ManagerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Manager> getDomainClass() {
        return Manager.class;
    }
}
