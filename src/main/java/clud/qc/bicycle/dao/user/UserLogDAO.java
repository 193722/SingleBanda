package clud.qc.bicycle.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import clud.qc.bicycle.entity.user.UserLogDO;

public interface UserLogDAO extends JpaRepository<UserLogDO, Long> {
}