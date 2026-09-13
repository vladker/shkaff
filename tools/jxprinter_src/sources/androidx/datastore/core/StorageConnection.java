package androidx.datastore.core;

import E3.g;
import O3.p;
import O3.q;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface StorageConnection<T> extends Closeable {
    InterProcessCoordinator getCoordinator();

    <R> Object readScope(q qVar, g<? super R> gVar);

    Object writeScope(p pVar, g<? super Q> gVar);
}
