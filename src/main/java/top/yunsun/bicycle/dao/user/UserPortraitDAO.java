package top.yunsun.bicycle.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import top.yunsun.bicycle.entity.user.UserPortraitDO;

public interface UserPortraitDAO extends JpaRepository<UserPortraitDO, Long> {
}