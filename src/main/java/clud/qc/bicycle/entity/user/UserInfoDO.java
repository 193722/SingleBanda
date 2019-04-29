package clud.qc.bicycle.entity.user;

import clud.qc.bicycle.core.generator.groud.entity.BaseDO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfoDO extends BaseDO {
    /**
     * 用户编号，主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    /**
     * 用户昵称
     */
    @Column(name = "name")
    private String name;

    /**
     * 用户登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 用户登录密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 用户状态：{NORAML：正常，DISABLE：冻结，DELETE：删除}
     */
    @Column(name = "status")
    private Boolean status;

    /**
     * 登录状态：{OFF：离线，ON：在线}
     */
    @Column(name = "login_status")
    private Boolean loginStatus;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

    /**
     * 获取用户编号，主键
     *
     * @return id - 用户编号，主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户编号，主键
     *
     * @param id 用户编号，主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户昵称
     *
     * @return name - 用户昵称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户昵称
     *
     * @param name 用户昵称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户登录名
     *
     * @return login_name - 用户登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置用户登录名
     *
     * @param loginName 用户登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取用户登录密码
     *
     * @return login_password - 用户登录密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置用户登录密码
     *
     * @param loginPassword 用户登录密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * 获取用户状态：{NORAML：正常，DISABLE：冻结，DELETE：删除}
     *
     * @return status - 用户状态：{NORAML：正常，DISABLE：冻结，DELETE：删除}
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置用户状态：{NORAML：正常，DISABLE：冻结，DELETE：删除}
     *
     * @param status 用户状态：{NORAML：正常，DISABLE：冻结，DELETE：删除}
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取登录状态：{OFF：离线，ON：在线}
     *
     * @return login_status - 登录状态：{OFF：离线，ON：在线}
     */
    public Boolean getLoginStatus() {
        return loginStatus;
    }

    /**
     * 设置登录状态：{OFF：离线，ON：在线}
     *
     * @param loginStatus 登录状态：{OFF：离线，ON：在线}
     */
    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    /**
     * 获取注册时间
     *
     * @return register_time - 注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     *
     * @param registerTime 注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}