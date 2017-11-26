package top.yunsun.bicycle.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import top.yunsun.bicycle.entity.user.UserDetailsDO;

public interface UserDetailsDAO extends JpaRepository<UserDetailsDO, Long> {
}