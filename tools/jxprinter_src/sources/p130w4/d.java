package p130w4;

import W1.a;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.I;
import p142y4.b;
import p142y4.c;
import p142y4.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class d extends i {
    public final Class c;
    public final Class d;
    public final Method e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Method f8828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Method f8829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Method f8830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f8831i;

    public d(Class cls, Class cls2, Method method, Method method2, Method method3, Method method4) throws NoSuchMethodException {
        Method method5;
        Method method6;
        Method method7 = null;
        try {
            Class<?> cls3 = Class.forName("dalvik.system.CloseGuard");
            Method method8 = cls3.getMethod("get", null);
            method6 = cls3.getMethod("open", String.class);
            method5 = cls3.getMethod("warnIfOpen", null);
            method7 = method8;
        } catch (Exception unused) {
            method5 = null;
            method6 = null;
        }
        this.f8831i = new a(method7, method6, method5);
        this.c = cls;
        this.d = cls2;
        this.e = method;
        this.f8828f = method2;
        this.f8829g = method3;
        this.f8830h = method4;
    }

    private boolean api23IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return true;
        }
    }

    private boolean api24IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return api23IsCleartextTrafficPermitted(str, cls, obj);
        }
    }

    public static i buildIfSupported() {
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            try {
                Class<?> cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
                try {
                    return new d(cls, cls2, cls2.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE), cls2.getMethod("setHostname", String.class), cls2.getMethod("getAlpnSelectedProtocol", null), cls2.getMethod("setAlpnProtocols", byte[].class));
                } catch (NoSuchMethodException unused) {
                    throw new IllegalStateException("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT);
                }
            } catch (ClassNotFoundException unused2) {
            }
        }
        return null;
    }

    @Override // p130w4.i
    public final c c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new b(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // p130w4.i
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<I> list) {
        if (this.d.isInstance(sSLSocket)) {
            if (str != null) {
                try {
                    this.e.invoke(sSLSocket, Boolean.TRUE);
                    this.f8828f.invoke(sSLSocket, str);
                } catch (IllegalAccessException e) {
                    e = e;
                    throw new AssertionError(e);
                } catch (InvocationTargetException e6) {
                    e = e6;
                    throw new AssertionError(e);
                }
            }
            this.f8830h.invoke(sSLSocket, i.e(list));
        }
    }

    @Override // p130w4.i
    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i5) throws IOException {
        try {
            socket.connect(inetSocketAddress, i5);
        } catch (AssertionError e) {
            if (!p107s4.d.k(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e6) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e6;
            }
            throw new IOException("Exception in connect", e6);
        }
    }

    @Override // p130w4.i
    public final e d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new c(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return new b(x509TrustManager.getAcceptedIssuers());
        }
    }

    @Override // p130w4.i
    public final SSLContext g() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    @Override // p130w4.i
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        if (!this.d.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f8829g.invoke(sSLSocket, null);
            if (bArr != null) {
                return new String(bArr, StandardCharsets.UTF_8);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p130w4.i
    public Object getStackTraceForCloseable(String str) {
        a aVar = this.f8831i;
        Method method = (Method) aVar.f784a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, null);
                ((Method) aVar.b).invoke(objInvoke, str);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // p130w4.i
    public final boolean h(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return api24IsCleartextTrafficPermitted(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return true;
        } catch (IllegalAccessException e) {
            e = e;
            throw new AssertionError("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e6) {
            e = e6;
            throw new AssertionError("unable to determine cleartext support", e);
        } catch (InvocationTargetException e7) {
            e = e7;
            throw new AssertionError("unable to determine cleartext support", e);
        }
    }

    @Override // p130w4.i
    public final void i(Object obj, String str) {
        a aVar = this.f8831i;
        aVar.getClass();
        if (obj != null) {
            try {
                ((Method) aVar.c).invoke(obj, null);
                return;
            } catch (Exception unused) {
            }
        }
        log(5, str, null);
    }

    @Override // p130w4.i
    public void log(int i5, String str, Throwable th) {
        int iMin;
        int i6 = i5 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            int iIndexOf = str.indexOf(10, i7);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i7 + 4000);
                Log.println(i6, "OkHttp", str.substring(i7, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i7 = iMin;
                }
            }
            i7 = iMin + 1;
        }
    }

    @Override // p130w4.i
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object fieldOrNull = i.readFieldOrNull(sSLSocketFactory, this.c, "sslParameters");
        if (fieldOrNull == null) {
            try {
                fieldOrNull = i.readFieldOrNull(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) i.readFieldOrNull(fieldOrNull, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) i.readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager");
    }
}
