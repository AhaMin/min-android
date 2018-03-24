package cn.aftsky.myapplication.network.api;

import cn.aftsky.myapplication.core.model.User;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by MaoHonglu on 2018/3/24.
 */

public interface AccountService {
    /**
     * 用户详情数据
     */
    @GET("api/member/getCardByid")
    Observable<User> getUserInfoById(@Query("id") int id);
}
