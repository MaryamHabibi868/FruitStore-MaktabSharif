package ir.maktabquizw21.service;

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

    }
}
