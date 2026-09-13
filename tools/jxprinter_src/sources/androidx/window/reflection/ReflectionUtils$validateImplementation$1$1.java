package androidx.window.reflection;

import O3.a;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ReflectionUtils$validateImplementation$1$1 extends F implements a {
    final /* synthetic */ Class<?> $implementation;
    final /* synthetic */ Method $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectionUtils$validateImplementation$1$1(Class<?> cls, Method method) {
        super(0);
        this.$implementation = cls;
        this.$it = method;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0039  */
    @Override // O3.a
    public final Boolean invoke() throws NoSuchMethodException {
        boolean z6;
        Class<?> cls = this.$implementation;
        String name = this.$it.getName();
        Class<?>[] parameterTypes = this.$it.getParameterTypes();
        Method implementedMethod = cls.getMethod(name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        E.e(implementedMethod, "implementedMethod");
        if (reflectionUtils.isPublic$window_release(implementedMethod)) {
            Class<?> returnType = this.$it.getReturnType();
            E.e(returnType, "it.returnType");
            if (reflectionUtils.doesReturn$window_release(implementedMethod, returnType)) {
                z6 = true;
            } else {
                z6 = false;
            }
        } else {
            z6 = false;
        }
        return Boolean.valueOf(z6);
    }
}
