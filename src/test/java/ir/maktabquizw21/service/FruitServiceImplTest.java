package ir.maktabquizw21.service;

import ir.maktabquizw21.CustomExeption.CustomException;
import ir.maktabquizw21.config.ApplicationContext;
import ir.maktabquizw21.domains.Fruit;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FruitServiceImplTest {

    @Test
    public void testFindFruitByName() {
        ApplicationContext instance = ApplicationContext.getInstance();

        FruitService fruitService = instance.getFruitService();
        Assertions.assertEquals(0, fruitService.findById(100L));

        Fruit fruit = new Fruit();
        Assertions.assertThrows(
                CustomException.class, () -> fruitService.save(fruit)
        );


        fruitService.save(fruit);

        Assertions.assertNotNull(fruit);

    }
}