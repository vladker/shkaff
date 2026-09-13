package I3;

import A3.C;
import java.lang.reflect.Method;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    public static final Method addSuppressed;
    public static final Method getSuppressed;

    static {
        Method method;
        Method method2;
        Method[] methods = Throwable.class.getMethods();
        E.c(methods);
        int length = methods.length;
        int i5 = 0;
        while (true) {
            method = null;
            if (i5 >= length) {
                method2 = null;
                break;
            }
            method2 = methods[i5];
            if (E.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                E.e(parameterTypes, "getParameterTypes(...)");
                if (E.a(C.singleOrNull(parameterTypes), Throwable.class)) {
                    break;
                }
            }
            i5++;
        }
        addSuppressed = method2;
        for (Method method3 : methods) {
            if (E.a(method3.getName(), "getSuppressed")) {
                method = method3;
                break;
            }
        }
        getSuppressed = method;
    }
}
