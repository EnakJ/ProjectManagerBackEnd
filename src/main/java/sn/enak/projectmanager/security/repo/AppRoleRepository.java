package sn.enak.projectmanager.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.enak.projectmanager.security.entities.AppRole;

import java.util.Optional;


@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    Optional<AppRole> getAppRoleByRoleName(String roleName);
}
