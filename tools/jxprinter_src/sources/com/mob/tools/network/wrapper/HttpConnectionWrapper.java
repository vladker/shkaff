package com.mob.tools.network.wrapper;

import com.mob.tools.network.HttpConnection;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class HttpConnectionWrapper implements HttpConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cn.fly.tools.network.HttpConnection f3659a;

    private HttpConnectionWrapper(cn.fly.tools.network.HttpConnection httpConnection) {
        this.f3659a = httpConnection;
    }

    public static HttpConnectionWrapper adapt(cn.fly.tools.network.HttpConnection httpConnection) {
        if (httpConnection == null) {
            return null;
        }
        return new HttpConnectionWrapper(httpConnection);
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getErrorStream() {
        return this.f3659a.getErrorStream();
    }

    @Override // com.mob.tools.network.HttpConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.f3659a.getHeaderFields();
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getInputStream() {
        return this.f3659a.getInputStream();
    }

    @Override // com.mob.tools.network.HttpConnection
    public int getResponseCode() {
        return this.f3659a.getResponseCode();
    }
}
