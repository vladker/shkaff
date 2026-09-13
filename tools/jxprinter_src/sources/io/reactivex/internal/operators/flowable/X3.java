package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X3 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -1776795561228106469L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4509a;
    public final p027e3.c b;
    public final p083o3.c c;
    public final AtomicLong d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Throwable f4513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t5.d f4514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f4515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4516l;

    public X3(int i5, p027e3.c cVar, Object obj, t5.c cVar2) {
        this.f4509a = cVar2;
        this.b = cVar;
        this.f4515k = obj;
        this.e = i5;
        this.f4510f = i5 - (i5 >> 2);
        p083o3.c cVar3 = new p083o3.c(i5);
        this.c = cVar3;
        cVar3.offer(obj);
        this.d = new AtomicLong();
    }

    public final void a() {
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4509a;
        p083o3.c cVar2 = this.c;
        int i5 = this.f4510f;
        int i6 = this.f4516l;
        int iAddAndGet = 1;
        do {
            long j6 = this.d.get();
            long j7 = 0;
            while (j7 != j6) {
                if (this.f4511g) {
                    cVar2.clear();
                    return;
                }
                boolean z6 = this.f4512h;
                if (z6 && (th = this.f4513i) != null) {
                    cVar2.clear();
                    cVar.onError(th);
                    return;
                }
                Object objPoll = cVar2.poll();
                boolean z7 = objPoll == null;
                if (z6 && z7) {
                    cVar.onComplete();
                    return;
                }
                if (z7) {
                    break;
                }
                cVar.onNext(objPoll);
                j7++;
                i6++;
                if (i6 == i5) {
                    this.f4514j.request(i5);
                    i6 = 0;
                }
            }
            if (j7 == j6 && this.f4512h) {
                Throwable th2 = this.f4513i;
                if (th2 != null) {
                    cVar2.clear();
                    cVar.onError(th2);
                    return;
                } else if (cVar2.isEmpty()) {
                    cVar.onComplete();
                    return;
                }
            }
            if (j7 != 0) {
                p122v2.a.e(this.d, j7);
            }
            this.f4516l = i6;
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // t5.d
    public final void cancel() {
        this.f4511g = true;
        this.f4514j.cancel();
        if (getAndIncrement() == 0) {
            this.c.clear();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4512h) {
            return;
        }
        this.f4512h = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4512h) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4513i = th;
        this.f4512h = true;
        a();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4512h) {
            return;
        }
        try {
            Object objApply = this.b.apply(this.f4515k, obj);
            p039g3.A.b(objApply, "The accumulator returned a null value");
            this.f4515k = objApply;
            this.c.offer(objApply);
            a();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f4514j.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4514j, dVar)) {
            this.f4514j = dVar;
            this.f4509a.onSubscribe(this);
            dVar.request(this.e - 1);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.d, j6);
            a();
        }
    }
}
