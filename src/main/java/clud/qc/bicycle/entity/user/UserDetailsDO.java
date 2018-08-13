package clud.qc.bicycle.entity.user;

import clud.qc.bicycle.core.groud.entity.BaseDO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetailsDO extends BaseDO {
    /**
     * 主键，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 绑定手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 绑定邮件
     */
    @Column(name = "email")
    private String email;

    /**
     * 出生日期
     */
    @Column(name = "birth_date")
    private Date birthDate;

    /**
     * 国籍
     */
    @Column(name = "nationality")
    private String nationality;

    /**
     * 省份
     */
    @Column(name = "province")
    private String province;

    /**
     * 城市
     */
    @Column(name = "city")
    private String city;

    /**
     * 详细地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 性别：{M:男 F:女 N:未知}
     */
    @Column(name = "sex")
    private Boolean sex;

    /**
     * 显示头像
     */
    @Column(name = "head_img")
    private String headImg;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 修改时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 获取主键，自增
     *
     * @return id - 主键，自增
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键，自增
     *
     * @param id 主键，自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取绑定手机号
     *
     * @return phone - 绑定手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置绑定手机号
     *
     * @param phone 绑定手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取绑定邮件
     *
     * @return email - 绑定邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置绑定邮件
     *
     * @param email 绑定邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取出生日期
     *
     * @return birth_date - 出生日期
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 设置出生日期
     *
     * @param birthDate 出生日期
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取国籍
     *
     * @return nationality - 国籍
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 设置国籍
     *
     * @param nationality 国籍
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取详细地址
     *
     * @return address - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取性别：{M:男 F:女 N:未知}
     *
     * @return sex - 性别：{M:男 F:女 N:未知}
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * 设置性别：{M:男 F:女 N:未知}
     *
     * @param sex 性别：{M:男 F:女 N:未知}
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 获取显示头像
     *
     * @return head_img - 显示头像
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 设置显示头像
     *
     * @param headImg 显示头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    /**
     * 获取创建时间
     *
     * @return raw_add_time - 创建时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置创建时间
     *
     * @param rawAddTime 创建时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取修改时间
     *
     * @return raw_update_time - 修改时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置修改时间
     *
     * @param rawUpdateTime 修改时间
     */
    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }
}