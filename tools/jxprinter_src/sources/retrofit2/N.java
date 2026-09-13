package retrofit2;

import java.io.IOException;
import okhttp3.InterfaceC1352e;
import okhttp3.InterfaceC1353f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class N implements InterfaceC1613k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f8103a;
    public final Object b;
    public final Object[] c;
    private Throwable creationFailure;
    public final InterfaceC1352e d;
    public final InterfaceC1621t e;
    private boolean executed;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f8104f;
    private InterfaceC1353f rawCall;

    public N(q0 q0Var, Object obj, Object[] objArr, InterfaceC1352e interfaceC1352e, InterfaceC1621t interfaceC1621t) {
        this.f8103a = q0Var;
        this.b = obj;
        this.c = objArr;
        this.d = interfaceC1352e;
        this.e = interfaceC1621t;
    }

    private InterfaceC1353f createRawCall() {
        okhttp3.M mCreate = this.f8103a.create(this.b, this.c);
        okhttp3.H h6 = (okhttp3.H) this.d;
        h6.getClass();
        return okhttp3.K.a(h6, mCreate);
    }

    private InterfaceC1353f getRawCall() throws IOException {
        InterfaceC1353f interfaceC1353f = this.rawCall;
        if (interfaceC1353f != null) {
            return interfaceC1353f;
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            InterfaceC1353f interfaceC1353fCreateRawCall = createRawCall();
            this.rawCall = interfaceC1353fCreateRawCall;
            return interfaceC1353fCreateRawCall;
        } catch (IOException | Error | RuntimeException e) {
            B0.k(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.InterfaceC1613k
    public final void b(InterfaceC1616n interfaceC1616n) {
        InterfaceC1353f interfaceC1353f;
        Throwable th;
        synchronized (this) {
            try {
                if (this.executed) {
                    throw new IllegalStateException("Already executed.");
                }
                this.executed = true;
                interfaceC1353f = this.rawCall;
                th = this.creationFailure;
                if (interfaceC1353f == null && th == null) {
                    try {
                        InterfaceC1353f interfaceC1353fCreateRawCall = createRawCall();
                        this.rawCall = interfaceC1353fCreateRawCall;
                        interfaceC1353f = interfaceC1353fCreateRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        B0.k(th);
                        this.creationFailure = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            interfaceC1616n.onFailure(this, th);
            return;
        }
        if (this.f8104f) {
            ((okhttp3.K) interfaceC1353f).b.c();
        }
        xyz.doikki.videoplayer.player.k kVar = new xyz.doikki.videoplayer.player.k(this, interfaceC1616n, 9);
        okhttp3.K k6 = (okhttp3.K) interfaceC1353f;
        synchronized (k6) {
            if (k6.d) {
                throw new IllegalStateException("Already Executed");
            }
            k6.d = true;
        }
        k6.b.b();
        k6.f6537a.f6512a.a(new okhttp3.J(k6, kVar));
    }

    @Override // retrofit2.InterfaceC1613k
    public final synchronized okhttp3.M c() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return ((okhttp3.K) getRawCall()).c;
    }

    @Override // retrofit2.InterfaceC1613k
    public final void cancel() {
        InterfaceC1353f interfaceC1353f;
        this.f8104f = true;
        synchronized (this) {
            interfaceC1353f = this.rawCall;
        }
        if (interfaceC1353f != null) {
            ((okhttp3.K) interfaceC1353f).b.c();
        }
    }

    public Object clone() {
        return new N(this.f8103a, this.b, this.c, this.d, this.e);
    }

    @Override // retrofit2.InterfaceC1613k
    public final boolean d() {
        boolean z6 = true;
        if (this.f8104f) {
            return true;
        }
        synchronized (this) {
            InterfaceC1353f interfaceC1353f = this.rawCall;
            if (interfaceC1353f == null || !((okhttp3.K) interfaceC1353f).b.f()) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // retrofit2.InterfaceC1613k
    public r0<Object> execute() {
        InterfaceC1353f rawCall;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            rawCall = getRawCall();
        }
        if (this.f8104f) {
            ((okhttp3.K) rawCall).b.c();
        }
        return parseResponse(((okhttp3.K) rawCall).execute());
    }

    public r0<Object> parseResponse(okhttp3.T t6) throws IOException {
        okhttp3.W wBody = t6.body();
        okhttp3.T tA = t6.b().body(new M(wBody.contentType(), wBody.c())).a();
        int i5 = tA.c;
        if (i5 < 200 || i5 >= 300) {
            try {
                return r0.a(B0.buffer(wBody), tA);
            } finally {
                wBody.close();
            }
        }
        if (i5 == 204 || i5 == 205) {
            wBody.close();
            return r0.success((Object) null, tA);
        }
        L l6 = new L(wBody);
        try {
            return r0.success(this.e.convert(l6), tA);
        } catch (RuntimeException e) {
            l6.throwIfCaught();
            throw e;
        }
    }

    @Override // retrofit2.InterfaceC1613k
    public final InterfaceC1613k clone() {
        return new N(this.f8103a, this.b, this.c, this.d, this.e);
    }
}
