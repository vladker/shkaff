package com.library.base.util.http;

import com.library.base.util.http.JsonResult;
import java.net.ConnectException;
import java.net.UnknownHostException;
import p042h2.e;
import retrofit2.InterfaceC1613k;
import retrofit2.InterfaceC1616n;
import retrofit2.r0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CallBack<T extends JsonResult> implements InterfaceC1616n {
    public static final String TYPE_LOGIN_NOT = "401";
    public static final int TYPE_NETWORK_ERROR = -2;
    public static final int TYPE_OPERATION_ERROR = -3;
    public static final int TYPE_SERVER_ERROR = -1;

    public abstract void fail(int i5, String str);

    @Override // retrofit2.InterfaceC1616n
    public void onFailure(InterfaceC1613k<T> interfaceC1613k, Throwable th) {
        try {
            if (!(th instanceof ConnectException) && !(th instanceof UnknownHostException)) {
                fail(-3, th.getMessage());
                return;
            }
            fail(-2, "网络错误，请检查本地网络");
        } catch (Exception unused) {
            fail(-1, "本地执行错误，请重试");
        }
    }

    @Override // retrofit2.InterfaceC1616n
    public void onResponse(InterfaceC1613k<T> interfaceC1613k, r0<T> r0Var) {
        T tBody = r0Var.body();
        try {
            if (tBody == null) {
                fail(-1, "服务器执行错误，请重试");
                return;
            }
            if (tBody.isOk()) {
                success(tBody);
            } else if (!TYPE_LOGIN_NOT.equals(tBody.code)) {
                fail(Integer.valueOf(tBody.getCode().toString()).intValue(), tBody.getMsg());
            } else {
                e.f4031a.i();
                fail(Integer.valueOf(tBody.getCode().toString()).intValue(), "您未登录账号，请前往登录");
            }
        } catch (Exception unused) {
            fail(-1, "本地执行错误，请重试");
        }
    }

    public abstract void success(T t6);
}
