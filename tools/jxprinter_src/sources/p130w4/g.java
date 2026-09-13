package p130w4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends i {
    public final Method c;
    public final Method d;
    public final Method e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class f8833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f8834g;

    public g(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.c = method;
        this.d = method2;
        this.e = method3;
        this.f8833f = cls;
        this.f8834g = cls2;
    }

    @Override // p130w4.i
    public final void a(SSLSocket sSLSocket) {
        try {
            this.e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError("failed to remove ALPN", e);
        }
    }

    @Override // p130w4.i
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        try {
            this.c.invoke(null, sSLSocket, Proxy.newProxyInstance(i.class.getClassLoader(), new Class[]{this.f8833f, this.f8834g}, new f(i.b(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError("failed to set ALPN", e);
        }
    }

    @Override // p130w4.i
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            f fVar = (f) Proxy.getInvocationHandler(this.d.invoke(null, sSLSocket));
            boolean z6 = fVar.b;
            if (!z6 && fVar.c == null) {
                i.f8835a.log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z6) {
                return null;
            }
            return fVar.c;
        } catch (IllegalAccessException e) {
            e = e;
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e6) {
            e = e6;
            throw new AssertionError("failed to get ALPN selected protocol", e);
        }
    }
}
