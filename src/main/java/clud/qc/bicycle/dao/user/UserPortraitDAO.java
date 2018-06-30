package clud.qc.bicycle.dao.user;

import clud.qc.bicycle.entity.user.UserPortraitDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPortraitDAO extends JpaRepository<UserPortraitDO, Long> {
}