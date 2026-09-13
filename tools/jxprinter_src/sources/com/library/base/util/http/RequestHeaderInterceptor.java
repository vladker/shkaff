package com.library.base.util.http;

import android.text.TextUtils;
import com.orhanobut.hawk.Hawk;
import java.util.HashMap;
import java.util.Map;
import okhttp3.A;
import okhttp3.L;
import okhttp3.M;
import okhttp3.T;
import okhttp3.z;
import p051j0.a;
import p118u4.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class RequestHeaderInterceptor implements A {
    private final String TAG = "RequestHeaderInterceptor";

    @Override // okhttp3.A
    public T intercept(z zVar) {
        M m6 = ((f) zVar).d;
        L lB = m6.b();
        StringBuffer stringBuffer = new StringBuffer(m6.f6539a.f6682g);
        Map map = (Map) Hawk.get("base_header_map", new HashMap());
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("（");
                stringBuffer.append(str);
                stringBuffer.append("：");
                stringBuffer.append(str2);
                stringBuffer.append("）");
                lB.b.a(str, str2);
            }
        }
        a.d("RequestHeaderInterceptor", stringBuffer.toString());
        return zVar.proceed(lB.a());
    }
}
