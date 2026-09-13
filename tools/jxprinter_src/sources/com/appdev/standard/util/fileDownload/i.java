package com.appdev.standard.util.fileDownload;

import java.net.MalformedURLException;
import java.net.URL;
import okhttp3.A;
import okhttp3.C1378y;
import okhttp3.S;
import okhttp3.T;
import okhttp3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S4.h f2846a;

    @Override // okhttp3.A
    public T intercept(z zVar) {
        T tProceed = zVar.proceed(((p118u4.f) zVar).d);
        S sB = tProceed.b();
        C1378y c1378y = ((p118u4.f) zVar).d.f6539a;
        c1378y.getClass();
        try {
            return sB.body(new k(new URL(c1378y.f6682g).toString(), tProceed.body(), this.f2846a)).a();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
