package ir.maktabquizw21.service;

import ir.maktabquizw21.CustomExeption.CustomException;
import ir.maktabquizw21.domains.*;
import ir.maktabquizw21.repository.ManagerRepository;
import ir.maktabquizw21.service.base.BaseServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ManagerServiceImpl extends
        BaseServiceImpl<Manager, Long, ManagerRepository>
        implements ManagerService {

    public ManagerServiceImpl(ManagerRepository repository,
                              FruitService fruitService,
                              CustomerService customerService,
                              OrderItemService orderItemService,
                              OrderService orderService) {
        super(repository);
        this.fruitService = fruitService;
        this.customerService = customerService;
        this.orderItemService = orderItemService;
        this.orderService = orderService;
    }

    private final FruitService fruitService;

    private final CustomerService customerService;

    private final OrderItemService orderItemService;

    private final OrderService orderService;

    public void registerManager(String name, String username, String password) {
        if (repository.findByUsername(username).isPresent()) {
            throw new CustomException("Manager already exists");
        }
        repository.beginTransaction();
        Manager manager = new Manager();
        manager.setName(name);
        manager.setUserName(username);
        manager.setPassword(password);
        repository.save(manager);
        repository.commitTransaction();
    }

    public Manager loginManager(String username, String password) {
        repository.beginTransaction();
        if (repository.findByUsername(username).isPresent()) {
            Manager manager = repository.findByUsername(username).get();
            if (manager.getPassword().equals(password)) {
                repository.commitTransaction();
                return manager;
            } else {
                throw new CustomException("Wrong password");
            }
        } else {
            throw new CustomException("No user found , you need to register first");
        }
    }

    public void addFruit(String fruitName, String description,
                         Double quantity, Double pricePerKg) {
        repository.beginTransaction();
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        fruit.setDescription(description);
        fruit.setQuantity(quantity);
        fruit.setPricePerKg(pricePerKg);
        fruitService.save(fruit);
        repository.commitTransaction();
    }

    public List<Fruit> printAllFruits() {
        repository.beginTransaction();
        fruitService.findAll();
        repository.commitTransaction();
        return fruitService.findAll();
    }

    public void updateFruit(Fruit fruit) {
        repository.beginTransaction();
        Fruit fruit1 = new Fruit();
        fruitService.save(fruit1);
        repository.commitTransaction();
    }

    public void deleteFruit(Long id) {
        repository.beginTransaction();
        if (fruitService.existsById(id)) {
            fruitService.deleteById(id);
            repository.commitTransaction();
        } else {
            throw new CustomException("Fruit not found");
        }
    }

    public void addCustomer(String name, String userName,
                            String password, String phoneNumber,
                            String address) {
        repository.beginTransaction();
        if (repository.findByUsername(userName).isPresent()) {
            throw new CustomException("Customer already exists");
        }
        Customer customer = new Customer();
        customer.setName(name);
        customer.setUserName(userName);
        customer.setPassword(password);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customerService.save(customer);
        repository.commitTransaction();
    }

    public List<Customer> printAllCustomers() {
        return customerService.findAll();
    }

    public void updateCustomer(Customer customer) {
        repository.beginTransaction();
        Customer customer1 = new Customer();
        customerService.save(customer1);
        repository.commitTransaction();
    }

    public void deleteCustomer(Long id) {
        repository.beginTransaction();
        if (customerService.existsById(id)) {
            customerService.deleteById(id);
            repository.commitTransaction();
        } else {
            throw new CustomException("Customer not found");
        }
    }

    public List<OrderItem> printAllOrderItems() {
        return orderItemService.findAll();
    }

    public List<Order> printAllOrderItemsByCustomerId(Long customerId) {
        repository.beginTransaction();
        if (customerService.existsById(customerId)) {
            List<Order> ordersByCustomerId = new ArrayList<>();
            repository.commitTransaction();
            return ordersByCustomerId.stream()
                    .filter(order -> order.getCustomer().getId()
                            .equals(customerId)).toList();
        } else {
            throw new CustomException("Customer not found");
        }
    }

    public List<Order> printAllOrders() {
        return orderService.findAll();
    }

    public void cancelOrder(Long id) {
        repository.beginTransaction();
        Order order = orderService.findById(id).
                orElseThrow(() -> new RuntimeException("Order not found"));
        if (order.getStatus() != OrderStatus.CANCELLED) {
            order.setStatus(OrderStatus.CANCELLED);
        }
        orderService.save(order);
        repository.commitTransaction();
    }

    public void sendOrder(Long id) {
        repository.beginTransaction();
        Order order = orderService.findById(id).
                orElseThrow(() -> new RuntimeException("Order not found"));
        if (order.getStatus() != OrderStatus.PROCESSED) {
            order.setStatus(OrderStatus.PROCESSED);
        }
        orderService.save(order);
        repository.commitTransaction();
    }
}
