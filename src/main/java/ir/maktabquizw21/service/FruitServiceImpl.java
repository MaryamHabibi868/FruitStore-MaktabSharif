package ir.maktabquizw21.service;

import ir.maktabquizw21.domains.Fruit;
import ir.maktabquizw21.repository.FruitRepository;
import ir.maktabquizw21.service.base.BaseServiceImpl;

public class FruitServiceImpl
        extends BaseServiceImpl<Fruit, Long, FruitRepository>
        implements FruitService{

    public FruitServiceImpl(FruitRepository repository) {
        super(repository);
    }

    @Override
    public Fruit findFruitByName(String fruitName) {
        repository.beginTransaction();
         repository.findFruitByName(fruitName);
         repository.commitTransaction();
         return repository.findFruitByName(fruitName);
    }
}
