package androidx.datastore.core.handlers;

import E3.g;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class NoOpCorruptionHandler<T> implements CorruptionHandler<T> {
    @Override // androidx.datastore.core.CorruptionHandler
    public Object handleCorruption(CorruptionException corruptionException, g<? super T> gVar) throws CorruptionException {
        throw corruptionException;
    }
}
