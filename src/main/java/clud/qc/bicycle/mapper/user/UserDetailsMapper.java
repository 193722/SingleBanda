package clud.qc.bicycle.mapper.user;

import clud.qc.bicycle.mapper.user.param.UserDetailsQueryParam;
import clud.qc.bicycle.core.groud.mapper.DynamicPageableQueryMapper;
import clud.qc.bicycle.entity.user.UserDetailsDO;

public interface UserDetailsMapper extends DynamicPageableQueryMapper<UserDetailsDO, UserDetailsQueryParam> {
}