package retrofit2;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class k0 extends m0 {
    @Override // retrofit2.m0
    public final boolean b(Method method) {
        return method.isDefault();
    }

    @Override // retrofit2.m0
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) {
        return AbstractC1624w.invoke(method, cls, obj, objArr);
    }
}
