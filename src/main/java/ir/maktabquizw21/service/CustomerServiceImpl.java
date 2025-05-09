package ir.maktabquizw21.service;

import ir.maktabquizw21.CustomExeption.CustomException;
import ir.maktabquizw21.domains.*;
import ir.maktabquizw21.repository.CustomerRepository;
import ir.maktabquizw21.service.base.BaseServiceImpl;

import java.time.LocalDate;

public class CustomerServiceImpl extends
        BaseServiceImpl<Customer, Long, CustomerRepository>
        implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository,
                               OrderItemService orderItemService,
                               FruitService fruitService) {
        super(repository);
        this.orderItemService = orderItemService;
        this.fruitService = fruitService;
    }

    private final OrderItemService orderItemService;
    private final FruitService fruitService;


    public void registerCustomer(String name, String username, String password,
                                 String phoneNumber, String address) {
        if (repository.findByUsername(username).isPresent()) {
            throw new CustomException("Customer already exists");
        }
        repository.beginTransaction();
        Customer customer = new Customer();
        customer.setName(name);
        customer.setUserName(username);
        customer.setPassword(password);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        repository.save(customer);
        repository.commitTransaction();
    }

    public Customer loginCustomer(String username, String password) {
        repository.beginTransaction();
        if (repository.findByUsername(username).isPresent()) {
            Customer customer = repository.findByUsername(username).get();
            if (customer.getPassword().equals(password)) {
                repository.commitTransaction();
                return customer;
            } else {
                throw new CustomException("Wrong password");
            }
        } else {
            throw new CustomException("No user found , you need to register first");
        }
    }

    public void proofOrder(String fruitName, Double weight) {
        repository.beginTransaction();
        Fruit findFruit = fruitService.findFruitByName(fruitName);
        if (findFruit.getQuantity() < weight) {
            throw new CustomException("Not enough fruit");
        }

        Order order = new Order();
        order.setStatus(OrderStatus.PROCESSED);
        order.setOrderDate(LocalDate.now());

        OrderItem orderItem = new OrderItem();
        orderItem.setFruit(findFruit);
        orderItem.setWeight(weight);

        orderItemService.save(orderItem);

        findFruit.setQuantity(findFruit.getQuantity() - weight);
        fruitService.save(findFruit);
        repository.commitTransaction();
    }
}
