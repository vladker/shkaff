package p134x2;

import kotlin.jvm.internal.E;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K {
    public static final I Companion = new I();
    private final J resultType;
    private final Object value;

    public K(J resultType, Object obj) {
        E.f(resultType, "resultType");
        this.resultType = resultType;
        this.value = obj;
    }

    public final boolean a() {
        return this.resultType == J.b;
    }

    public final boolean b() {
        return this.resultType == J.f8857a;
    }

    public final Throwable exceptionOrNull() {
        if (!a()) {
            return null;
        }
        Object obj = this.value;
        E.d(obj, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) obj;
    }

    public final Object getOrNull() {
        if (b()) {
            return this.value;
        }
        return null;
    }

    public String toString() {
        int iOrdinal = this.resultType.ordinal();
        if (iOrdinal == 0) {
            return "Success[value=" + this.value + "]";
        }
        if (iOrdinal != 1) {
            throw new C1937q();
        }
        return "Failure[exception=" + this.value + "]";
    }
}
