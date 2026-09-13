package p053j3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p017c3.e;
import p043h3.j;
import p094q3.g;
import t5.d;

/* JADX INFO: renamed from: j3.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0997h extends AtomicInteger implements InterfaceC0984q, c {
    private static final long serialVersionUID = 9032184911934499404L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5434a;
    public final int b;
    public final int c;
    public final C0996g d = new C0996g(this);
    public final AtomicBoolean e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f5437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f5438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f5440k;

    public C0997h(InterfaceC0679f interfaceC0679f, int i5) {
        this.f5434a = interfaceC0679f;
        this.b = i5;
        this.c = i5 - (i5 >> 2);
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        while (!e()) {
            if (!this.f5440k) {
                boolean z6 = this.f5439j;
                try {
                    InterfaceC0682i interfaceC0682i = (InterfaceC0682i) this.f5437h.poll();
                    boolean z7 = interfaceC0682i == null;
                    if (z6 && z7) {
                        if (this.e.compareAndSet(false, true)) {
                            this.f5434a.onComplete();
                            return;
                        }
                        return;
                    } else if (!z7) {
                        this.f5440k = true;
                        ((AbstractC0676c) interfaceC0682i).subscribe(this.d);
                        if (this.f5435f != 1) {
                            int i5 = this.f5436g + 1;
                            if (i5 == this.c) {
                                this.f5436g = 0;
                                this.f5438i.request(i5);
                            } else {
                                this.f5436g = i5;
                            }
                        }
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    if (!this.e.compareAndSet(false, true)) {
                        a.onError(th);
                        return;
                    } else {
                        this.f5438i.cancel();
                        this.f5434a.onError(th);
                        return;
                    }
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5438i.cancel();
        p033f3.d.a(this.d);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((c) this.d.get());
    }

    @Override // t5.c
    public final void onComplete() {
        this.f5439j = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (!this.e.compareAndSet(false, true)) {
            a.onError(th);
        } else {
            p033f3.d.a(this.d);
            this.f5434a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        InterfaceC0682i interfaceC0682i = (InterfaceC0682i) obj;
        if (this.f5435f != 0 || this.f5437h.offer(interfaceC0682i)) {
            a();
        } else {
            onError(new e());
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.f5438i, dVar)) {
            this.f5438i = dVar;
            int i5 = this.b;
            long j6 = i5 == Integer.MAX_VALUE ? LocationRequestCompat.PASSIVE_INTERVAL : i5;
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(3);
                if (iC == 1) {
                    this.f5435f = iC;
                    this.f5437h = gVar;
                    this.f5439j = true;
                    this.f5434a.onSubscribe(this);
                    a();
                    return;
                }
                if (iC == 2) {
                    this.f5435f = iC;
                    this.f5437h = gVar;
                    this.f5434a.onSubscribe(this);
                    dVar.request(j6);
                    return;
                }
            }
            if (this.b == Integer.MAX_VALUE) {
                this.f5437h = new p083o3.d(AbstractC0979l.f5366a);
            } else {
                this.f5437h = new p083o3.c(this.b);
            }
            this.f5434a.onSubscribe(this);
            dVar.request(j6);
        }
    }
}
