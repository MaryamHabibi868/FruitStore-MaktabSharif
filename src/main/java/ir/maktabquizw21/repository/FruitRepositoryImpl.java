package ir.maktabquizw21.repository;

import ir.maktabquizw21.domains.Fruit;
import ir.maktabquizw21.repository.base.SimpleJpaRepository;
import jakarta.persistence.EntityManager;

public class FruitRepositoryImpl
        extends SimpleJpaRepository<Fruit, Long>
        implements FruitRepository{

    public FruitRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Fruit> getDomainClass() {
        return Fruit.class;
    }
}
