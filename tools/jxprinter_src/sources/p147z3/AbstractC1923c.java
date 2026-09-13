package p147z3;

import E3.g;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: z3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1923c {
    public abstract Object callRecursive(Object obj, g<Object> gVar);

    public abstract <U, S> Object callRecursive(C1921a c1921a, U u6, g<? super S> gVar);

    public final Void invoke(C1921a c1921a, Object obj) {
        E.f(c1921a, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}
