package ir.maktabquizw21.repository.base;

import ir.maktabquizw21.domains.User;

import java.util.Optional;

public interface BaseUserRepository<T extends User> extends
        CrudRepository<T , Long>{

    Optional<T> findByUsername(String username);

    Optional<T> findByUsernameAndPassword(String username, String password);

}
