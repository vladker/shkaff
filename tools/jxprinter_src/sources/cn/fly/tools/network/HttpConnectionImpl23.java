package cn.fly.tools.network;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpConnectionImpl23 implements HttpConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HttpURLConnection f1806a;

    public HttpConnectionImpl23(HttpURLConnection httpURLConnection) {
        this.f1806a = httpURLConnection;
    }

    @Override // cn.fly.tools.network.HttpConnection
    public InputStream getErrorStream() {
        return this.f1806a.getErrorStream();
    }

    @Override // cn.fly.tools.network.HttpConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.f1806a.getHeaderFields();
    }

    @Override // cn.fly.tools.network.HttpConnection
    public InputStream getInputStream() {
        return this.f1806a.getInputStream();
    }

    @Override // cn.fly.tools.network.HttpConnection
    public int getResponseCode() {
        return this.f1806a.getResponseCode();
    }
}
