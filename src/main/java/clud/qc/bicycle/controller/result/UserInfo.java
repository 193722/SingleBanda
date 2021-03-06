package clud.qc.bicycle.controller.result;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {

    private String name;
    private String sex;
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
