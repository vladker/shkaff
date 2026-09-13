package p084o4;

import A3.j0;
import N3.a;
import V3.c;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C1099m;
import kotlin.jvm.internal.C1100n;
import kotlin.jvm.internal.C1103q;
import kotlin.jvm.internal.C1108w;
import kotlin.jvm.internal.C1109x;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.U;
import kotlin.jvm.internal.W;
import kotlin.jvm.internal.X;
import p060k4.b;
import p060k4.d;
import p060k4.e;
import p060k4.k;
import p060k4.l;
import p147z3.C1929i;
import p147z3.D;
import p147z3.H;
import p147z3.J;
import p147z3.K;
import p147z3.N;
import p147z3.O;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class C0 {
    public static final b a(Object obj, b... bVarArr) throws IllegalAccessException, InvocationTargetException {
        Class[] clsArr;
        try {
            if (bVarArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = bVarArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i5 = 0; i5 < length; i5++) {
                    clsArr2[i5] = b.class;
                }
                clsArr = clsArr2;
            }
            Object objInvoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(bVarArr, bVarArr.length));
            if (objInvoke instanceof b) {
                return (b) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    public static final <T> b compiledSerializerImpl(c cVar) {
        E.f(cVar, "<this>");
        return constructSerializerForGivenTypeArgs(cVar, new b[0]);
    }

    public static final <T> b constructSerializerForGivenTypeArgs(c cVar, b... args) {
        E.f(cVar, "<this>");
        E.f(args, "args");
        return constructSerializerForGivenTypeArgs(a.getJavaClass(cVar), (b[]) Arrays.copyOf(args, args.length));
    }

    public static final <T> T getChecked(T[] tArr, int i5) {
        E.f(tArr, "<this>");
        return tArr[i5];
    }

    public static final Map<c, b> initBuiltins() {
        Map mapCreateMapBuilder = j0.createMapBuilder();
        mapCreateMapBuilder.put(U.a(String.class), p066l4.a.serializer(X.INSTANCE));
        mapCreateMapBuilder.put(U.a(Character.TYPE), p066l4.a.serializer(C1103q.INSTANCE));
        mapCreateMapBuilder.put(U.a(char[].class), p066l4.a.CharArraySerializer());
        mapCreateMapBuilder.put(U.a(Double.TYPE), p066l4.a.serializer(C1108w.INSTANCE));
        mapCreateMapBuilder.put(U.a(double[].class), p066l4.a.DoubleArraySerializer());
        mapCreateMapBuilder.put(U.a(Float.TYPE), p066l4.a.serializer(C1109x.INSTANCE));
        mapCreateMapBuilder.put(U.a(float[].class), p066l4.a.FloatArraySerializer());
        mapCreateMapBuilder.put(U.a(Long.TYPE), p066l4.a.serializer(G.INSTANCE));
        mapCreateMapBuilder.put(U.a(long[].class), p066l4.a.LongArraySerializer());
        mapCreateMapBuilder.put(U.a(J.class), p066l4.a.serializer(J.Companion));
        mapCreateMapBuilder.put(U.a(Integer.TYPE), p066l4.a.serializer(C.INSTANCE));
        mapCreateMapBuilder.put(U.a(int[].class), p066l4.a.IntArraySerializer());
        mapCreateMapBuilder.put(U.a(p147z3.G.class), p066l4.a.serializer(p147z3.G.Companion));
        mapCreateMapBuilder.put(U.a(Short.TYPE), p066l4.a.serializer(W.INSTANCE));
        mapCreateMapBuilder.put(U.a(short[].class), p066l4.a.ShortArraySerializer());
        mapCreateMapBuilder.put(U.a(N.class), p066l4.a.serializer(N.Companion));
        mapCreateMapBuilder.put(U.a(Byte.TYPE), p066l4.a.serializer(C1100n.INSTANCE));
        mapCreateMapBuilder.put(U.a(byte[].class), p066l4.a.ByteArraySerializer());
        mapCreateMapBuilder.put(U.a(D.class), p066l4.a.serializer(D.Companion));
        mapCreateMapBuilder.put(U.a(Boolean.TYPE), p066l4.a.serializer(C1099m.INSTANCE));
        mapCreateMapBuilder.put(U.a(boolean[].class), p066l4.a.BooleanArraySerializer());
        mapCreateMapBuilder.put(U.a(Q.class), p066l4.a.serializer(Q.INSTANCE));
        mapCreateMapBuilder.put(U.a(Void.class), p066l4.a.NothingSerializer());
        try {
            mapCreateMapBuilder.put(U.a(Y3.b.class), p066l4.a.serializer(Y3.b.Companion));
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        try {
            mapCreateMapBuilder.put(U.a(K.class), p066l4.a.ULongArraySerializer());
        } catch (ClassNotFoundException | NoClassDefFoundError unused2) {
        }
        try {
            mapCreateMapBuilder.put(U.a(H.class), p066l4.a.UIntArraySerializer());
        } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
        }
        try {
            mapCreateMapBuilder.put(U.a(O.class), p066l4.a.UShortArraySerializer());
        } catch (ClassNotFoundException | NoClassDefFoundError unused4) {
        }
        try {
            mapCreateMapBuilder.put(U.a(p147z3.E.class), p066l4.a.UByteArraySerializer());
        } catch (ClassNotFoundException | NoClassDefFoundError unused5) {
        }
        try {
            mapCreateMapBuilder.put(U.a(Z3.c.class), p066l4.a.serializer(Z3.c.Companion));
        } catch (ClassNotFoundException | NoClassDefFoundError unused6) {
        }
        return j0.build(mapCreateMapBuilder);
    }

    public static final <T> boolean isInterface(c cVar) {
        E.f(cVar, "<this>");
        return a.getJavaClass(cVar).isInterface();
    }

    public static final boolean isReferenceArray(c rootClass) {
        E.f(rootClass, "rootClass");
        return a.getJavaClass(rootClass).isArray();
    }

    public static final Void platformSpecificSerializerNotRegistered(c cVar) {
        E.f(cVar, "<this>");
        D0.serializerNotRegistered(cVar);
        throw new C1929i();
    }

    public static final Void serializerNotRegistered(Class<?> cls) {
        E.f(cls, "<this>");
        throw new l(D0.notRegisteredMessage(a.getKotlinClass(cls)));
    }

    public static final <T, E extends T> E[] toNativeArrayImpl(ArrayList<E> arrayList, c eClass) {
        E.f(arrayList, "<this>");
        E.f(eClass, "eClass");
        Object objNewInstance = Array.newInstance((Class<?>) a.getJavaClass(eClass), arrayList.size());
        E.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] eArr = (E[]) arrayList.toArray((Object[]) objNewInstance);
        E.e(eArr, "toArray(...)");
        return eArr;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00bf  */
    public static final <T> b constructSerializerForGivenTypeArgs(Class<T> cls, b... args) throws IllegalAccessException, InvocationTargetException {
        Object obj;
        b bVar;
        Class<?> cls2;
        Object obj2;
        b bVarA;
        Field field;
        k kVar;
        E.f(cls, "<this>");
        E.f(args, "args");
        if (cls.isEnum() && cls.getAnnotation(k.class) == null && cls.getAnnotation(d.class) == null) {
            T[] enumConstants = cls.getEnumConstants();
            String canonicalName = cls.getCanonicalName();
            E.e(canonicalName, "getCanonicalName(...)");
            E.d(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
            return new J(canonicalName, (Enum[]) enumConstants);
        }
        b[] bVarArr = (b[]) Arrays.copyOf(args, args.length);
        try {
            Field declaredField = cls.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Throwable unused) {
            obj = null;
        }
        b bVarA2 = obj == null ? null : a(obj, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        if (bVarA2 != null) {
            return bVarA2;
        }
        String canonicalName2 = cls.getCanonicalName();
        if (canonicalName2 == null || X3.W.startsWith(canonicalName2, "java.", false) || X3.W.startsWith(canonicalName2, "kotlin.", false)) {
            bVar = null;
        } else {
            Field[] declaredFields = cls.getDeclaredFields();
            E.e(declaredFields, "getDeclaredFields(...)");
            int length = declaredFields.length;
            Field field2 = null;
            int i5 = 0;
            boolean z6 = false;
            while (true) {
                if (i5 >= length) {
                    if (!z6) {
                        break;
                    }
                    break;
                }
                Field field3 = declaredFields[i5];
                if (E.a(field3.getName(), "INSTANCE") && E.a(field3.getType(), cls) && Modifier.isStatic(field3.getModifiers())) {
                    if (!z6) {
                        z6 = true;
                        field2 = field3;
                    }
                }
                i5++;
                field2 = null;
                break;
            }
            if (field2 == null) {
                bVar = null;
            } else {
                Object obj3 = field2.get(null);
                Method[] methods = cls.getMethods();
                E.e(methods, "getMethods(...)");
                int length2 = methods.length;
                Method method = null;
                int i6 = 0;
                boolean z7 = false;
                while (true) {
                    if (i6 >= length2) {
                        if (!z7) {
                            break;
                        }
                        break;
                    }
                    Method method2 = methods[i6];
                    if (E.a(method2.getName(), "serializer")) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        E.e(parameterTypes, "getParameterTypes(...)");
                        if (parameterTypes.length == 0 && E.a(method2.getReturnType(), b.class)) {
                            if (!z7) {
                                z7 = true;
                                method = method2;
                            }
                        }
                    }
                    i6++;
                    method = null;
                    break;
                }
                if (method == null) {
                    bVar = null;
                } else {
                    Object objInvoke = method.invoke(obj3, null);
                    if (objInvoke instanceof b) {
                        bVar = (b) objInvoke;
                    } else {
                        bVar = null;
                    }
                }
            }
        }
        if (bVar != null) {
            return bVar;
        }
        b[] bVarArr2 = (b[]) Arrays.copyOf(args, args.length);
        Class<?>[] declaredClasses = cls.getDeclaredClasses();
        E.e(declaredClasses, "getDeclaredClasses(...)");
        int length3 = declaredClasses.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length3) {
                cls2 = null;
                break;
            }
            cls2 = declaredClasses[i7];
            if (cls2.getAnnotation(InterfaceC1331r0.class) != null) {
                break;
            }
            i7++;
        }
        if (cls2 == null) {
            obj2 = null;
        } else {
            try {
                Field declaredField2 = cls.getDeclaredField(cls2.getSimpleName());
                declaredField2.setAccessible(true);
                obj2 = declaredField2.get(null);
            } catch (Throwable unused2) {
                obj2 = null;
            }
        }
        if (obj2 == null || (bVarA = a(obj2, (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length))) == null) {
            try {
                Class<?>[] declaredClasses2 = cls.getDeclaredClasses();
                E.e(declaredClasses2, "getDeclaredClasses(...)");
                int length4 = declaredClasses2.length;
                Class<?> cls3 = null;
                int i8 = 0;
                boolean z8 = false;
                while (true) {
                    if (i8 < length4) {
                        Class<?> cls4 = declaredClasses2[i8];
                        if (cls4.getSimpleName().equals("$serializer")) {
                            if (!z8) {
                                z8 = true;
                                cls3 = cls4;
                            }
                        }
                        i8++;
                    } else if (!z8) {
                    }
                    cls3 = null;
                    break;
                }
                Object obj4 = (cls3 == null || (field = cls3.getField("INSTANCE")) == null) ? null : field.get(null);
                bVarA = obj4 instanceof b ? (b) obj4 : null;
            } catch (NoSuchFieldException unused3) {
            }
        }
        if (bVarA != null) {
            return bVarA;
        }
        if (cls.getAnnotation(d.class) == null && ((kVar = (k) cls.getAnnotation(k.class)) == null || !U.a(kVar.with()).equals(U.a(e.class)))) {
            return null;
        }
        return new e(a.getKotlinClass(cls));
    }

    public static final boolean getChecked(boolean[] zArr, int i5) {
        E.f(zArr, "<this>");
        return zArr[i5];
    }
}
