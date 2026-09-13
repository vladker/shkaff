package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y3 extends p094q3.c implements Z3 {
    private static final long serialVersionUID = -6178010334400373240L;
    public final p027e3.d c;
    public final C0688a4 d;
    public final C0688a4 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p100r3.c f4526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f4527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f4528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f4529i;

    public Y3(t5.c cVar, int i5, p027e3.d dVar) {
        super(cVar);
        this.c = dVar;
        this.f4527g = new AtomicInteger();
        this.d = new C0688a4(this, i5);
        this.e = new C0688a4(this, i5);
        this.f4526f = new p100r3.c();
    }

    @Override // io.reactivex.internal.operators.flowable.Z3
    public final void a(Throwable th) {
        p100r3.c cVar = this.f4526f;
        cVar.getClass();
        if (p100r3.g.a(cVar, th)) {
            f();
        } else {
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        C0688a4 c0688a4 = this.d;
        c0688a4.getClass();
        p094q3.g.a(c0688a4);
        C0688a4 c0688a5 = this.e;
        c0688a5.getClass();
        p094q3.g.a(c0688a5);
        if (this.f4527g.getAndIncrement() == 0) {
            c0688a4.clear();
            c0688a5.clear();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.Z3
    public final void f() {
        if (this.f4527g.getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        do {
            p043h3.j jVar = this.d.e;
            p043h3.j jVar2 = this.e.e;
            if (jVar != null && jVar2 != null) {
                while (true) {
                    if (get() == 4) {
                        this.d.clear();
                        this.e.clear();
                        return;
                    }
                    if (((Throwable) this.f4526f.get()) != null) {
                        i();
                        t5.c cVar = this.f7842a;
                        p100r3.c cVar2 = this.f4526f;
                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar2, cVar2, cVar);
                        return;
                    }
                    boolean z6 = this.d.f4553f;
                    Object objPoll = this.f4528h;
                    if (objPoll == null) {
                        try {
                            objPoll = jVar.poll();
                            this.f4528h = objPoll;
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            i();
                            p100r3.c cVar3 = this.f4526f;
                            cVar3.getClass();
                            p100r3.g.a(cVar3, th);
                            t5.c cVar4 = this.f7842a;
                            p100r3.c cVar5 = this.f4526f;
                            com.google.android.gms.auth.api.accounttransfer.a.q(cVar5, cVar5, cVar4);
                            return;
                        }
                    }
                    boolean z7 = objPoll == null;
                    boolean z8 = this.e.f4553f;
                    Object objPoll2 = this.f4529i;
                    if (objPoll2 == null) {
                        try {
                            objPoll2 = jVar2.poll();
                            this.f4529i = objPoll2;
                        } catch (Throwable th2) {
                            p017c3.d.throwIfFatal(th2);
                            i();
                            p100r3.c cVar6 = this.f4526f;
                            cVar6.getClass();
                            p100r3.g.a(cVar6, th2);
                            t5.c cVar7 = this.f7842a;
                            p100r3.c cVar8 = this.f4526f;
                            com.google.android.gms.auth.api.accounttransfer.a.q(cVar8, cVar8, cVar7);
                            return;
                        }
                    }
                    boolean z9 = objPoll2 == null;
                    if (z6 && z8 && z7 && z9) {
                        e(Boolean.TRUE);
                        return;
                    }
                    if (z6 && z8 && z7 != z9) {
                        i();
                        e(Boolean.FALSE);
                        return;
                    }
                    if (z7 || z9) {
                        break;
                    }
                    try {
                        ((V1.b) this.c).getClass();
                        if (!p039g3.A.a(objPoll, objPoll2)) {
                            i();
                            e(Boolean.FALSE);
                            return;
                        } else {
                            this.f4528h = null;
                            this.f4529i = null;
                            this.d.a();
                            this.e.a();
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        i();
                        p100r3.c cVar9 = this.f4526f;
                        cVar9.getClass();
                        p100r3.g.a(cVar9, th3);
                        t5.c cVar10 = this.f7842a;
                        p100r3.c cVar11 = this.f4526f;
                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar11, cVar11, cVar10);
                        return;
                    }
                }
            } else if (get() == 4) {
                this.d.clear();
                this.e.clear();
                return;
            } else if (((Throwable) this.f4526f.get()) != null) {
                i();
                t5.c cVar12 = this.f7842a;
                p100r3.c cVar13 = this.f4526f;
                com.google.android.gms.auth.api.accounttransfer.a.q(cVar13, cVar13, cVar12);
                return;
            }
            iAddAndGet = this.f4527g.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    public final void i() {
        C0688a4 c0688a4 = this.d;
        c0688a4.getClass();
        p094q3.g.a(c0688a4);
        c0688a4.clear();
        C0688a4 c0688a5 = this.e;
        c0688a5.getClass();
        p094q3.g.a(c0688a5);
        c0688a5.clear();
    }
}
