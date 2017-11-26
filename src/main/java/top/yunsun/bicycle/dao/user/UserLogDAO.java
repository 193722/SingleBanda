package top.yunsun.bicycle.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import top.yunsun.bicycle.entity.user.UserLogDO;

public interface UserLogDAO extends JpaRepository<UserLogDO, Long> {
}