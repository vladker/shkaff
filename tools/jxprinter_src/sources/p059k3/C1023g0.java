package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicLong;
import p011b3.b;
import p094q3.a;
import p100r3.g;
import p100r3.n;
import t5.c;

/* JADX INFO: renamed from: k3.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1023g0 extends a implements InterfaceC0988v {
    private static final long serialVersionUID = -660395290758764731L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5551a;
    public final Object d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f5555i;
    public final b b = new b();
    public final AtomicLong c = new AtomicLong();
    public final p100r3.c e = new p100r3.c();

    public C1023g0(c cVar, int i5, InterfaceC1027i0 interfaceC1027i0) {
        this.f5551a = cVar;
        this.f5552f = i5;
        this.d = interfaceC1027i0;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f5554h = true;
        return 2;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [h3.j, java.lang.Object] */
    @Override // t5.d
    public final void cancel() {
        if (this.f5553g) {
            return;
        }
        this.f5553g = true;
        this.b.dispose();
        if (getAndIncrement() == 0) {
            this.d.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [h3.j, java.lang.Object] */
    @Override // p043h3.j
    public final void clear() {
        this.d.clear();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [h3.j, java.lang.Object, k3.i0] */
    /* JADX WARN: Type inference failed for: r3v0, types: [h3.j, java.lang.Object, k3.i0] */
    public final void f() {
        if (getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        if (this.f5554h) {
            c cVar = this.f5551a;
            ?? r6 = this.d;
            int iAddAndGet2 = 1;
            while (!this.f5553g) {
                Throwable th = (Throwable) this.e.get();
                if (th != null) {
                    r6.clear();
                    cVar.onError(th);
                    return;
                }
                boolean z6 = r6.g() == this.f5552f;
                if (!r6.isEmpty()) {
                    cVar.onNext(null);
                }
                if (z6) {
                    cVar.onComplete();
                    return;
                } else {
                    iAddAndGet2 = addAndGet(-iAddAndGet2);
                    if (iAddAndGet2 == 0) {
                        return;
                    }
                }
            }
            r6.clear();
            return;
        }
        n nVar = n.f7968a;
        c cVar2 = this.f5551a;
        ?? r7 = this.d;
        long j6 = this.f5555i;
        do {
            long j7 = this.c.get();
            while (j6 != j7) {
                if (this.f5553g) {
                    r7.clear();
                    return;
                }
                if (((Throwable) this.e.get()) != null) {
                    r7.clear();
                    p100r3.c cVar3 = this.e;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar3, cVar3, cVar2);
                    return;
                } else {
                    if (r7.d() == this.f5552f) {
                        cVar2.onComplete();
                        return;
                    }
                    Object objPoll = r7.poll();
                    if (objPoll == null) {
                        break;
                    } else if (objPoll != nVar) {
                        cVar2.onNext(objPoll);
                        j6++;
                    }
                }
            }
            if (j6 == j7) {
                if (((Throwable) this.e.get()) != null) {
                    r7.clear();
                    p100r3.c cVar4 = this.e;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar4, cVar4, cVar2);
                    return;
                } else {
                    while (r7.peek() == nVar) {
                        r7.b();
                    }
                    if (r7.d() == this.f5552f) {
                        cVar2.onComplete();
                        return;
                    }
                }
            }
            this.f5555i = j6;
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [h3.j, java.lang.Object] */
    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.d.isEmpty();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, k3.i0] */
    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.d.offer(n.f7968a);
        f();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, k3.i0] */
    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        p100r3.c cVar = this.e;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.b.dispose();
        this.d.offer(n.f7968a);
        f();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        this.b.add(cVar);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, k3.i0] */
    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.d.offer(obj);
        f();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, k3.i0] */
    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll;
        do {
            objPoll = this.d.poll();
        } while (objPoll == n.f7968a);
        return objPoll;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.c, j6);
            f();
        }
    }
}
