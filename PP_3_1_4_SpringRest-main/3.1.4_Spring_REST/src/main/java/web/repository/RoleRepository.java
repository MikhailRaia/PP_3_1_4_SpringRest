package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
