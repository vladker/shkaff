package p145z1;

import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9106a;
    public final int b;

    public f(Map<?, ?> fmtMap) {
        E.f(fmtMap, "fmtMap");
        Object obj = fmtMap.get("format");
        E.d(obj, "null cannot be cast to non-null type kotlin.Int");
        this.f9106a = ((Integer) obj).intValue();
        Object obj2 = fmtMap.get("quality");
        E.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        this.b = ((Integer) obj2).intValue();
    }
}
