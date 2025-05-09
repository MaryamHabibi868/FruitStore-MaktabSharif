package ir.maktabquizw21.service;

import ir.maktabquizw21.CustomExeption.CustomException;
import ir.maktabquizw21.domains.Manager;
import ir.maktabquizw21.repository.ManagerRepository;
import ir.maktabquizw21.service.base.BaseUserServiceImpl;

public class ManagerServiceImpl extends
        BaseUserServiceImpl<Manager, Long, ManagerRepository>
        implements ManagerService {

    public ManagerServiceImpl(ManagerRepository repository) {
        super(repository);
    }

    public void registerManager(String name, String username, String password) {
        if ( repository.findByUsername(username).isPresent()){
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
        if ( repository.findByUsername(username).isPresent()){
            Manager manager = repository.findByUsername(username).get();
            if (manager.getPassword().equals(password)) {
                return manager;
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
