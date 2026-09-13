package p039g3;

import A3.AbstractC0157z;
import V1.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3987a = new b(27);

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void c(int i5, String str) {
        if (i5 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i5);
    }

    public static void d(long j6, String str) {
        if (j6 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j6);
    }

    @Deprecated
    public static long requireNonNull(long j6, String str) {
        throw new InternalError(AbstractC0157z.n("Null check on a primitive: ", str));
    }
}
