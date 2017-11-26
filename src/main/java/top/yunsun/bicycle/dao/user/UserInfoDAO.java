package top.yunsun.bicycle.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import top.yunsun.bicycle.entity.user.UserInfoDO;

public interface UserInfoDAO extends JpaRepository<UserInfoDO, String> {



}