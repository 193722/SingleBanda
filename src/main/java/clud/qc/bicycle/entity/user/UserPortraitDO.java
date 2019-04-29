package clud.qc.bicycle.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import clud.qc.bicycle.core.generator.groud.entity.BaseDO;

@Entity
@Table(name = "user_portrait")
public class UserPortraitDO extends BaseDO {
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
     * 使用头像信息
     */
    @Column(name = "head_img")
    private String headImg;

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
     * 获取使用头像信息
     *
     * @return head_img - 使用头像信息
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 设置使用头像信息
     *
     * @param headImg 使用头像信息
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}