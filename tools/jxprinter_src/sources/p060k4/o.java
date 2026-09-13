package p060k4;

import E3.d;
import S2.l;
import V3.c;
import V3.p;
import java.util.List;
import kotlin.jvm.internal.E;
import p084o4.AbstractC1325o;
import p084o4.B0;
import p084o4.C0;
import p084o4.R0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o {
    private static final R0 SERIALIZERS_CACHE = AbstractC1325o.createCache(new l(14));
    private static final R0 SERIALIZERS_CACHE_NULLABLE = AbstractC1325o.createCache(new l(15));
    private static final B0 PARAMETRIZED_SERIALIZERS_CACHE = AbstractC1325o.createParametrizedCache(new d(12));
    private static final B0 PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE = AbstractC1325o.createParametrizedCache(new d(13));

    public static final b findCachedSerializer(c clazz, boolean z6) {
        E.f(clazz, "clazz");
        if (z6) {
            return SERIALIZERS_CACHE_NULLABLE.get(clazz);
        }
        b bVar = SERIALIZERS_CACHE.get(clazz);
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    public static final Object findParametrizedCachedSerializer(c clazz, List<? extends p> types, boolean z6) {
        E.f(clazz, "clazz");
        E.f(types, "types");
        return !z6 ? PARAMETRIZED_SERIALIZERS_CACHE.mo1041getgIAlus(clazz, types) : PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE.mo1041getgIAlus(clazz, types);
    }

    public static final R0 getSERIALIZERS_CACHE() {
        return SERIALIZERS_CACHE;
    }

    public static final e polymorphicIfInterface(c cVar) {
        E.f(cVar, "<this>");
        if (C0.isInterface(cVar)) {
            return new e(cVar);
        }
        return null;
    }
}
