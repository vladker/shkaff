package androidx.datastore.core;

import E3.g;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface DataMigration<T> {
    Object cleanUp(g<? super Q> gVar);

    Object migrate(T t6, g<? super T> gVar);

    Object shouldMigrate(T t6, g<? super Boolean> gVar);
}
