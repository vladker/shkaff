package retrofit2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class s0 implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f8160a = new Object[0];
    public final /* synthetic */ Class b;
    public final /* synthetic */ u0 c;

    public s0(u0 u0Var, Class cls) {
        this.c = u0Var;
        this.b = cls;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr == null) {
            objArr = this.f8160a;
        }
        m0 m0Var = j0.f8130a;
        boolean zB = m0Var.b(method);
        Class<?> cls = this.b;
        return zB ? m0Var.invokeDefaultMethod(method, cls, obj, objArr) : this.c.b(cls, method).invoke(obj, objArr);
    }
}
