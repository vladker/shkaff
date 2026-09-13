package p088p3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.internal.operators.flowable.C0690b0;
import java.util.concurrent.atomic.AtomicReference;
import p017c3.e;
import p043h3.j;
import p083o3.c;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends AtomicReference implements InterfaceC0984q, d {
    private static final long serialVersionUID = 22876611072430776L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0690b0 f7743a;
    public final int b;
    public final int c;
    public volatile j d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7745g;

    public i(C0690b0 c0690b0, int i5) {
        this.f7743a = c0690b0;
        this.b = i5;
        this.c = i5 - (i5 >> 2);
    }

    @Override // t5.d
    public final void cancel() {
        g.a(this);
    }

    @Override // t5.c
    public final void onComplete() {
        C0690b0 c0690b0 = this.f7743a;
        c0690b0.getClass();
        this.e = true;
        c0690b0.b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f7743a.c(this, th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f7745g != 0) {
            this.f7743a.b();
            return;
        }
        C0690b0 c0690b0 = this.f7743a;
        c0690b0.getClass();
        if (this.d.offer(obj)) {
            c0690b0.b();
        } else {
            g.a(this);
            c0690b0.c(this, new e());
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.e(this, dVar)) {
            boolean z6 = dVar instanceof p043h3.g;
            long j6 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (z6) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(3);
                if (iC == 1) {
                    this.f7745g = iC;
                    this.d = gVar;
                    this.e = true;
                    C0690b0 c0690b0 = this.f7743a;
                    c0690b0.getClass();
                    this.e = true;
                    c0690b0.b();
                    return;
                }
                if (iC == 2) {
                    this.f7745g = iC;
                    this.d = gVar;
                    int i5 = this.b;
                    if (i5 >= 0) {
                        j6 = i5;
                    }
                    dVar.request(j6);
                    return;
                }
            }
            int i6 = this.b;
            this.d = i6 < 0 ? new p083o3.d(-i6) : new c(i6);
            int i7 = this.b;
            if (i7 >= 0) {
                j6 = i7;
            }
            dVar.request(j6);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (this.f7745g != 1) {
            long j7 = this.f7744f + j6;
            if (j7 < this.c) {
                this.f7744f = j7;
            } else {
                this.f7744f = 0L;
                ((d) get()).request(j7);
            }
        }
    }
}
