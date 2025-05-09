package ir.maktabquizw21.service;

import ir.maktabquizw21.domains.Customer;
import ir.maktabquizw21.domains.Manager;
import ir.maktabquizw21.repository.CustomerRepository;
import ir.maktabquizw21.repository.ManagerRepository;
import ir.maktabquizw21.service.base.BaseUserServiceImpl;

public class CustomerServiceImpl extends
        BaseUserServiceImpl<Customer, Long, CustomerRepository>
        implements CustomerService{

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
