package p028e4;

import java.util.List;
import p007a4.AbstractC0265b1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x {
    private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";

    public static final boolean isMissing(AbstractC0265b1 abstractC0265b1) {
        return abstractC0265b1.getImmediate() instanceof y;
    }

    public static final Void throwMissingMainDispatcherException() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final AbstractC0265b1 tryCreateDispatcher(v vVar, List<? extends v> list) {
        try {
            return vVar.createDispatcher(list);
        } catch (Throwable th) {
            vVar.hintOnError();
            throw th;
        }
    }
}
