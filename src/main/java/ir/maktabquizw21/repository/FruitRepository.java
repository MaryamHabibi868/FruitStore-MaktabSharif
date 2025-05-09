package ir.maktabquizw21.repository;


import ir.maktabquizw21.domains.Fruit;
import ir.maktabquizw21.repository.base.CrudRepository;

public interface FruitRepository
        extends CrudRepository<Fruit, Long> {

    Fruit findFruitByName(String name);
}
