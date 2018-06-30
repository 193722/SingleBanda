package clud.qc.bicycle.mapper.user;

import clud.qc.bicycle.core.ground.mapper.DynamicPageableQueryMapper;
import clud.qc.bicycle.entity.user.UserInfoDO;
import clud.qc.bicycle.mapper.user.param.UserInfoQueryParam;

public interface UserInfoMapper extends DynamicPageableQueryMapper<UserInfoDO, UserInfoQueryParam> {
}