package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y extends p094q3.f implements InterfaceC0984q {
    private static final long serialVersionUID = 897683679971470653L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final V f4517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4518j;

    public Y(V v6) {
        super(false);
        this.f4517i = v6;
    }

    @Override // t5.c
    public final void onComplete() {
        long j6 = this.f4518j;
        if (j6 != 0) {
            this.f4518j = 0L;
            d(j6);
        }
        V v6 = this.f4517i;
        v6.f4476k = false;
        v6.c();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        long j6 = this.f4518j;
        if (j6 != 0) {
            this.f4518j = 0L;
            d(j6);
        }
        this.f4517i.a(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4518j++;
        this.f4517i.b(obj);
    }
}
