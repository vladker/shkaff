package androidx.window.reflection;

import O3.a;
import V3.c;
import android.util.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ReflectionUtils {
    public static final ReflectionUtils INSTANCE = new ReflectionUtils();

    private ReflectionUtils() {
    }

    public static final boolean validateReflection$window_release(String str, a block) {
        E.f(block, "block");
        try {
            boolean zBooleanValue = ((Boolean) block.invoke()).booleanValue();
            if (!zBooleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "ClassNotFound: ".concat(str));
            return false;
        } catch (NoSuchMethodException unused2) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "NoSuchMethod: ".concat(str));
            return false;
        }
    }

    public static /* synthetic */ boolean validateReflection$window_release$default(String str, a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = null;
        }
        return validateReflection$window_release(str, aVar);
    }

    public final boolean checkIsPresent$window_release(a classLoader) {
        E.f(classLoader, "classLoader");
        try {
            classLoader.invoke();
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean doesReturn$window_release(Method method, c clazz) {
        E.f(method, "<this>");
        E.f(clazz, "clazz");
        return doesReturn$window_release(method, N3.a.getJavaClass(clazz));
    }

    public final boolean isPublic$window_release(Method method) {
        E.f(method, "<this>");
        return Modifier.isPublic(method.getModifiers());
    }

    public final boolean validateImplementation$window_release(Class<?> implementation, Class<?> requirements) {
        E.f(implementation, "implementation");
        E.f(requirements, "requirements");
        Method[] methods = requirements.getMethods();
        E.e(methods, "requirements.methods");
        for (Method method : methods) {
            if (!validateReflection$window_release(implementation.getName() + '#' + method.getName() + " is not valid", new ReflectionUtils$validateImplementation$1$1(implementation, method))) {
                return false;
            }
        }
        return true;
    }

    public final boolean doesReturn$window_release(Method method, Class<?> clazz) {
        E.f(method, "<this>");
        E.f(clazz, "clazz");
        return method.getReturnType().equals(clazz);
    }
}
