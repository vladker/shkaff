package com.mob.tools.network;

import cn.fly.tools.utils.ReflectHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class HttpConnectionImpl implements HttpConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f3650a;

    static {
        ReflectHelper.importClassNoThrow("org.apache.http.HttpResponse", null);
        ReflectHelper.importClassNoThrow("org.apache.http.Header", null);
    }

    public HttpConnectionImpl(Object obj) {
        this.f3650a = obj;
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getErrorStream() {
        return getInputStream();
    }

    @Override // com.mob.tools.network.HttpConnection
    public Map<String, List<String>> getHeaderFields() throws IOException {
        try {
            HashMap map = new HashMap();
            Object objInvokeInstanceMethod = ReflectHelper.invokeInstanceMethod(this.f3650a, "getAllHeaders", new Object[0]);
            if (objInvokeInstanceMethod != null) {
                int iIntValue = ((Integer) ReflectHelper.getInstanceField(objInvokeInstanceMethod, "length")).intValue();
                Object[] objArr = new Object[iIntValue];
                System.arraycopy(objInvokeInstanceMethod, 0, objArr, 0, iIntValue);
                for (int i5 = 0; i5 < iIntValue; i5++) {
                    Object obj = objArr[i5];
                    String str = (String) ReflectHelper.invokeInstanceMethod(obj, "getName", new Object[0]);
                    String str2 = (String) ReflectHelper.invokeInstanceMethod(obj, "getValue", new Object[0]);
                    if (str2 == null) {
                        str2 = "";
                    }
                    map.put(str, Arrays.asList(str2.split(",")));
                }
            }
            return map;
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getInputStream() throws IOException {
        try {
            return (InputStream) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.f3650a, "getEntity", new Object[0]), "getContent", new Object[0]);
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    @Override // com.mob.tools.network.HttpConnection
    public int getResponseCode() throws IOException {
        try {
            return ((Integer) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.f3650a, "getStatusLine", new Object[0]), "getStatusCode", new Object[0])).intValue();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
