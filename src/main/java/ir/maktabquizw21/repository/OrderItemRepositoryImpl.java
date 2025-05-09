package ir.maktabquizw21.repository;

import ir.maktabquizw21.domains.OrderItem;
import ir.maktabquizw21.repository.base.SimpleJpaRepository;
import jakarta.persistence.EntityManager;

public class OrderItemRepositoryImpl
        extends SimpleJpaRepository<OrderItem, Long>
        implements OrderItemRepository{


    public OrderItemRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<OrderItem> getDomainClass() {
        return OrderItem.class;
    }
}
