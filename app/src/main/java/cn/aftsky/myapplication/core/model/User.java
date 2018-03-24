package cn.aftsky.myapplication.core.model;

import java.util.Date;

/**
 * Created by MaoHonglu on 2018/3/23.
 */

public class User {

    private final long id;
    private final String account;
    private final String data;
    private final Date createTime;

    public User(long id, String account, String data, Date createTime) {
        this.id = id;
        this.account = account;
        this.data = data;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getData() {
        return data;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
