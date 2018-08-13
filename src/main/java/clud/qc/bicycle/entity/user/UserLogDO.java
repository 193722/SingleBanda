package clud.qc.bicycle.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import clud.qc.bicycle.core.groud.entity.BaseDO;

@Entity
@Table(name = "user_log")
public class UserLogDO extends BaseDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    /**
     * 用户登录IP地址
     */
    @Column(name = "ip")
    private String ip;

    /**
     * 解析IP地址
     */
    @Column(name = "ip_address")
    private String ipAddress;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户登录IP地址
     *
     * @return ip - 用户登录IP地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置用户登录IP地址
     *
     * @param ip 用户登录IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取解析IP地址
     *
     * @return ip_address - 解析IP地址
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 设置解析IP地址
     *
     * @param ipAddress 解析IP地址
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}