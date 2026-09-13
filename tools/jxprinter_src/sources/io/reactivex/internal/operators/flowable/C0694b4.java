package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.b4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0694b4 extends AtomicInteger implements p011b3.c, Z3 {
    private static final long serialVersionUID = -6178010334400373240L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.S f4572a;
    public final p027e3.d b;
    public final C0688a4 c;
    public final C0688a4 d;
    public final p100r3.c e = new p100r3.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f4573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f4574g;

    public C0694b4(io.reactivex.S s6, int i5, p027e3.d dVar) {
        this.f4572a = s6;
        this.b = dVar;
        this.c = new C0688a4(this, i5);
        this.d = new C0688a4(this, i5);
    }

    @Override // io.reactivex.internal.operators.flowable.Z3
    public final void a(Throwable th) {
        p100r3.c cVar = this.e;
        cVar.getClass();
        if (p100r3.g.a(cVar, th)) {
            f();
        } else {
            io.reactivex.plugins.a.onError(th);
        }
    }

    public final void b() {
        C0688a4 c0688a4 = this.c;
        c0688a4.getClass();
        p094q3.g.a(c0688a4);
        c0688a4.clear();
        C0688a4 c0688a5 = this.d;
        c0688a5.getClass();
        p094q3.g.a(c0688a5);
        c0688a5.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        C0688a4 c0688a4 = this.c;
        c0688a4.getClass();
        p094q3.g.a(c0688a4);
        C0688a4 c0688a5 = this.d;
        c0688a5.getClass();
        p094q3.g.a(c0688a5);
        if (getAndIncrement() == 0) {
            c0688a4.clear();
            c0688a5.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.get() == p094q3.g.f7849a;
    }

    @Override // io.reactivex.internal.operators.flowable.Z3
    public final void f() {
        if (getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        do {
            p043h3.j jVar = this.c.e;
            p043h3.j jVar2 = this.d.e;
            if (jVar != null && jVar2 != null) {
                while (true) {
                    if (e()) {
                        this.c.clear();
                        this.d.clear();
                        return;
                    }
                    if (((Throwable) this.e.get()) != null) {
                        b();
                        io.reactivex.S s6 = this.f4572a;
                        p100r3.c cVar = this.e;
                        cVar.getClass();
                        s6.onError(p100r3.g.b(cVar));
                        return;
                    }
                    boolean z6 = this.c.f4553f;
                    Object objPoll = this.f4573f;
                    if (objPoll == null) {
                        try {
                            objPoll = jVar.poll();
                            this.f4573f = objPoll;
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            b();
                            p100r3.c cVar2 = this.e;
                            cVar2.getClass();
                            p100r3.g.a(cVar2, th);
                            io.reactivex.S s7 = this.f4572a;
                            p100r3.c cVar3 = this.e;
                            cVar3.getClass();
                            s7.onError(p100r3.g.b(cVar3));
                            return;
                        }
                    }
                    boolean z7 = objPoll == null;
                    boolean z8 = this.d.f4553f;
                    Object objPoll2 = this.f4574g;
                    if (objPoll2 == null) {
                        try {
                            objPoll2 = jVar2.poll();
                            this.f4574g = objPoll2;
                        } catch (Throwable th2) {
                            p017c3.d.throwIfFatal(th2);
                            b();
                            p100r3.c cVar4 = this.e;
                            cVar4.getClass();
                            p100r3.g.a(cVar4, th2);
                            io.reactivex.S s8 = this.f4572a;
                            p100r3.c cVar5 = this.e;
                            cVar5.getClass();
                            s8.onError(p100r3.g.b(cVar5));
                            return;
                        }
                    }
                    boolean z9 = objPoll2 == null;
                    if (z6 && z8 && z7 && z9) {
                        this.f4572a.onSuccess(Boolean.TRUE);
                        return;
                    }
                    if (z6 && z8 && z7 != z9) {
                        b();
                        this.f4572a.onSuccess(Boolean.FALSE);
                        return;
                    }
                    if (z7 || z9) {
                        break;
                    }
                    try {
                        ((V1.b) this.b).getClass();
                        if (!p039g3.A.a(objPoll, objPoll2)) {
                            b();
                            this.f4572a.onSuccess(Boolean.FALSE);
                            return;
                        } else {
                            this.f4573f = null;
                            this.f4574g = null;
                            this.c.a();
                            this.d.a();
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        b();
                        p100r3.c cVar6 = this.e;
                        cVar6.getClass();
                        p100r3.g.a(cVar6, th3);
                        io.reactivex.S s9 = this.f4572a;
                        p100r3.c cVar7 = this.e;
                        cVar7.getClass();
                        s9.onError(p100r3.g.b(cVar7));
                        return;
                    }
                }
            } else if (e()) {
                this.c.clear();
                this.d.clear();
                return;
            } else if (((Throwable) this.e.get()) != null) {
                b();
                io.reactivex.S s10 = this.f4572a;
                p100r3.c cVar8 = this.e;
                cVar8.getClass();
                s10.onError(p100r3.g.b(cVar8));
                return;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }
}
