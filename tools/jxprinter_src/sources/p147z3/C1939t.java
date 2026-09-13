package p147z3;

import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: z3.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1939t {
    private final <T> Object failure(Throwable exception) {
        E.f(exception, "exception");
        return u.m1361constructorimpl(v.createFailure(exception));
    }

    private final <T> Object success(T t6) {
        return u.m1361constructorimpl(t6);
    }
}
