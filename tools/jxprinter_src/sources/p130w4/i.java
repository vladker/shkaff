package p130w4;

import A4.C0169l;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.H;
import okhttp3.I;
import p107s4.d;
import p142y4.a;
import p142y4.b;
import p142y4.c;
import p142y4.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f8835a;
    public static final Logger b;

    static {
        h hVar;
        i iVar;
        e eVarJ;
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            iVar = a.buildIfSupported();
            if (iVar == null && (iVar = d.buildIfSupported()) == null) {
                throw new NullPointerException("No platform found on Android");
            }
        } else {
            g gVar = null;
            if (!("conscrypt".equals(d.getSystemProperty("okhttp.platform", null)) ? true : "Conscrypt".equals(Security.getProviders()[0].getName())) || (eVarJ = e.j()) == null) {
                try {
                    hVar = new h(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", null));
                } catch (NoSuchMethodException unused) {
                    hVar = null;
                }
                if (hVar != null) {
                    iVar = hVar;
                } else {
                    try {
                        Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                        gVar = new g(cls.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null)), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
                    } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                    }
                    iVar = gVar != null ? gVar : new i();
                }
            } else {
                iVar = eVarJ;
            }
        }
        f8835a = iVar;
        b = Logger.getLogger(H.class.getName());
    }

    public static ArrayList b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            I i6 = (I) list.get(i5);
            if (i6 != I.HTTP_1_0) {
                arrayList.add(i6.f6536a);
            }
        }
        return arrayList;
    }

    public static byte[] e(List list) {
        C0169l c0169l = new C0169l();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            I i6 = (I) list.get(i5);
            if (i6 != I.HTTP_1_0) {
                c0169l.writeByte(i6.f6536a.length());
                c0169l.writeUtf8(i6.f6536a);
            }
        }
        return c0169l.readByteArray();
    }

    public static <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        Object fieldOrNull;
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return (T) readFieldOrNull(fieldOrNull, cls, str);
    }

    public c c(X509TrustManager x509TrustManager) {
        return new a(d(x509TrustManager));
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i5) throws IOException {
        socket.connect(inetSocketAddress, i5);
    }

    public e d(X509TrustManager x509TrustManager) {
        return new b(x509TrustManager.getAcceptedIssuers());
    }

    public SSLContext g() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public Object getStackTraceForCloseable(String str) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean h(String str) {
        return true;
    }

    public void i(Object obj, String str) {
        if (obj == null) {
            str = androidx.collection.a.n(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(5, str, (Throwable) obj);
    }

    public void log(int i5, String str, Throwable th) {
        b.log(i5 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        try {
            Object fieldOrNull = readFieldOrNull(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (fieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void f(SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<I> list) {
    }
}
