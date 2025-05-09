package ir.maktabquizw21.config;

import ir.maktabquizw21.domains.Customer;
import ir.maktabquizw21.domains.Manager;
import ir.maktabquizw21.repository.CustomerRepository;
import ir.maktabquizw21.repository.CustomerRepositoryImpl;
import ir.maktabquizw21.repository.ManagerRepository;
import ir.maktabquizw21.repository.ManagerRepositoryImpl;
import ir.maktabquizw21.service.CustomerService;
import ir.maktabquizw21.service.CustomerServiceImpl;
import ir.maktabquizw21.service.ManagerService;
import ir.maktabquizw21.service.ManagerServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Objects;

public class ApplicationContext {

    private static ApplicationContext applicationContext;

    private ApplicationContext() {
    }

    public static ApplicationContext getInstance(){
        if(Objects.isNull(applicationContext)){
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        if(Objects.isNull(entityManagerFactory)){
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        }
        return entityManagerFactory;
    }

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if(Objects.isNull(entityManager)){
            entityManager = getEntityManagerFactory().createEntityManager();
        }
        return entityManager;
    }

    private ManagerRepository managerRepository;

    public ManagerRepository getManagerRepository() {
        if (Objects.isNull(managerRepository)) {
            managerRepository = new ManagerRepositoryImpl(getEntityManager());
        }
        return managerRepository;
    }

    private CustomerRepository customerRepository;

    public CustomerRepository getCustomerRepository() {
        if (Objects.isNull(customerRepository)) {
            customerRepository = new CustomerRepositoryImpl(getEntityManager());
        }
        return customerRepository;
    }

    private ManagerService managerService;

    public ManagerService getManagerService() {
        if (Objects.isNull(managerService)) {
            managerService = new ManagerServiceImpl(getManagerRepository());
        }
        return managerService;
    }

    private CustomerService customerService;

    public CustomerService getCustomerService() {
        if (Objects.isNull(customerService)) {
            customerService = new CustomerServiceImpl(getCustomerRepository());
        }
        return customerService;
    }
}
