package retrofit2;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class m0 {
    public String a(Method method, int i5) {
        return "parameter #" + (i5 + 1);
    }

    public boolean b(Method method) {
        return false;
    }

    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) {
        throw new AssertionError();
    }
}
