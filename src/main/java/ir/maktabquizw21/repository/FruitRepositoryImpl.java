package ir.maktabquizw21.repository;

import ir.maktabquizw21.CustomExeption.CustomException;
import ir.maktabquizw21.domains.Fruit;
import ir.maktabquizw21.repository.base.SimpleJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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

    @Override
    public Fruit findFruitByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Fruit> query = cb.createQuery(getDomainClass());
        Root<Fruit> from = query.from(getDomainClass());
        query.select(from)
                .where(cb.equal(from.get("name"), name));

        if (entityManager.createQuery(query).getSingleResult() == null) {
            throw new CustomException("Fruit with name " + name + " not found");
        }
        return entityManager.createQuery(query).getSingleResult();
    }
}
