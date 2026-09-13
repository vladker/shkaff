package io.reactivex;

/* JADX INFO: renamed from: io.reactivex.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0981n extends InterfaceC0978k {
    @Override // io.reactivex.InterfaceC0978k
    /* synthetic */ void onError(Throwable th);

    @Override // io.reactivex.InterfaceC0978k
    /* synthetic */ void onNext(Object obj);

    InterfaceC0981n serialize();

    void setCancellable(p027e3.f fVar);

    void setDisposable(p011b3.c cVar);

    boolean tryOnError(Throwable th);
}
