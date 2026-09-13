package io.reactivex;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface Q {
    void onError(Throwable th);

    void onSuccess(Object obj);

    void setCancellable(p027e3.f fVar);

    void setDisposable(p011b3.c cVar);

    boolean tryOnError(Throwable th);
}
