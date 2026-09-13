package p084o4;

import O3.l;
import O3.p;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: o4.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1325o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6470a;

    static {
        boolean z6;
        try {
            Class.forName("java.lang.ClassValue");
            z6 = true;
        } catch (Throwable unused) {
            z6 = false;
        }
        f6470a = z6;
    }

    public static final <T> R0 createCache(l factory) {
        E.f(factory, "factory");
        return f6470a ? new C1334t(factory) : new A(factory);
    }

    public static final <T> B0 createParametrizedCache(p factory) {
        E.f(factory, "factory");
        return f6470a ? new C1338v(factory) : new B(factory);
    }
}
