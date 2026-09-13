package androidx.collection;

import L0.d;
import kotlin.jvm.internal.E;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> ArrayMap<K, V> arrayMapOf(C1938s... pairs) {
        E.f(pairs, "pairs");
        d dVar = (ArrayMap<K, V>) new ArrayMap(pairs.length);
        for (C1938s c1938s : pairs) {
            dVar.put(c1938s.f9134a, c1938s.b);
        }
        return dVar;
    }
}
