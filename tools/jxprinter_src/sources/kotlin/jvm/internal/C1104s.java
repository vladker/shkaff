package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem;

/* JADX INFO: renamed from: kotlin.jvm.internal.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1104s {
    public final String getClassQualifiedName(Class<?> jClass) {
        String str;
        E.f(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
            return null;
        }
        if (!jClass.isArray()) {
            String str2 = (String) C1105t.classFqNames.get(jClass.getName());
            return str2 == null ? jClass.getCanonicalName() : str2;
        }
        Class<?> componentType = jClass.getComponentType();
        if (componentType.isPrimitive() && (str = (String) C1105t.classFqNames.get(componentType.getName())) != null) {
            strConcat = str.concat(SoapEncSchemaTypeSystem.SOAP_ARRAY);
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final String getClassSimpleName(Class<?> jClass) {
        String str;
        E.f(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (!jClass.isLocalClass()) {
            if (!jClass.isArray()) {
                String str2 = (String) C1105t.simpleNames.get(jClass.getName());
                return str2 == null ? jClass.getSimpleName() : str2;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) C1105t.simpleNames.get(componentType.getName())) != null) {
                strConcat = str.concat(SoapEncSchemaTypeSystem.SOAP_ARRAY);
            }
            return strConcat == null ? SoapEncSchemaTypeSystem.SOAP_ARRAY : strConcat;
        }
        String simpleName = jClass.getSimpleName();
        Method enclosingMethod = jClass.getEnclosingMethod();
        if (enclosingMethod != null) {
            String strSubstringAfter = X3.b0.substringAfter(simpleName, enclosingMethod.getName() + '$', simpleName);
            if (strSubstringAfter != null) {
                return strSubstringAfter;
            }
        }
        Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return X3.b0.substringAfter(simpleName, '$', simpleName);
        }
        return X3.b0.substringAfter(simpleName, enclosingConstructor.getName() + '$', simpleName);
    }

    public final boolean isInstance(Object obj, Class<?> jClass) {
        E.f(jClass, "jClass");
        Map map = C1105t.FUNCTION_CLASSES;
        E.d(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(jClass);
        if (num != null) {
            return Y.g(num.intValue(), obj);
        }
        if (jClass.isPrimitive()) {
            jClass = N3.a.getJavaObjectType(N3.a.getKotlinClass(jClass));
        }
        return jClass.isInstance(obj);
    }
}
