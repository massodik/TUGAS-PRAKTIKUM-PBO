package id.ac.uinsgd.springbootresetpassword.repository;

import id.ac.uinsgd.springbootresetpassword.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}