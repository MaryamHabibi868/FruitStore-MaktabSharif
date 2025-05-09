package ir.maktabquizw21.repository;

import ir.maktabquizw21.domains.Order;
import ir.maktabquizw21.repository.base.SimpleJpaRepository;
import jakarta.persistence.EntityManager;

public class OrderRepositoryImpl
        extends SimpleJpaRepository<Order, Long>
        implements OrderRepository{


    public OrderRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Order> getDomainClass() {
        return Order.class;
    }
}
