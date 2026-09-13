package t4;

import A3.AbstractC0157z;
import A4.InterfaceC0170m;
import A4.InterfaceC0171n;
import A4.N;
import A4.k0;
import androidx.core.location.LocationRequestCompat;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C1348a;
import okhttp3.C1355h;
import okhttp3.C1366l;
import okhttp3.C1374u;
import okhttp3.C1378y;
import okhttp3.F;
import okhttp3.H;
import okhttp3.I;
import okhttp3.InterfaceC1349b;
import okhttp3.InterfaceC1353f;
import okhttp3.InterfaceC1364j;
import okhttp3.L;
import okhttp3.M;
import okhttp3.S;
import okhttp3.T;
import okhttp3.X;
import okhttp3.internal.http2.A;
import okhttp3.internal.http2.C1357a;
import okhttp3.internal.http2.EnumC1358b;
import okhttp3.internal.http2.G;
import okhttp3.internal.http2.s;
import okhttp3.internal.http2.t;
import okhttp3.r;
import okhttp3.z;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends okhttp3.internal.http2.o implements InterfaceC1364j {
    public final i b;
    public final X c;
    public Socket d;
    public Socket e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C1374u f8677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public I f8678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f8679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InterfaceC0171n f8680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public InterfaceC0170m f8681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8684m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8685n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8686o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f8687p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f8688q = LocationRequestCompat.PASSIVE_INTERVAL;

    public h(i iVar, X x6) {
        this.b = iVar;
        this.c = x6;
    }

    private void connectSocket(int i5, int i6, InterfaceC1353f interfaceC1353f, r rVar) throws IOException {
        X x6 = this.c;
        Proxy proxy = x6.b;
        this.d = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? x6.f6549a.c.createSocket() : new Socket(proxy);
        InetSocketAddress inetSocketAddress = x6.c;
        rVar.getClass();
        this.d.setSoTimeout(i6);
        try {
            p130w4.i.f8835a.connectSocket(this.d, x6.c, i5);
            try {
                this.f8680i = N.buffer(N.source(this.d));
                this.f8681j = N.buffer(N.sink(this.d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e6) {
            ConnectException connectException = new ConnectException("Failed to connect to " + x6.c);
            connectException.initCause(e6);
            throw connectException;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void connectTls(b bVar) throws Throwable {
        C1348a c1348a = this.c.f6549a;
        SSLSocketFactory sslSocketFactory = c1348a.sslSocketFactory();
        C1378y c1378y = c1348a.f6553a;
        SSLSocket sSLSocket = null;
        try {
            try {
                Socket socket = this.d;
                String str = c1378y.d;
                String str2 = c1378y.d;
                SSLSocket sSLSocket2 = (SSLSocket) sslSocketFactory.createSocket(socket, str, c1378y.e, true);
                try {
                    C1366l c1366lConfigureSecureSocket = bVar.configureSecureSocket(sSLSocket2);
                    if (c1366lConfigureSecureSocket.b) {
                        p130w4.i.f8835a.configureTlsExtensions(sSLSocket2, str2, c1348a.e);
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    C1374u c1374u = C1374u.get(session);
                    if (c1348a.hostnameVerifier().verify(str2, session)) {
                        c1348a.certificatePinner().check(str2, c1374u.c);
                        String selectedProtocol = c1366lConfigureSecureSocket.b ? p130w4.i.f8835a.getSelectedProtocol(sSLSocket2) : null;
                        this.e = sSLSocket2;
                        this.f8680i = N.buffer(N.source(sSLSocket2));
                        this.f8681j = N.buffer(N.sink(this.e));
                        this.f8677f = c1374u;
                        this.f8678g = selectedProtocol != null ? I.get(selectedProtocol) : I.HTTP_1_1;
                        p130w4.i.f8835a.a(sSLSocket2);
                        return;
                    }
                    List list = c1374u.c;
                    if (list.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + str2 + " not verified (no certificates)");
                    }
                    X509Certificate x509Certificate = (X509Certificate) list.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + str2 + " not verified:\n    certificate: " + C1355h.a(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + p142y4.d.a(x509Certificate));
                } catch (AssertionError e) {
                    e = e;
                    if (!p107s4.d.k(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        p130w4.i.f8835a.a(sSLSocket);
                    }
                    p107s4.d.d(sSLSocket);
                    throw th;
                }
            } catch (AssertionError e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void connectTunnel(int i5, int i6, int i7, InterfaceC1353f interfaceC1353f, r rVar) throws IOException {
        M mCreateTunnelRequest = createTunnelRequest();
        C1378y c1378y = mCreateTunnelRequest.f6539a;
        for (int i8 = 0; i8 < 21; i8++) {
            connectSocket(i5, i6, interfaceC1353f, rVar);
            mCreateTunnelRequest = createTunnel(i6, i7, mCreateTunnelRequest, c1378y);
            if (mCreateTunnelRequest == null) {
                return;
            }
            p107s4.d.d(this.d);
            this.d = null;
            this.f8681j = null;
            this.f8680i = null;
            X x6 = this.c;
            rVar.connectEnd(interfaceC1353f, x6.c, x6.b, null);
        }
    }

    private M createTunnel(int i5, int i6, M m6, C1378y c1378y) throws IOException {
        String str = "CONNECT " + p107s4.d.h(c1378y, true) + " HTTP/1.1";
        while (true) {
            InterfaceC0171n interfaceC0171n = this.f8680i;
            p124v4.g gVar = new p124v4.g(null, null, interfaceC0171n, this.f8681j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            interfaceC0171n.timeout().timeout(i5, timeUnit);
            this.f8681j.timeout().timeout(i6, timeUnit);
            gVar.writeRequest(m6.c, str);
            gVar.finishRequest();
            S responseHeaders = gVar.readResponseHeaders(false);
            responseHeaders.d(m6);
            T tA = responseHeaders.a();
            int i7 = tA.c;
            gVar.skipConnectBody(tA);
            if (i7 == 200) {
                if (this.f8680i.getBuffer().exhausted() && this.f8681j.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (i7 != 407) {
                throw new IOException(AbstractC0157z.k(i7, "Unexpected response code for CONNECT: "));
            }
            X x6 = this.c;
            ((F4.e) x6.f6549a.d).getClass();
            M mLambda$static$0 = InterfaceC1349b.lambda$static$0(x6, tA);
            if (mLambda$static$0 == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(tA.header(HttpHeaders.CONNECTION))) {
                return mLambda$static$0;
            }
            m6 = mLambda$static$0;
        }
    }

    private M createTunnelRequest() {
        L l6 = new L();
        X x6 = this.c;
        l6.d(x6.f6549a.f6553a);
        L lMethod = l6.method("CONNECT", null);
        C1348a c1348a = x6.f6549a;
        lMethod.b.d(HttpHeaders.HOST, p107s4.d.h(c1348a.f6553a, true));
        lMethod.b.d("Proxy-Connection", HttpHeaders.KEEP_ALIVE);
        lMethod.b.d(HttpHeaders.USER_AGENT, "okhttp/3.14.9");
        M mA = lMethod.a();
        S s6 = new S();
        s6.d(mA);
        s6.c(I.HTTP_1_1);
        s6.f6543a = Videoio.CAP_PROP_XI_GPI_MODE;
        s6.b = "Preemptive Authenticate";
        S sBody = s6.body(p107s4.d.d);
        sBody.d = -1L;
        sBody.e = -1L;
        sBody.c.d(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive");
        T tA = sBody.a();
        ((F4.e) c1348a.d).getClass();
        M mLambda$static$0 = InterfaceC1349b.lambda$static$0(x6, tA);
        return mLambda$static$0 != null ? mLambda$static$0 : mA;
    }

    private void establishProtocol(b bVar, int i5, InterfaceC1353f interfaceC1353f, r rVar) throws Throwable {
        X x6 = this.c;
        if (x6.f6549a.sslSocketFactory() != null) {
            rVar.getClass();
            connectTls(bVar);
            rVar.secureConnectEnd(interfaceC1353f, this.f8677f);
            if (this.f8678g == I.HTTP_2) {
                startHttp2(i5);
                return;
            }
            return;
        }
        List list = x6.f6549a.e;
        I i6 = I.H2_PRIOR_KNOWLEDGE;
        if (!list.contains(i6)) {
            this.e = this.d;
            this.f8678g = I.HTTP_1_1;
        } else {
            this.e = this.d;
            this.f8678g = i6;
            startHttp2(i5);
        }
    }

    private void startHttp2(int i5) throws SocketException {
        this.e.setSoTimeout(0);
        okhttp3.internal.http2.m mVar = new okhttp3.internal.http2.m();
        mVar.e = okhttp3.internal.http2.o.f6619a;
        mVar.f6617f = true;
        Socket socket = this.e;
        String str = this.c.f6549a.f6553a.d;
        InterfaceC0171n interfaceC0171n = this.f8680i;
        InterfaceC0170m interfaceC0170m = this.f8681j;
        mVar.f6616a = socket;
        mVar.b = str;
        mVar.c = interfaceC0171n;
        mVar.d = interfaceC0170m;
        mVar.e = this;
        mVar.f6618g = i5;
        s sVar = new s(mVar);
        this.f8679h = sVar;
        sVar.start();
    }

    @Override // okhttp3.internal.http2.o
    public final void a(s sVar) {
        synchronized (this.b) {
            this.f8686o = sVar.c();
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x013e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x013e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:? A[LOOP:0: B:98:0x005e->B:114:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:61:0x0102  */
    /* JADX WARN: Code duplicated, block: B:66:0x0113  */
    /* JADX WARN: Code duplicated, block: B:92:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void b(int i5, int i6, int i7, int i8, boolean z6, InterfaceC1353f interfaceC1353f, r rVar) {
        InterfaceC1353f interfaceC1353f2;
        r rVar2;
        IOException iOException;
        IOException iOException2;
        Method method;
        boolean z7;
        if (this.f8678g != null) {
            throw new IllegalStateException("already connected");
        }
        C1348a c1348a = this.c.f6549a;
        List list = c1348a.f6554f;
        b bVar = new b(list);
        if (c1348a.sslSocketFactory() == null) {
            if (!list.contains(C1366l.d)) {
                throw new j(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.c.f6549a.f6553a.d;
            if (!p130w4.i.f8835a.h(str)) {
                throw new j(new UnknownServiceException(AbstractC0157z.o("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (this.c.f6549a.e.contains(I.H2_PRIOR_KNOWLEDGE)) {
            throw new j(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        j jVar = null;
        while (true) {
            try {
                if (this.c.a()) {
                    try {
                        connectTunnel(i5, i6, i7, interfaceC1353f, rVar);
                        interfaceC1353f2 = interfaceC1353f;
                        rVar2 = rVar;
                        try {
                            if (this.d != null) {
                                break;
                            } else {
                                break;
                            }
                        } catch (IOException e) {
                            e = e;
                            iOException = e;
                            p107s4.d.d(this.e);
                            p107s4.d.d(this.d);
                            this.e = null;
                            this.d = null;
                            this.f8680i = null;
                            this.f8681j = null;
                            this.f8677f = null;
                            this.f8678g = null;
                            this.f8679h = null;
                            X x6 = this.c;
                            rVar2.connectFailed(interfaceC1353f2, x6.c, x6.b, null, iOException);
                            if (jVar == null) {
                                jVar = new j(iOException);
                            } else {
                                iOException2 = jVar.f8692a;
                                method = p107s4.d.f8240j;
                                if (method != null) {
                                    try {
                                        method.invoke(iOException2, iOException);
                                    } catch (IllegalAccessException | InvocationTargetException unused) {
                                    }
                                }
                                jVar.b = iOException;
                            }
                            if (z6) {
                                throw jVar;
                            }
                            bVar.d = true;
                            z7 = false;
                            if (bVar.c) {
                                z7 = iOException instanceof SSLException;
                            }
                            if (z7) {
                                throw jVar;
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                        interfaceC1353f2 = interfaceC1353f;
                        rVar2 = rVar;
                    }
                } else {
                    interfaceC1353f2 = interfaceC1353f;
                    rVar2 = rVar;
                    connectSocket(i5, i6, interfaceC1353f2, rVar2);
                }
                try {
                    establishProtocol(bVar, i8, interfaceC1353f2, rVar2);
                    X x7 = this.c;
                    rVar2.connectEnd(interfaceC1353f2, x7.c, x7.b, this.f8678g);
                    break;
                } catch (IOException e7) {
                    e = e7;
                    iOException = e;
                    p107s4.d.d(this.e);
                    p107s4.d.d(this.d);
                    this.e = null;
                    this.d = null;
                    this.f8680i = null;
                    this.f8681j = null;
                    this.f8677f = null;
                    this.f8678g = null;
                    this.f8679h = null;
                    X x8 = this.c;
                    rVar2.connectFailed(interfaceC1353f2, x8.c, x8.b, null, iOException);
                    if (jVar == null) {
                        jVar = new j(iOException);
                    } else {
                        iOException2 = jVar.f8692a;
                        method = p107s4.d.f8240j;
                        if (method != null) {
                            method.invoke(iOException2, iOException);
                        }
                        jVar.b = iOException;
                    }
                    if (z6) {
                        throw jVar;
                    }
                    bVar.d = true;
                    z7 = false;
                    if (bVar.c && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException) && ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException))) {
                        z7 = iOException instanceof SSLException;
                    }
                    if (z7) {
                        throw jVar;
                    }
                }
            } catch (IOException e8) {
                e = e8;
                interfaceC1353f2 = interfaceC1353f;
                rVar2 = rVar;
            }
        }
        if (this.c.a() && this.d == null) {
            throw new j(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.f8679h != null) {
            synchronized (this.b) {
                this.f8686o = this.f8679h.c();
            }
        }
    }

    public final void c() {
        synchronized (this.b) {
            this.f8682k = true;
        }
    }

    public final boolean d(C1378y c1378y) {
        int i5 = c1378y.e;
        String str = c1378y.d;
        C1378y c1378y2 = this.c.f6549a.f6553a;
        if (i5 == c1378y2.e) {
            if (str.equals(c1378y2.d)) {
                return true;
            }
            C1374u c1374u = this.f8677f;
            if (c1374u != null && p142y4.d.c(str, (X509Certificate) c1374u.c.get(0))) {
                return true;
            }
        }
        return false;
    }

    @Override // okhttp3.InterfaceC1364j
    public final C1374u handshake() {
        return this.f8677f;
    }

    public boolean isEligible(C1348a c1348a, List<X> list) {
        if (this.f8687p.size() < this.f8686o && !this.f8682k) {
            F f6 = p107s4.a.f8232a;
            X x6 = this.c;
            C1348a c1348a2 = x6.f6549a;
            f6.getClass();
            boolean zA = c1348a2.a(c1348a);
            C1378y c1378y = c1348a.f6553a;
            if (zA) {
                if (c1378y.d.equals(x6.f6549a.f6553a.d)) {
                    return true;
                }
                if (this.f8679h != null && list != null) {
                    int size = list.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        X x7 = list.get(i5);
                        Proxy.Type type = x7.b.type();
                        Proxy.Type type2 = Proxy.Type.DIRECT;
                        if (type == type2 && x6.b.type() == type2 && x6.c.equals(x7.c)) {
                            if (c1348a.hostnameVerifier() != p142y4.d.f9043a || !d(c1378y)) {
                                break;
                                break;
                            }
                            try {
                                c1348a.certificatePinner().check(c1378y.d, this.f8677f.c);
                                return true;
                            } catch (SSLPeerUnverifiedException unused) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public p118u4.c newCodec(H h6, z zVar) throws SocketException {
        if (this.f8679h != null) {
            return new t(h6, this, zVar, this.f8679h);
        }
        p118u4.f fVar = (p118u4.f) zVar;
        this.e.setSoTimeout(fVar.f8739g);
        k0 k0VarTimeout = this.f8680i.timeout();
        long j6 = fVar.f8739g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        k0VarTimeout.timeout(j6, timeUnit);
        this.f8681j.timeout().timeout(fVar.f8740h, timeUnit);
        return new p124v4.g(h6, this, this.f8680i, this.f8681j);
    }

    public p148z4.a newWebSocketStreams(e eVar) throws SocketException {
        this.e.setSoTimeout(0);
        c();
        return new g(eVar);
    }

    @Override // okhttp3.internal.http2.o
    public void onStream(A a6) {
        a6.close(EnumC1358b.REFUSED_STREAM, null);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        X x6 = this.c;
        sb.append(x6.f6549a.f6553a.d);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(x6.f6549a.f6553a.e);
        sb.append(", proxy=");
        sb.append(x6.b);
        sb.append(" hostAddress=");
        sb.append(x6.c);
        sb.append(" cipherSuite=");
        C1374u c1374u = this.f8677f;
        sb.append(c1374u != null ? c1374u.b : "none");
        sb.append(" protocol=");
        sb.append(this.f8678g);
        sb.append('}');
        return sb.toString();
    }

    public void trackFailure(IOException iOException) {
        synchronized (this.b) {
            try {
                if (iOException instanceof G) {
                    EnumC1358b enumC1358b = ((G) iOException).f6595a;
                    if (enumC1358b == EnumC1358b.REFUSED_STREAM) {
                        int i5 = this.f8685n + 1;
                        this.f8685n = i5;
                        if (i5 > 1) {
                            this.f8682k = true;
                            this.f8683l++;
                        }
                    } else if (enumC1358b != EnumC1358b.CANCEL) {
                        this.f8682k = true;
                        this.f8683l++;
                    }
                } else {
                    if (!(this.f8679h != null) || (iOException instanceof C1357a)) {
                        this.f8682k = true;
                        if (this.f8684m == 0) {
                            if (iOException != null) {
                                this.b.a(this.c, iOException);
                            }
                            this.f8683l++;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
