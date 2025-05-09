package ir.maktabquizw21.thread;
import ir.maktabquizw21.domains.Fruit;
import ir.maktabquizw21.service.FruitService;
import java.util.List;
import java.util.Random;

public class CustomerThread extends Thread {

    private final FruitService fruitService;

    public CustomerThread(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            synchronized (fruitService) {
                List<Fruit> fruitList = fruitService.findAll();
                if (!fruitList.isEmpty()) {
                    Fruit selectedFruit = fruitList.get(random.nextInt(fruitList.size()));
                    double requestedWeight = 1 + (4 * random.nextDouble());

                    if (selectedFruit.getQuantity() >= requestedWeight) {
                        selectedFruit.setQuantity(selectedFruit.getQuantity()
                                - requestedWeight);
                        fruitService.save(selectedFruit);
                        System.out.println("Customer bought " +
                                requestedWeight + " kg of " + selectedFruit.getName());
                    } else {
                        System.out.println("Not enough " +
                                selectedFruit.getName() + " to buy.");
                    }
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
