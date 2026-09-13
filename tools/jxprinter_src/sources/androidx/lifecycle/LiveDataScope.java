package androidx.lifecycle;

import E3.g;
import p007a4.InterfaceC0280h0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface LiveDataScope<T> {
    Object emit(T t6, g<? super Q> gVar);

    Object emitSource(LiveData<T> liveData, g<? super InterfaceC0280h0> gVar);

    T getLatestValue();
}
