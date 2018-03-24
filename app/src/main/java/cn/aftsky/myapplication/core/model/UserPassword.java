package cn.aftsky.myapplication.core.model;

import java.util.Date;

/**
 * Created by MaoHonglu on 2018/3/23.
 */

public class UserPassword {
    private final long userId;
    private final String password;
    private final Date createTime;
    private final long updateTime;

    public UserPassword(long userId, String password, Date createTime, long updateTime) {
        this.userId = userId;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }
}
