package com.appdev.standard.api;

import A5.c;
import A5.e;
import A5.o;
import com.library.base.util.http.JsonResult;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface TestApi {
    @e
    @o("api/user/login/doLogin")
    InterfaceC1613k<JsonResult> doLogin(@c("phone") String str, @c("password") String str2);
}
