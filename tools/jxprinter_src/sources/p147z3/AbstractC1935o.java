package p147z3;

import O3.a;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: z3.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1935o {
    public static <T> InterfaceC1934n lazy(a initializer) {
        E.f(initializer, "initializer");
        return new y(initializer, null);
    }

    public static <T> InterfaceC1934n lazy(EnumC1936p mode, a initializer) {
        E.f(mode, "mode");
        E.f(initializer, "initializer");
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            return new y(initializer, null);
        }
        if (iOrdinal == 1) {
            return new x(initializer);
        }
        if (iOrdinal == 2) {
            return new S(initializer);
        }
        throw new C1937q();
    }

    public static final <T> InterfaceC1934n lazy(Object obj, a initializer) {
        E.f(initializer, "initializer");
        return new y(initializer, obj);
    }
}
