package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.s3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0794s3 extends AtomicInteger implements InterfaceC0984q {
    private static final long serialVersionUID = -7098360935104053232L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4763a;
    public final p094q3.f b;
    public final t5.b c;
    public long d;
    public long e;

    public C0794s3(t5.c cVar, long j6, p094q3.f fVar, t5.b bVar) {
        this.f4763a = cVar;
        this.b = fVar;
        this.c = bVar;
        this.d = j6;
    }

    public final void a() {
        if (getAndIncrement() == 0) {
            int iAddAndGet = 1;
            while (!this.b.f7847g) {
                long j6 = this.e;
                if (j6 != 0) {
                    this.e = 0L;
                    this.b.d(j6);
                }
                this.c.subscribe(this);
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        long j6 = this.d;
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            this.d = j6 - 1;
        }
        if (j6 != 0) {
            a();
        } else {
            this.f4763a.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4763a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.e++;
        this.f4763a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        this.b.e(dVar);
    }
}
