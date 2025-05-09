package ir.maktabquizw21.service;

import ir.maktabquizw21.domains.Fruit;
import ir.maktabquizw21.service.base.BaseService;

public interface FruitService
        extends BaseService<Fruit, Long> {
    Fruit findFruitByName(String fruitName);
}
