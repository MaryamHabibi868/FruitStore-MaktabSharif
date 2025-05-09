package ir.maktabquizw21.thread;

import ir.maktabquizw21.domains.Fruit;
import ir.maktabquizw21.service.FruitService;

public class ManagerThread extends Thread {
    private final FruitService fruitService;

    public ManagerThread(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (fruitService) {
                for (Fruit fruit : fruitService.findAll()) {
                    if (fruit.getQuantity() < 5) {
                        double addedQuantity = 10.0;
                        fruit.setQuantity(fruit.getQuantity() + addedQuantity);
                        fruitService.save(fruit);
                        System.out.println("Manager increased " +
                                fruit.getName() + " by " + addedQuantity + " kg");
                    }
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
