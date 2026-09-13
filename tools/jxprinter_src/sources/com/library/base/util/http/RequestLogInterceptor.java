package com.library.base.util.http;

import A3.AbstractC0157z;
import A4.C0169l;
import java.nio.charset.Charset;
import okhttp3.A;
import okhttp3.M;
import okhttp3.Q;
import okhttp3.T;
import okhttp3.W;
import okhttp3.z;
import org.apache.logging.log4j.util.Chars;
import p051j0.a;
import p118u4.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class RequestLogInterceptor implements A {
    private final Charset UTF8 = Charset.forName("UTF-8");
    private final String TAG = "RequestLogInterceptor";

    @Override // okhttp3.A
    public T intercept(z zVar) throws Exception {
        M m6 = ((f) zVar).d;
        T tProceed = zVar.proceed(m6);
        Q qBody = m6.body();
        W wBody = tProceed.body();
        String strString = wBody.string();
        String string = m6.b + Chars.SPACE + m6.f6539a;
        if (qBody != null && (qBody.contentType() == null || !qBody.contentType().b.equals("multipart"))) {
            C0169l c0169l = new C0169l();
            qBody.writeTo(c0169l);
            StringBuilder sbX = AbstractC0157z.x(string, "\n");
            sbX.append(c0169l.readString(this.UTF8));
            string = sbX.toString();
        }
        a.d("RequestLogInterceptor", string + Chars.SPACE + strString);
        return tProceed.b().body(W.create(wBody.contentType(), strString.getBytes())).a();
    }
}
