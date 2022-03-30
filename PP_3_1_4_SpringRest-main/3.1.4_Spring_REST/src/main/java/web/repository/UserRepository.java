package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import web.model.*;

//@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    User findByEmail(String email);
    void deleteById(Long id);

}

