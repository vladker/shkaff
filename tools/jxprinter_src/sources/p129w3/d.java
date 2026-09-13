package p129w3;

import io.reactivex.B;
import io.reactivex.I;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends B implements I {
    public abstract Throwable getThrowable();

    public abstract /* synthetic */ void onError(Throwable th);

    public abstract /* synthetic */ void onNext(Object obj);

    public abstract /* synthetic */ void onSubscribe(c cVar);

    public final d toSerialized() {
        return this instanceof c ? this : new c(this);
    }
}
