package ir.maktabquizw21.service;

import ir.maktabquizw21.CustomExeption.CustomException;
import ir.maktabquizw21.domains.Customer;
import ir.maktabquizw21.repository.CustomerRepository;
import ir.maktabquizw21.service.base.BaseUserServiceImpl;

public class CustomerServiceImpl extends
        BaseUserServiceImpl<Customer, Long, CustomerRepository>
        implements CustomerService{

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    public void registerCustomer(String name, String username, String password,
                                 String phoneNumber, String address) {
        if ( repository.findByUsername(username).isPresent()){
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
        if ( repository.findByUsername(username).isPresent()){
            Customer customer = repository.findByUsername(username).get();
            if (customer.getPassword().equals(password)) {
                return customer;
            }
            else {
                throw new CustomException("Wrong password");
            }
        }
        else {
            throw new CustomException("No user found , you need to register first");
        }
}
}
