package G3;

import java.lang.reflect.Method;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    private static i cache;
    public static final j INSTANCE = new j();
    private static final i notOnJava9 = new i(null, null, null);

    public final String getModuleName(a continuation) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        E.f(continuation, "continuation");
        i iVar = cache;
        if (iVar == null) {
            try {
                i iVar2 = new i(Class.class.getDeclaredMethod("getModule", null), continuation.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                cache = iVar2;
                iVar = iVar2;
            } catch (Exception unused) {
                iVar = notOnJava9;
                cache = iVar;
            }
        }
        if (iVar == notOnJava9 || (method = iVar.getModuleMethod) == null || (objInvoke = method.invoke(continuation.getClass(), null)) == null || (method2 = iVar.getDescriptorMethod) == null || (objInvoke2 = method2.invoke(objInvoke, null)) == null) {
            return null;
        }
        Method method3 = iVar.nameMethod;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
