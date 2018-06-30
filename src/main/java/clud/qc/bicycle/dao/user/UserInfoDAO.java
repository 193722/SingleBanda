package clud.qc.bicycle.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import clud.qc.bicycle.entity.user.UserInfoDO;

public interface UserInfoDAO extends JpaRepository<UserInfoDO, String> {



}