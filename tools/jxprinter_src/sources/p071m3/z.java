package p071m3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.M;
import p094q3.g;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends x {
    private static final long serialVersionUID = 1075119423897941642L;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f6170k;

    public z(c cVar, int i5, p083o3.c cVar2, M m6) {
        super(i5, cVar2, m6);
        this.f6170k = cVar;
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.e, dVar)) {
            this.e = dVar;
            this.f6170k.onSubscribe(this);
            dVar.request(this.f6163a);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th;
        int i5 = this.f6168j;
        p083o3.c cVar = this.c;
        c cVar2 = this.f6170k;
        int i6 = this.b;
        int iAddAndGet = 1;
        while (true) {
            long j6 = this.f6166h.get();
            long j7 = 0;
            while (j7 != j6) {
                if (this.f6167i) {
                    cVar.clear();
                    return;
                }
                boolean z6 = this.f6164f;
                if (z6 && (th = this.f6165g) != null) {
                    cVar.clear();
                    cVar2.onError(th);
                    this.d.dispose();
                    return;
                }
                Object objPoll = cVar.poll();
                boolean z7 = objPoll == null;
                if (z6 && z7) {
                    cVar2.onComplete();
                    this.d.dispose();
                    return;
                } else {
                    if (z7) {
                        break;
                    }
                    cVar2.onNext(objPoll);
                    j7++;
                    i5++;
                    if (i5 == i6) {
                        this.e.request(i5);
                        i5 = 0;
                    }
                }
            }
            if (j7 == j6) {
                if (this.f6167i) {
                    cVar.clear();
                    return;
                }
                if (this.f6164f) {
                    Throwable th2 = this.f6165g;
                    if (th2 != null) {
                        cVar.clear();
                        cVar2.onError(th2);
                        this.d.dispose();
                        return;
                    } else if (cVar.isEmpty()) {
                        cVar2.onComplete();
                        this.d.dispose();
                        return;
                    }
                }
            }
            if (j7 != 0 && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f6166h.addAndGet(-j7);
            }
            int i7 = get();
            if (i7 == iAddAndGet) {
                this.f6168j = i5;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                iAddAndGet = i7;
            }
        }
    }
}
