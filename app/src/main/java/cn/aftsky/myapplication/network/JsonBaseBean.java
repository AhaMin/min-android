package cn.aftsky.myapplication.network;

import java.util.List;

/**
 * Created by MaoHonglu on 2018/3/23.
 */

public class JsonBaseBean<T> {
    private int status;
    private String errmsg;
    private List<T> data;

    public int getStatus() {
        return status;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;

    }
}
