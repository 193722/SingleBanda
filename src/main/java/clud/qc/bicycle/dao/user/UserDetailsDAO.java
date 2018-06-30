package clud.qc.bicycle.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import clud.qc.bicycle.entity.user.UserDetailsDO;

public interface UserDetailsDAO extends JpaRepository<UserDetailsDO, Long> {
}