package p096r;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;
import p055k.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7884a;
    public final Method b;
    public final Field c;
    public final int d;
    public final Class e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Type f7885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f7886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f7888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f7889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f7890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f7891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final char[] f7892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7893n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f7894o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f7895p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f7896q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String[] f7897r;

    public d(String str, Class cls, Class cls2, Type type, Field field, int i5, int i6) {
        this.f7884a = str;
        this.f7886g = cls;
        this.e = cls2;
        this.f7885f = type;
        this.b = null;
        this.c = field;
        this.d = i5;
        this.f7888i = i6;
        this.f7889j = 0;
        this.f7893n = cls2.isEnum();
        if (field != null) {
            this.f7891l = Modifier.isTransient(field.getModifiers());
        } else {
            this.f7891l = false;
        }
        this.f7892m = b();
        if (field != null) {
            j.C(field);
        }
        this.f7890k = "";
        this.f7887h = false;
        this.f7894o = false;
        this.f7895p = false;
        this.f7896q = null;
        this.f7897r = new String[0];
    }

    public static Type d(Type type, Class cls, Type type2) {
        ParameterizedType parameterizedType;
        TypeVariable[] typeParameters;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type typeD = d(type, cls, genericComponentType);
                return genericComponentType != typeD ? Array.newInstance((Class<?>) j.q(typeD), 0).getClass() : type2;
            }
            if (j.x(type)) {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) j.u(type);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    TypeVariable[] typeParameters2 = j.q(parameterizedType2).getTypeParameters();
                    for (int i5 = 0; i5 < typeParameters2.length; i5++) {
                        if (typeParameters2[i5].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i5];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    Type[] actualTypeArguments2 = null;
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeParameters = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeParameters = cls.getSuperclass().getTypeParameters();
                    } else {
                        parameterizedType = null;
                        typeParameters = null;
                    }
                    boolean z6 = false;
                    for (int i6 = 0; i6 < actualTypeArguments.length && parameterizedType != null; i6++) {
                        Type type3 = actualTypeArguments[i6];
                        if (type3 instanceof TypeVariable) {
                            TypeVariable typeVariable2 = (TypeVariable) type3;
                            for (int i7 = 0; i7 < typeParameters.length; i7++) {
                                if (typeParameters[i7].getName().equals(typeVariable2.getName())) {
                                    if (actualTypeArguments2 == null) {
                                        actualTypeArguments2 = parameterizedType.getActualTypeArguments();
                                    }
                                    Type type4 = actualTypeArguments[i6];
                                    Type type5 = actualTypeArguments2[i7];
                                    if (type4 != type5) {
                                        actualTypeArguments[i6] = type5;
                                        z6 = true;
                                    }
                                }
                            }
                        }
                    }
                    if (z6) {
                        return new h(parameterizedType3.getOwnerType(), parameterizedType3.getRawType(), actualTypeArguments);
                    }
                }
            }
        }
        return type2;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0054  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:44:0x0070 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x007b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0082  */
    /* JADX WARN: Code duplicated, block: B:54:0x0088  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(d dVar) {
        Class<?> declaringClass;
        boolean z6;
        Class<?> cls;
        boolean z7;
        int i5 = dVar.d;
        Field field = dVar.c;
        Class<?> cls2 = dVar.e;
        int i6 = this.d;
        if (i6 < i5) {
            return -1;
        }
        if (i6 <= i5) {
            int iCompareTo = this.f7884a.compareTo(dVar.f7884a);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            Class<?> declaringClass2 = null;
            Field field2 = this.c;
            Method method = this.b;
            if (method != null) {
                declaringClass = method.getDeclaringClass();
            } else {
                declaringClass = field2 != null ? field2.getDeclaringClass() : null;
            }
            Method method2 = dVar.b;
            if (method2 != null) {
                declaringClass2 = method2.getDeclaringClass();
            } else if (field != null) {
                declaringClass2 = field.getDeclaringClass();
            }
            if (declaringClass == null || declaringClass2 == null || declaringClass == declaringClass2) {
                z6 = false;
                cls = this.e;
                if (field2 == null && field2.getType() == cls) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (field != null && field.getType() == cls2) {
                    z6 = true;
                }
                if (z7 || z6) {
                    if (!z6 && !z7) {
                        return -1;
                    }
                    if (cls2.isPrimitive() || cls.isPrimitive()) {
                        if (!cls.isPrimitive() && !cls2.isPrimitive()) {
                            return -1;
                        }
                        if (cls2.getName().startsWith("java.") || cls.getName().startsWith("java.")) {
                            if (cls.getName().startsWith("java.") || cls2.getName().startsWith("java.")) {
                                return cls.getName().compareTo(cls2.getName());
                            }
                            return -1;
                        }
                    }
                }
            } else {
                if (declaringClass.isAssignableFrom(declaringClass2)) {
                    return -1;
                }
                if (!declaringClass2.isAssignableFrom(declaringClass)) {
                    z6 = false;
                    cls = this.e;
                    if (field2 == null) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    if (field != null) {
                        z6 = true;
                    }
                    if (z7) {
                        if (!z6) {
                        }
                        if (cls2.isPrimitive()) {
                            if (!cls.isPrimitive()) {
                            }
                            if (cls2.getName().startsWith("java.")) {
                            }
                            if (cls.getName().startsWith("java.")) {
                            }
                            return cls.getName().compareTo(cls2.getName());
                        }
                        if (!cls.isPrimitive()) {
                        }
                        if (cls2.getName().startsWith("java.")) {
                        }
                        if (cls.getName().startsWith("java.")) {
                        }
                        return cls.getName().compareTo(cls2.getName());
                    }
                    if (!z6) {
                    }
                    if (cls2.isPrimitive()) {
                        if (!cls.isPrimitive()) {
                        }
                        if (cls2.getName().startsWith("java.")) {
                        }
                        if (cls.getName().startsWith("java.")) {
                        }
                        return cls.getName().compareTo(cls2.getName());
                    }
                    if (!cls.isPrimitive()) {
                    }
                    if (cls2.getName().startsWith("java.")) {
                    }
                    if (cls.getName().startsWith("java.")) {
                    }
                    return cls.getName().compareTo(cls2.getName());
                }
            }
        }
        return 1;
    }

    public final char[] b() {
        String str = this.f7884a;
        int length = str.length();
        char[] cArr = new char[length + 3];
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = Chars.DQUOTE;
        cArr[length + 1] = Chars.DQUOTE;
        cArr[length + 2] = NameUtil.COLON;
        return cArr;
    }

    public final b c() {
        return null;
    }

    public Object get(Object obj) {
        Method method = this.b;
        return method != null ? method.invoke(obj, null) : this.c.get(obj);
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.b;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.c.set(obj, obj2);
        }
    }

    public void setAccessible() {
        Method method = this.b;
        if (method != null) {
            j.C(method);
        } else {
            j.C(this.c);
        }
    }

    public final String toString() {
        return this.f7884a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    public d(String str, Method method, Field field, Class cls, Type type, int i5, int i6, int i7, b bVar, b bVar2, String str2) {
        String str3;
        boolean zJsonDirect;
        Type genericType;
        boolean zIsFinal;
        Class<?> clsQ;
        boolean z6;
        this.d = 0;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        this.f7884a = str;
        this.b = method;
        this.c = field;
        this.d = i5;
        this.f7888i = i6;
        this.f7889j = i7;
        boolean z7 = true;
        if (field != null) {
            int modifiers = field.getModifiers();
            int i8 = modifiers & 1;
            if (Modifier.isTransient(modifiers)) {
                z6 = true;
            } else {
                if (method == null) {
                    boolean z8 = j.f7921a;
                } else {
                    if (!j.f7926j) {
                        try {
                            j.f7927k = Class.forName("java.beans.Transient");
                        } catch (Exception unused) {
                        } finally {
                            j.f7926j = true;
                        }
                    }
                    Class cls2 = j.f7927k;
                    if (cls2 != null && method.getAnnotation(cls2) != null) {
                        z6 = true;
                    }
                }
                z6 = false;
            }
            this.f7891l = z6;
        } else {
            this.f7891l = false;
        }
        if (str2 != null && str2.length() > 0) {
            this.f7890k = str2;
        } else {
            this.f7890k = "";
        }
        b bVarC = c();
        Type type2 = null;
        if (bVarC != null) {
            str3 = bVarC.format();
            str3 = str3.trim().length() == 0 ? null : str3;
            zJsonDirect = bVarC.jsonDirect();
            this.f7895p = bVarC.unwrapped();
            this.f7897r = bVarC.alternateNames();
        } else {
            this.f7895p = false;
            this.f7897r = new String[0];
            str3 = null;
            zJsonDirect = false;
        }
        this.f7896q = str3;
        this.f7892m = b();
        if (method != null) {
            j.C(method);
        }
        if (field != null) {
            j.C(field);
        }
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                clsQ = parameterTypes[0];
                genericType = method.getGenericParameterTypes()[0];
                zIsFinal = false;
            } else {
                clsQ = method.getReturnType();
                genericType = method.getGenericReturnType();
                zIsFinal = true;
            }
            this.f7886g = method.getDeclaringClass();
        } else {
            Class<?> type3 = field.getType();
            genericType = field.getGenericType();
            this.f7886g = field.getDeclaringClass();
            zIsFinal = Modifier.isFinal(field.getModifiers());
            clsQ = type3;
        }
        this.f7887h = zIsFinal;
        this.f7894o = zJsonDirect && clsQ == String.class;
        if (clsQ == Object.class && (genericType instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) genericType;
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            cls.getGenericSuperclass();
            Class clsQ2 = cls;
            while (true) {
                Type genericSuperclass = clsQ2.getGenericSuperclass();
                if (genericSuperclass == null) {
                    break;
                }
                if (genericSuperclass instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                    Type rawType = parameterizedType.getRawType();
                    if (genericDeclaration.equals(rawType) || ((genericDeclaration instanceof Class) && (rawType instanceof Class) && ((Class) genericDeclaration).isAssignableFrom((Class) rawType))) {
                        TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        for (int i9 = 0; i9 < typeParameters.length; i9++) {
                            if (typeVariable.equals(typeParameters[i9])) {
                                type2 = actualTypeArguments[i9];
                                break;
                            }
                        }
                        break;
                    }
                }
                clsQ2 = j.q(genericSuperclass);
            }
            if (type2 != null) {
                this.e = j.q(type2);
                this.f7885f = type2;
                this.f7893n = clsQ.isEnum();
                return;
            }
        }
        if (!(genericType instanceof Class)) {
            Type typeD = d(type == null ? cls : type, cls, genericType);
            if (typeD != genericType && ((typeD instanceof ParameterizedType) || (typeD instanceof Class))) {
                clsQ = j.q(typeD);
            }
            genericType = typeD;
        }
        this.f7885f = genericType;
        this.e = clsQ;
        this.f7893n = clsQ.isEnum();
    }
}
