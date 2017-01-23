package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sdo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
