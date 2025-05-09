package ir.maktabquizw21.repository;

import ir.maktabquizw21.domains.Customer;
import ir.maktabquizw21.repository.base.BaseUserRepositoryImpl;
import jakarta.persistence.EntityManager;

public class CustomerRepositoryImpl
        extends BaseUserRepositoryImpl<Customer>
        implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Customer> getDomainClass() {
        return Customer.class;
    }
}
