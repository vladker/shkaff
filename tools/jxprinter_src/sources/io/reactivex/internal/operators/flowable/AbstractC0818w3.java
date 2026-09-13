package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.io.Serializable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.w3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0818w3 extends p094q3.f implements InterfaceC0984q {
    private static final long serialVersionUID = -5604623027276966720L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p135x3.c f4817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p123v3.a f4818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0812v3 f4819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4820l;

    public AbstractC0818w3(p135x3.c cVar, p123v3.a aVar, C0812v3 c0812v3) {
        super(false);
        this.f4817i = cVar;
        this.f4818j = aVar;
        this.f4819k = c0812v3;
    }

    @Override // p094q3.f, t5.d
    public final void cancel() {
        super.cancel();
        this.f4819k.cancel();
    }

    public final void f(Serializable serializable) {
        e(p094q3.d.f7843a);
        long j6 = this.f4820l;
        if (j6 != 0) {
            this.f4820l = 0L;
            d(j6);
        }
        this.f4819k.request(1L);
        this.f4818j.onNext(serializable);
    }

    public void onError(Throwable th) {
        f(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4820l++;
        this.f4817i.onNext(obj);
    }
}
