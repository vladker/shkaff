package p145z1;

import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9107a;
    public final int b;
    public final int c;
    public final int d;

    public g(Map<?, ?> map) {
        E.f(map, "map");
        Object obj = map.get("x");
        E.d(obj, "null cannot be cast to non-null type kotlin.Int");
        this.f9107a = ((Integer) obj).intValue();
        Object obj2 = map.get("y");
        E.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        this.b = ((Integer) obj2).intValue();
        Object obj3 = map.get("w");
        E.d(obj3, "null cannot be cast to non-null type kotlin.Int");
        this.c = ((Integer) obj3).intValue();
        Object obj4 = map.get("h");
        E.d(obj4, "null cannot be cast to non-null type kotlin.Int");
        this.d = ((Integer) obj4).intValue();
    }
}
