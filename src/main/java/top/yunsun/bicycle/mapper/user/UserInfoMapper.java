package top.yunsun.bicycle.mapper.user;

import top.yunsun.bicycle.core.ground.mapper.DynamicPageableQueryMapper;
import top.yunsun.bicycle.entity.user.UserInfoDO;
import top.yunsun.bicycle.mapper.user.param.UserInfoQueryParam;

public interface UserInfoMapper extends DynamicPageableQueryMapper<UserInfoDO, UserInfoQueryParam> {
}