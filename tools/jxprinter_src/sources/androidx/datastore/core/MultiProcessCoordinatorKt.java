package androidx.datastore.core;

import E3.q;
import java.io.File;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiProcessCoordinatorKt {
    public static final InterProcessCoordinator createMultiProcessCoordinator(q context, File file) {
        E.f(context, "context");
        E.f(file, "file");
        return new MultiProcessCoordinator(context, file);
    }
}
