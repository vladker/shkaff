package p071m3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p094q3.g;
import p122v2.a;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o extends AtomicInteger implements d {
    private static final long serialVersionUID = 3100232009247827843L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f6150a;
    public final m[] b;
    public volatile boolean e;
    public final p100r3.c c = new p100r3.c();
    public final AtomicLong d = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f6151f = new AtomicInteger();

    public o(c cVar, int i5, int i6) {
        this.f6150a = cVar;
        m[] mVarArr = new m[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            mVarArr[i7] = new m(this, i6);
        }
        this.b = mVarArr;
        this.f6151f.lazySet(i5);
    }

    public final void a() {
        for (m mVar : this.b) {
            mVar.getClass();
            g.a(mVar);
        }
    }

    public final void b() {
        for (m mVar : this.b) {
            mVar.e = null;
        }
    }

    public abstract void c();

    @Override // t5.d
    public final void cancel() {
        if (this.e) {
            return;
        }
        this.e = true;
        a();
        if (getAndIncrement() == 0) {
            b();
        }
    }

    public abstract void d();

    public abstract void e(Throwable th);

    public abstract void f(m mVar, Object obj);

    @Override // t5.d
    public final void request(long j6) {
        if (g.f(j6)) {
            a.a(this.d, j6);
            c();
        }
    }
}
