package N3;

import V3.c;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import kotlin.jvm.internal.r;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final <T extends Annotation> c getAnnotationClass(T t6) {
        E.f(t6, "<this>");
        Class<? extends Annotation> clsAnnotationType = t6.annotationType();
        E.e(clsAnnotationType, "annotationType(...)");
        c kotlinClass = getKotlinClass(clsAnnotationType);
        E.d(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return kotlinClass;
    }

    public static final <T> Class<T> getJavaClass(c cVar) {
        E.f(cVar, "<this>");
        Class<T> cls = (Class<T>) ((r) cVar).getJClass();
        E.d(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    public static final <T> Class<T> getJavaObjectType(c cVar) {
        E.f(cVar, "<this>");
        Class<T> cls = (Class<T>) ((r) cVar).getJClass();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return !name.equals(XmlErrorCodes.DOUBLE) ? cls : Double.class;
            case 104431:
                return !name.equals(XmlErrorCodes.INT) ? cls : Integer.class;
            case 3039496:
                return !name.equals("byte") ? cls : Byte.class;
            case 3052374:
                return !name.equals("char") ? cls : Character.class;
            case 3327612:
                return !name.equals(XmlErrorCodes.LONG) ? cls : Long.class;
            case 3625364:
                return !name.equals("void") ? cls : Void.class;
            case 64711720:
                return !name.equals("boolean") ? cls : Boolean.class;
            case 97526364:
                return !name.equals("float") ? cls : Float.class;
            case 109413500:
                return !name.equals("short") ? cls : Short.class;
            default:
                return cls;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final <T> Class<T> getJavaPrimitiveType(c cVar) {
        E.f(cVar, "<this>");
        Class<T> cls = (Class<T>) ((r) cVar).getJClass();
        if (cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final <T> c getKotlinClass(Class<T> cls) {
        E.f(cls, "<this>");
        return U.a(cls);
    }

    public static final <T> Class<c> getRuntimeClassOfKClassInstance(c cVar) {
        E.f(cVar, "<this>");
        return cVar.getClass();
    }

    public static final <T> Class<T> getJavaClass(T t6) {
        E.f(t6, "<this>");
        return (Class<T>) t6.getClass();
    }

    public static /* synthetic */ void getDeclaringJavaClass$annotations(Enum r6) {
    }

    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(c cVar) {
    }
}
