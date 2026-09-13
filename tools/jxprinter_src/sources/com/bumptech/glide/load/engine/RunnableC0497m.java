package com.bumptech.glide.load.engine;

import A3.AbstractC0157z;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.resource.bitmap.C0524t;
import java.util.ArrayList;
import java.util.Collections;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0497m implements InterfaceC0492h, Runnable, Comparable, M0.f {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public volatile InterfaceC0493i f3033A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public volatile boolean f3034C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public volatile boolean f3035D;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f3036G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public int f3037H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f3038I;
    public final C0505v d;
    public final Pools.Pool e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bumptech.glide.j f3042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p126w0.q f3043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bumptech.glide.o f3044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public E f3045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AbstractC0501q f3048n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p126w0.v f3049o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public C f3050p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3051q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f3052r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3053s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Object f3054t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Thread f3055u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p126w0.q f3056v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public p126w0.q f3057w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f3058x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public p126w0.a f3059y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.bumptech.glide.load.data.e f3060z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0494j f3039a = new C0494j();
    public final ArrayList b = new ArrayList();
    public final M0.j c = M0.j.newInstance();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final W1.a f3040f = new W1.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0496l f3041g = new C0496l();

    public RunnableC0497m(C0505v c0505v, Pools.Pool pool) {
        this.d = c0505v;
        this.e = pool;
    }

    private <Data> O decodeFromData(com.bumptech.glide.load.data.e eVar, Data data, p126w0.a aVar) {
        if (data == null) {
            eVar.a();
            return null;
        }
        try {
            long logTime = L0.l.getLogTime();
            O oDecodeFromFetcher = decodeFromFetcher(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                e("Decoded result " + oDecodeFromFetcher, logTime, null);
            }
            return oDecodeFromFetcher;
        } finally {
            eVar.a();
        }
    }

    private <Data> O decodeFromFetcher(Data data, p126w0.a aVar) {
        Class<?> cls = data.getClass();
        C0494j c0494j = this.f3039a;
        return runLoadPath(data, aVar, c0494j.c.getRegistry().getLoadPath(cls, c0494j.f3019g, c0494j.f3023k));
    }

    @NonNull
    private p126w0.v getOptionsWithHardwareConfig(p126w0.a aVar) {
        p126w0.v vVar = this.f3049o;
        boolean z6 = aVar == p126w0.a.d || this.f3039a.f3030r;
        p126w0.u uVar = C0524t.f3122i;
        Boolean bool = (Boolean) vVar.get(uVar);
        if (bool != null && (!bool.booleanValue() || z6)) {
            return vVar;
        }
        p126w0.v vVar2 = new p126w0.v();
        vVar2.putAll(this.f3049o);
        vVar2.set(uVar, Boolean.valueOf(z6));
        return vVar2;
    }

    private <Data, ResourceType> O runLoadPath(Data data, p126w0.a aVar, M m6) {
        p126w0.v optionsWithHardwareConfig = getOptionsWithHardwareConfig(aVar);
        com.bumptech.glide.load.data.g rewinder = this.f3042h.getRegistry().getRewinder(data);
        try {
            return m6.load(rewinder, optionsWithHardwareConfig, this.f3046l, this.f3047m, new C0495k(this, aVar));
        } finally {
            rewinder.a();
        }
    }

    public final void a() {
        O oDecodeFromData;
        boolean zA;
        if (Log.isLoggable("DecodeJob", 2)) {
            e("Retrieved data", this.f3052r, "data: " + this.f3058x + ", cache key: " + this.f3056v + ", fetcher: " + this.f3060z);
        }
        N nObtain = null;
        try {
            oDecodeFromData = decodeFromData(this.f3060z, this.f3058x, this.f3059y);
        } catch (J e) {
            p126w0.q qVar = this.f3057w;
            p126w0.a aVar = this.f3059y;
            e.b = qVar;
            e.c = aVar;
            e.d = null;
            this.b.add(e);
            oDecodeFromData = null;
        }
        if (oDecodeFromData == null) {
            i();
            return;
        }
        p126w0.a aVar2 = this.f3059y;
        boolean z6 = this.f3036G;
        if (oDecodeFromData instanceof K) {
            ((K) oDecodeFromData).initialize();
        }
        if (((N) this.f3040f.c) != null) {
            nObtain = N.obtain(oDecodeFromData);
            oDecodeFromData = nObtain;
        }
        k();
        C c = this.f3050p;
        synchronized (c) {
            c.f2942q = oDecodeFromData;
            c.f2943r = aVar2;
            c.f2950y = z6;
        }
        synchronized (c) {
            try {
                c.b.a();
                if (c.f2949x) {
                    c.f2942q.recycle();
                    c.f();
                } else {
                    if (c.f2930a.f2928a.isEmpty()) {
                        throw new IllegalStateException("Received a resource without any callbacks to notify");
                    }
                    if (c.f2944s) {
                        throw new IllegalStateException("Already have resource");
                    }
                    z zVar = c.e;
                    O o6 = c.f2942q;
                    boolean z7 = c.f2938m;
                    p126w0.q qVar2 = c.f2937l;
                    G g6 = c.c;
                    zVar.getClass();
                    c.f2947v = new H(o6, z7, true, qVar2, g6);
                    c.f2944s = true;
                    B b = c.f2930a;
                    b.getClass();
                    ArrayList arrayList = new ArrayList(b.f2928a);
                    B b6 = new B(arrayList);
                    c.d(arrayList.size() + 1);
                    ((x) c.f2931f).c(c, c.f2937l, c.f2947v);
                    for (A a6 : b6) {
                        a6.b.execute(new y(c, a6.f2927a, 1));
                    }
                    c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3037H = 5;
        try {
            W1.a aVar3 = this.f3040f;
            if (((N) aVar3.c) != null) {
                C0505v c0505v = this.d;
                p126w0.v vVar = this.f3049o;
                aVar3.getClass();
                try {
                    c0505v.a().a((p126w0.q) aVar3.f784a, new C0491g((p126w0.y) aVar3.b, (N) aVar3.c, vVar));
                    ((N) aVar3.c).a();
                } catch (Throwable th2) {
                    ((N) aVar3.c).a();
                    throw th2;
                }
            }
            if (nObtain != null) {
                nObtain.a();
            }
            C0496l c0496l = this.f3041g;
            synchronized (c0496l) {
                c0496l.b = true;
                zA = c0496l.a();
            }
            if (zA) {
                g();
            }
        } catch (Throwable th3) {
            if (nObtain != null) {
                nObtain.a();
            }
            throw th3;
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0492h
    public final void b(p126w0.q qVar, Exception exc, com.bumptech.glide.load.data.e eVar, p126w0.a aVar) {
        eVar.a();
        J j6 = new J("Fetching data failed", Collections.singletonList(exc));
        Class<Object> dataClass = eVar.getDataClass();
        j6.b = qVar;
        j6.c = aVar;
        j6.d = dataClass;
        this.b.add(j6);
        if (Thread.currentThread() != this.f3055u) {
            h(2);
        } else {
            i();
        }
    }

    public final InterfaceC0493i c() {
        int iB = p050j.n.b(this.f3037H);
        C0494j c0494j = this.f3039a;
        if (iB == 1) {
            return new P(c0494j, this);
        }
        if (iB == 2) {
            return new C0489e(c0494j.a(), c0494j, this);
        }
        if (iB == 3) {
            return new V(c0494j, this);
        }
        if (iB == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: ".concat(androidx.exifinterface.media.a.B(this.f3037H)));
    }

    public final int d(int i5) {
        int iB = p050j.n.b(i5);
        if (iB == 0) {
            if (this.f3048n.b()) {
                return 2;
            }
            return d(2);
        }
        if (iB == 1) {
            if (this.f3048n.a()) {
                return 3;
            }
            return d(3);
        }
        if (iB == 2) {
            return this.f3053s ? 6 : 4;
        }
        if (iB == 3 || iB == 5) {
            return 6;
        }
        throw new IllegalArgumentException("Unrecognized stage: ".concat(androidx.exifinterface.media.a.B(i5)));
    }

    public final void e(String str, long j6, String str2) {
        StringBuilder sbX = AbstractC0157z.x(str, " in ");
        sbX.append(L0.l.a(j6));
        sbX.append(", load key: ");
        sbX.append(this.f3045k);
        sbX.append(str2 != null ? ", ".concat(str2) : "");
        sbX.append(", thread: ");
        sbX.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sbX.toString());
    }

    public final void f() {
        boolean zA;
        k();
        J j6 = new J("Failed to load resource", new ArrayList(this.b));
        C c = this.f3050p;
        synchronized (c) {
            c.f2945t = j6;
        }
        synchronized (c) {
            try {
                c.b.a();
                if (c.f2949x) {
                    c.f();
                } else {
                    if (c.f2930a.f2928a.isEmpty()) {
                        throw new IllegalStateException("Received an exception without any callbacks to notify");
                    }
                    if (c.f2946u) {
                        throw new IllegalStateException("Already failed once");
                    }
                    c.f2946u = true;
                    p126w0.q qVar = c.f2937l;
                    B b = c.f2930a;
                    b.getClass();
                    ArrayList arrayList = new ArrayList(b.f2928a);
                    B b6 = new B(arrayList);
                    c.d(arrayList.size() + 1);
                    ((x) c.f2931f).c(c, qVar, null);
                    for (A a6 : b6) {
                        a6.b.execute(new y(c, a6.f2927a, 0));
                    }
                    c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C0496l c0496l = this.f3041g;
        synchronized (c0496l) {
            c0496l.c = true;
            zA = c0496l.a();
        }
        if (zA) {
            g();
        }
    }

    public final void g() {
        C0496l c0496l = this.f3041g;
        synchronized (c0496l) {
            c0496l.b = false;
            c0496l.f3032a = false;
            c0496l.c = false;
        }
        W1.a aVar = this.f3040f;
        aVar.f784a = null;
        aVar.b = null;
        aVar.c = null;
        C0494j c0494j = this.f3039a;
        c0494j.c = null;
        c0494j.d = null;
        c0494j.f3026n = null;
        c0494j.f3019g = null;
        c0494j.f3023k = null;
        c0494j.f3021i = null;
        c0494j.f3027o = null;
        c0494j.f3022j = null;
        c0494j.f3028p = null;
        c0494j.f3017a.clear();
        c0494j.f3024l = false;
        c0494j.b.clear();
        c0494j.f3025m = false;
        this.f3034C = false;
        this.f3042h = null;
        this.f3043i = null;
        this.f3049o = null;
        this.f3044j = null;
        this.f3045k = null;
        this.f3050p = null;
        this.f3037H = 0;
        this.f3033A = null;
        this.f3055u = null;
        this.f3056v = null;
        this.f3058x = null;
        this.f3059y = null;
        this.f3060z = null;
        this.f3052r = 0L;
        this.f3035D = false;
        this.f3054t = null;
        this.b.clear();
        this.e.release(this);
    }

    @Override // M0.f
    @NonNull
    public M0.j getVerifier() {
        return this.c;
    }

    public final void h(int i5) {
        p138y0.e eVar;
        this.f3038I = i5;
        C c = this.f3050p;
        if (c.f2939n) {
            eVar = c.f2934i;
        } else {
            eVar = c.f2940o ? c.f2935j : c.f2933h;
        }
        eVar.execute(this);
    }

    public final void i() {
        this.f3055u = Thread.currentThread();
        this.f3052r = L0.l.getLogTime();
        boolean zA = false;
        while (!this.f3035D && this.f3033A != null && !(zA = this.f3033A.a())) {
            this.f3037H = d(this.f3037H);
            this.f3033A = c();
            if (this.f3037H == 4) {
                h(2);
                return;
            }
        }
        if ((this.f3037H == 6 || this.f3035D) && !zA) {
            f();
        }
    }

    public final void j() {
        String str;
        int iB = p050j.n.b(this.f3038I);
        if (iB == 0) {
            this.f3037H = d(1);
            this.f3033A = c();
            i();
        } else {
            if (iB == 1) {
                i();
                return;
            }
            if (iB == 2) {
                a();
                return;
            }
            int i5 = this.f3038I;
            if (i5 == 1) {
                str = "INITIALIZE";
            } else if (i5 != 2) {
                str = i5 != 3 ? AbstractC1127c.NULL : "DECODE_DATA";
            } else {
                str = "SWITCH_TO_SOURCE_SERVICE";
            }
            throw new IllegalStateException("Unrecognized run reason: ".concat(str));
        }
    }

    public final void k() {
        this.c.a();
        if (this.f3034C) {
            throw new IllegalStateException("Already notified", this.b.isEmpty() ? null : (Throwable) androidx.collection.a.e(this.b, 1));
        }
        this.f3034C = true;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0492h
    public final void onDataFetcherReady(p126w0.q qVar, Object obj, com.bumptech.glide.load.data.e eVar, p126w0.a aVar, p126w0.q qVar2) {
        this.f3056v = qVar;
        this.f3058x = obj;
        this.f3060z = eVar;
        this.f3059y = aVar;
        this.f3057w = qVar2;
        this.f3036G = qVar != this.f3039a.a().get(0);
        if (Thread.currentThread() != this.f3055u) {
            h(3);
        } else {
            a();
        }
    }

    @NonNull
    public <Z> O onResourceDecoded(p126w0.a aVar, @NonNull O o6) {
        O oTransform;
        p126w0.z zVar;
        p126w0.c encodeStrategy;
        Object c0490f;
        Class<?> cls = o6.get().getClass();
        p126w0.a aVar2 = p126w0.a.d;
        C0494j c0494j = this.f3039a;
        p126w0.y resultEncoder = null;
        if (aVar != aVar2) {
            p126w0.z zVarC = c0494j.c(cls);
            zVar = zVarC;
            oTransform = zVarC.transform(this.f3042h, o6, this.f3046l, this.f3047m);
        } else {
            oTransform = o6;
            zVar = null;
        }
        if (!o6.equals(oTransform)) {
            o6.recycle();
        }
        if (c0494j.c.getRegistry().isResourceEncoderAvailable(oTransform)) {
            resultEncoder = c0494j.c.getRegistry().getResultEncoder(oTransform);
            encodeStrategy = resultEncoder.getEncodeStrategy(this.f3049o);
        } else {
            encodeStrategy = p126w0.c.c;
        }
        p126w0.y yVar = resultEncoder;
        p126w0.q qVar = this.f3056v;
        ArrayList arrayListB = c0494j.b();
        int size = arrayListB.size();
        boolean z6 = false;
        for (int i5 = 0; i5 < size; i5++) {
            if (((p144z0.S) arrayListB.get(i5)).f9063a.equals(qVar)) {
                z6 = true;
                break;
            }
        }
        if (!this.f3048n.d(!z6, aVar, encodeStrategy)) {
            return oTransform;
        }
        if (yVar == null) {
            throw new com.bumptech.glide.t(oTransform.get().getClass());
        }
        int iOrdinal = encodeStrategy.ordinal();
        if (iOrdinal == 0) {
            c0490f = new C0490f(this.f3056v, this.f3043i);
        } else {
            if (iOrdinal != 1) {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
            }
            c0490f = new Q(c0494j.c.getArrayPool(), this.f3056v, this.f3043i, this.f3046l, this.f3047m, zVar, cls, this.f3049o);
        }
        N nObtain = N.obtain(oTransform);
        W1.a aVar3 = this.f3040f;
        aVar3.f784a = c0490f;
        aVar3.b = yVar;
        aVar3.c = nObtain;
        return nObtain;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bumptech.glide.load.data.e eVar = this.f3060z;
        try {
            try {
                if (this.f3035D) {
                    f();
                    if (eVar != null) {
                        eVar.a();
                        return;
                    }
                    return;
                }
                j();
                if (eVar != null) {
                    eVar.a();
                }
            } catch (Throwable th) {
                if (eVar != null) {
                    eVar.a();
                }
                throw th;
            }
        } catch (C0488d e) {
            throw e;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.f3035D + ", stage: " + androidx.exifinterface.media.a.B(this.f3037H), th2);
            }
            if (this.f3037H != 5) {
                this.b.add(th2);
                f();
            }
            if (!this.f3035D) {
                throw th2;
            }
            throw th2;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull RunnableC0497m runnableC0497m) {
        int iOrdinal = this.f3044j.ordinal() - runnableC0497m.f3044j.ordinal();
        return iOrdinal == 0 ? this.f3051q - runnableC0497m.f3051q : iOrdinal;
    }
}
