package top.yunsun.bicycle.mapper.user;

import top.yunsun.bicycle.core.ground.mapper.DynamicPageableQueryMapper;
import top.yunsun.bicycle.entity.user.UserDetailsDO;
import top.yunsun.bicycle.mapper.user.param.UserDetailsQueryParam;

public interface UserDetailsMapper extends DynamicPageableQueryMapper<UserDetailsDO, UserDetailsQueryParam> {
}