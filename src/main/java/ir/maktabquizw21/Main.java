package ir.maktabquizw21;

import ir.maktabquizw21.config.ApplicationContext;
import ir.maktabquizw21.service.FruitService;
import ir.maktabquizw21.thread.CustomerThread;
import ir.maktabquizw21.thread.ManagerThread;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();


        FruitService fruitService = ApplicationContext.getInstance().getFruitService();

        ManagerThread manager = new ManagerThread(fruitService);
        CustomerThread customer1 = new CustomerThread(fruitService);
        CustomerThread customer2 = new CustomerThread(fruitService);

        manager.start();
        customer1.start();
        customer2.start();
        manager.join();
        customer1.join();
        customer2.join();

    }
}