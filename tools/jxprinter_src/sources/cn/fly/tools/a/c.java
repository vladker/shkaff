package cn.fly.tools.a;

import android.content.Context;
import cn.fly.commons.a.l;
import cn.fly.commons.z;
import cn.fly.tools.utils.DH;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: classes.dex */
public class c implements cn.fly.tools.a.a {
    @Override // cn.fly.tools.a.a
    public Class b(String str) {
        return Class.forName(str);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static long f1606a = 0;
        private static long b = 0;
        private static long c = 0;
        private static long d = 0;
        private static long e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static long f1607f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static long f1608g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static long f1609h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static long f1610i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static long f1611j = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static long f1612k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static long f1613l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static boolean f1614m = false;

        private static synchronized void a(int i5) {
            z.a().a("usf", Integer.valueOf(i5)).h();
        }

        private static synchronized boolean b() {
            int iIntValue = ((Integer) z.a().b("usf", -1)).intValue();
            if (iIntValue == 1) {
                f.a("3xu ckFe f", new String[0]);
                return false;
            }
            if (iIntValue != -1 && iIntValue != 0) {
                return false;
            }
            a(1);
            return true;
        }

        private static synchronized void c() {
            a(0);
        }

        private static boolean d() {
            try {
                int length = b.f.class.getDeclaredFields().length;
                String str = "f" + length;
                if (length != 5) {
                    f.a("3xu ckHpCz " + str, new String[0]);
                    return false;
                }
                int length2 = b.g.class.getDeclaredFields().length;
                String str2 = str + "|f" + length2;
                if (length2 != 1) {
                    f.a("3xu ckHpCz " + str2, new String[0]);
                    return false;
                }
                int length3 = b.d.class.getDeclaredFields().length;
                String str3 = str2 + "|f" + length3;
                if (length3 != 2) {
                    f.a("3xu ckHpCz " + str3, new String[0]);
                    return false;
                }
                int length4 = b.C0025b.class.getDeclaredFields().length;
                String str4 = str3 + "|f" + length4;
                if (length4 != 26) {
                    f.a("3xu ckHpCz " + str4, new String[0]);
                    return false;
                }
                int length5 = b.a.class.getDeclaredFields().length;
                String str5 = str4 + "|f" + length5;
                if (length5 != 1) {
                    f.a("3xu ckHpCz " + str5, new String[0]);
                    return false;
                }
                int length6 = b.C0026c.class.getDeclaredFields().length;
                String str6 = str5 + "|f" + length6;
                if (length6 != 5) {
                    f.a("3xu ckHpCz " + str6, new String[0]);
                    return false;
                }
                int length7 = b.h.class.getDeclaredFields().length;
                String str7 = str6 + "|f" + length7;
                if (length7 != 4) {
                    f.a("3xu ckHpCz " + str7, new String[0]);
                    return false;
                }
                int length8 = b.i.class.getDeclaredMethods().length;
                String str8 = str7 + "|m" + length8;
                if (length8 < 2) {
                    f.a("3xu ckHpCz " + str8, new String[0]);
                    return false;
                }
                int length9 = b.e.class.getDeclaredMethods().length;
                String str9 = str8 + "|m" + length9;
                if (length9 >= 1) {
                    return true;
                }
                f.a("3xu ckHpCz " + str9, new String[0]);
                return false;
            } catch (Throwable th) {
                f.a(th);
                return false;
            }
        }

        public static synchronized boolean a() {
            f.a("3xu ck", new String[0]);
            if (DH.SyncMtd.getOSVersionIntForFly() < 29) {
                return false;
            }
            if (C0027c.a()) {
                if (!b() || !d()) {
                    return false;
                }
                try {
                    Field[] declaredFields = b.C0026c.class.getDeclaredFields();
                    for (Field field : declaredFields) {
                        if (field.getType() == Long.TYPE) {
                            f1606a = C0027c.a(field);
                            break;
                        }
                    }
                    if (a("", f1606a)) {
                        return false;
                    }
                    for (Field field2 : declaredFields) {
                        if (field2.getType() == b.C0025b.class) {
                            b = C0027c.a(field2);
                            break;
                        }
                    }
                    if (a("", b)) {
                        return false;
                    }
                    for (Field field3 : b.f.class.getDeclaredFields()) {
                        if (field3.getType() == Long.TYPE) {
                            c = C0027c.a(field3);
                            break;
                        }
                    }
                    if (a("", c)) {
                        return false;
                    }
                    for (Field field4 : b.g.class.getDeclaredFields()) {
                        if (field4.getType() == b.C0025b.class) {
                            d = C0027c.a(field4);
                            break;
                        }
                    }
                    if (a("", d)) {
                        return false;
                    }
                    int i5 = 1;
                    for (Field field5 : b.C0025b.class.getDeclaredFields()) {
                        if (field5.getType() == Long.TYPE) {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 == 3) {
                                        f1608g = C0027c.a(field5);
                                        break;
                                    }
                                } else {
                                    e = C0027c.a(field5);
                                }
                            } else {
                                f1607f = C0027c.a(field5);
                            }
                            i5++;
                        }
                    }
                    if (a("", f1607f)) {
                        return false;
                    }
                    if (a("", e)) {
                        return false;
                    }
                    if (a("", f1608g)) {
                        return false;
                    }
                    for (Field field6 : b.d.class.getDeclaredFields()) {
                        if (field6.getType() == Member.class) {
                            f1609h = C0027c.a(field6);
                            break;
                        }
                    }
                    if (a("", f1609h)) {
                        return false;
                    }
                    long jA = 0;
                    int i6 = 1;
                    long jA2 = 0;
                    for (Method method : b.i.class.getDeclaredMethods()) {
                        if (method.getReturnType() == Void.TYPE) {
                            if (i6 != 1) {
                                if (i6 == 2) {
                                    method.setAccessible(true);
                                    jA = C0027c.a(MethodHandles.lookup().unreflect(method), c);
                                    break;
                                }
                            } else {
                                method.setAccessible(true);
                                jA2 = C0027c.a(MethodHandles.lookup().unreflect(method), c);
                                i6++;
                            }
                        }
                    }
                    long j6 = jA - jA2;
                    f1610i = j6;
                    if (a("", j6)) {
                        return false;
                    }
                    long jA3 = (jA2 - C0027c.a(b.i.class, e)) - f1610i;
                    f1611j = jA3;
                    if (a("", jA3)) {
                        return false;
                    }
                    MethodHandle methodHandleUnreflectGetter = null;
                    int i7 = 1;
                    MethodHandle methodHandleUnreflectGetter2 = null;
                    for (Field field7 : b.h.class.getDeclaredFields()) {
                        if (field7.getType() == Integer.TYPE) {
                            if (i7 != 1) {
                                if (i7 == 2) {
                                    field7.setAccessible(true);
                                    methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(field7);
                                    break;
                                }
                            } else {
                                field7.setAccessible(true);
                                methodHandleUnreflectGetter2 = MethodHandles.lookup().unreflectGetter(field7);
                                i7++;
                            }
                        }
                    }
                    long jA4 = C0027c.a(methodHandleUnreflectGetter2, c);
                    long jA5 = C0027c.a(methodHandleUnreflectGetter, c) - jA4;
                    f1612k = jA5;
                    if (a("", jA5)) {
                        return false;
                    }
                    long jA6 = jA4 - C0027c.a(b.h.class, f1607f);
                    f1613l = jA6;
                    if (a("", jA6)) {
                        return false;
                    }
                    c.b();
                } catch (Throwable unused) {
                }
                c();
            }
            f1614m = true;
            return true;
        }

        public static synchronized <T> T a(String str, Object... objArr) {
            return (T) a(Class.forName(str), objArr);
        }

        public static synchronized <T> T a(Class<?> cls, Object... objArr) {
            Method method;
            T t6;
            try {
                boolean zB = b();
                if (f1614m && zB) {
                    Method[] declaredMethods = b.e.class.getDeclaredMethods();
                    int length = declaredMethods.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            method = null;
                            break;
                        }
                        method = declaredMethods[i5];
                        if (method.getReturnType() == Object.class) {
                            break;
                        }
                        i5++;
                    }
                    if (method != null) {
                        Constructor declaredConstructor = b.e.class.getDeclaredConstructor(Object[].class);
                        declaredConstructor.setAccessible(true);
                        long jA = C0027c.a(cls, e);
                        if (jA != 0) {
                            int iA = C0027c.a(jA);
                            for (int i6 = 0; i6 < iA; i6++) {
                                long j6 = (((long) i6) * f1610i) + jA + f1611j;
                                C0027c.a(method, f1606a, j6);
                                if (l.a("006Jjfej.fCej;jKjh").equals(method.getName())) {
                                    C0027c.a(declaredConstructor, f1606a, j6);
                                    C0027c.a(declaredConstructor, b, cls);
                                    if (a(declaredConstructor.getParameterTypes(), objArr)) {
                                        try {
                                            t6 = (T) declaredConstructor.newInstance(objArr);
                                            c();
                                        } catch (Throwable unused) {
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                        c();
                        throw new NoSuchMethodException("n1");
                    }
                    throw new Throwable("x22");
                }
                throw new Throwable("x1 " + f1614m + "|" + zB);
            } catch (Throwable th) {
                throw th;
            }
            return t6;
        }

        public static synchronized <T> T a(String str, Object obj, String str2, Object... objArr) {
            return (T) a(Class.forName(str), obj, str2, objArr);
        }

        public static synchronized <T> T a(Class<?> cls, Object obj, String str, Object... objArr) {
            Method method;
            T t6;
            try {
                boolean zB = b();
                if (f1614m && zB) {
                    Method[] declaredMethods = b.e.class.getDeclaredMethods();
                    int length = declaredMethods.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            method = null;
                            break;
                        }
                        method = declaredMethods[i5];
                        if (method.getReturnType() == Object.class) {
                            break;
                        }
                        i5++;
                    }
                    if (method != null) {
                        method.setAccessible(true);
                        long jA = C0027c.a(cls, e);
                        if (jA != 0) {
                            int iA = C0027c.a(jA);
                            for (int i6 = 0; i6 < iA; i6++) {
                                C0027c.a(method, f1606a, (((long) i6) * f1610i) + jA + f1611j);
                                if (str.equals(method.getName()) && a(method.getParameterTypes(), objArr)) {
                                    try {
                                        t6 = (T) method.invoke(obj, objArr);
                                        c();
                                    } catch (Throwable unused) {
                                        continue;
                                    }
                                }
                            }
                        }
                        c();
                        throw new NoSuchMethodException("n2");
                    }
                    throw new Throwable("x22");
                }
                throw new Throwable("x2 " + f1614m + "|" + zB);
            } catch (Throwable th) {
                throw th;
            }
            return t6;
        }

        public static synchronized <T> T a(String str, String str2, Object obj) {
            return (T) a(Class.forName(str), str2, obj);
        }

        public static synchronized <T> T a(Class<?> cls, String str, Object obj) {
            MethodHandle methodHandleUnreflectGetter;
            T t6;
            try {
                boolean zB = b();
                if (f1614m && zB) {
                    if (DH.SyncMtd.getOSVersionIntForFly() >= 26) {
                        Field[] declaredFields = b.h.class.getDeclaredFields();
                        int length = declaredFields.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                methodHandleUnreflectGetter = null;
                                break;
                            }
                            Field field = declaredFields[i5];
                            if (field.getType() == Integer.TYPE && (obj != null || (field.getModifiers() & 8) != 0)) {
                                field.setAccessible(true);
                                methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(field);
                                break;
                            }
                            i5++;
                        }
                        if (methodHandleUnreflectGetter != null) {
                            long jA = C0027c.a(cls, obj == null ? f1608g : f1607f);
                            if (jA != 0) {
                                int iA = C0027c.a(jA);
                                for (int i6 = 0; i6 < iA; i6++) {
                                    C0027c.a(methodHandleUnreflectGetter, c, (((long) i6) * f1612k) + jA + f1613l);
                                    C0027c.a(methodHandleUnreflectGetter, d, (Object) null);
                                    try {
                                        MethodHandles.Lookup lookup = MethodHandles.lookup();
                                        Method method = lookup.getClass().getMethod(l.a("0127ek0g=ee@gehNgmejek$gdj"), MethodHandle.class);
                                        method.setAccessible(true);
                                        method.invoke(lookup, methodHandleUnreflectGetter);
                                    } catch (Throwable unused) {
                                    }
                                    Field field2 = (Field) C0027c.b(C0027c.b(methodHandleUnreflectGetter, d), f1609h);
                                    if (field2.getName().equals(str)) {
                                        field2.setAccessible(true);
                                        try {
                                            t6 = (T) field2.get(obj);
                                            c();
                                        } catch (Throwable unused2) {
                                            continue;
                                        }
                                    }
                                }
                            }
                            c();
                            throw new NoSuchMethodException("n3");
                        }
                        throw new Throwable("x34");
                    }
                    throw new Throwable("x33");
                }
                throw new Throwable("x3 " + f1614m + "|" + zB);
            } catch (Throwable th) {
                throw th;
            }
            return t6;
        }

        private static boolean a(String str, long j6) {
            if (j6 != 0) {
                return false;
            }
            try {
                String str2 = str + j6 + "|";
                f.a("3xu ckZr " + str2.substring(0, str2.length() - 1), new String[0]);
            } catch (Throwable unused) {
            }
            return true;
        }

        private static boolean a(Class<?>[] clsArr, Object[] objArr) {
            if ((clsArr != null && clsArr.length != 0) || (objArr != null && objArr.length != 0)) {
                if (clsArr.length != objArr.length) {
                    return false;
                }
                for (int i5 = 0; i5 < clsArr.length; i5++) {
                    if (clsArr[i5].isPrimitive()) {
                        Class<?> cls = clsArr[i5];
                        if (cls == Integer.TYPE && !(objArr[i5] instanceof Integer)) {
                            return false;
                        }
                        if (cls == Byte.TYPE && !(objArr[i5] instanceof Byte)) {
                            return false;
                        }
                        if (cls == Character.TYPE && !(objArr[i5] instanceof Character)) {
                            return false;
                        }
                        if (cls == Boolean.TYPE && !(objArr[i5] instanceof Boolean)) {
                            return false;
                        }
                        if (cls == Double.TYPE && !(objArr[i5] instanceof Double)) {
                            return false;
                        }
                        if (cls == Float.TYPE && !(objArr[i5] instanceof Float)) {
                            return false;
                        }
                        if (cls == Long.TYPE && !(objArr[i5] instanceof Long)) {
                            return false;
                        }
                        if (cls == Short.TYPE && !(objArr[i5] instanceof Short)) {
                            return false;
                        }
                    } else {
                        Object obj = objArr[i5];
                        if (obj != null && !clsArr[i5].isInstance(obj)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        try {
            b.f fVar = new b.f();
            String str = ("" + fVar.c + fVar.d + fVar.e + TarConstants.VERSION_POSIX) + "" + new b.g().c;
            b.d dVar = new b.d();
            String str2 = str + "" + dVar.b + dVar.f1639a;
            b.C0025b c0025b = new b.C0025b();
            String str3 = (str2 + "" + c0025b.f1616a + c0025b.b + c0025b.c + c0025b.d + Arrays.toString(c0025b.e) + c0025b.f1617f + c0025b.f1618g + c0025b.f1619h + c0025b.f1620i + c0025b.f1621j + c0025b.f1622k + c0025b.f1623l + c0025b.f1624m + c0025b.f1625n + c0025b.f1626o + c0025b.f1627p + c0025b.f1628q + c0025b.f1629r + c0025b.f1630s + c0025b.f1631t + c0025b.f1632u + c0025b.f1633v + c0025b.f1634w + c0025b.f1635x + ((int) c0025b.f1636y) + ((int) c0025b.f1637z)) + "" + new b.a().f1615a;
            b.C0026c c0026c = new b.C0026c();
            String str4 = str3 + "" + c0026c.f1638a + c0026c.b + Arrays.toString(c0026c.c) + c0026c.d + c0026c.e;
            b.h hVar = new b.h();
            String str5 = str4 + "" + hVar.c + hVar.d + b.h.f1641a + b.h.b;
            new b.i();
            b.i.c();
            b.i.d();
            b.e.b(new Object[0]);
            new b.e(new Object[]{str5});
        } catch (Throwable unused) {
        }
    }

    public boolean a(Context context) {
        try {
            return a.a();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: cn.fly.tools.a.c$c, reason: collision with other inner class name */
    public static class C0027c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Object f1642a;
        private static Method b;

        public static boolean a() throws IllegalAccessException, InvocationTargetException {
            Object objInvoke = a(Class.forName(l.a("015QgjehCfWemegejgj^dIemfl6f_gjLe+fgMg")), l.a("0097fkUgjJfl.f%gjYeIfg6g"), new Class[0]).invoke(null, null);
            f1642a = objInvoke;
            return objInvoke != null;
        }

        public static Object b(Object obj, long j6) {
            return a(f1642a.getClass(), l.a("009JfkOgjChiggih gdj"), Object.class, Long.TYPE).invoke(f1642a, obj, Long.valueOf(j6));
        }

        public static long a(Object obj, long j6) {
            return ((Long) a(f1642a.getClass(), l.a("007Gfk6gjJgfelIfUfk"), Object.class, Long.TYPE).invoke(f1642a, obj, Long.valueOf(j6))).longValue();
        }

        public static void a(Object obj, long j6, long j7) throws IllegalAccessException, InvocationTargetException {
            Class<?> cls = f1642a.getClass();
            String strA = l.a("007kMehTjHgfel>fFfk");
            Class cls2 = Long.TYPE;
            a(cls, strA, Object.class, cls2, cls2).invoke(f1642a, obj, Long.valueOf(j6), Long.valueOf(j7));
        }

        public static void a(Object obj, long j6, Object obj2) throws IllegalAccessException, InvocationTargetException {
            a(f1642a.getClass(), l.a("009k_eh2jKhiggihWgdj"), Object.class, Long.TYPE, Object.class).invoke(f1642a, obj, Long.valueOf(j6), obj2);
        }

        public static int a(long j6) {
            return ((Integer) a(f1642a.getClass(), l.a("006]fkFgjNffPfj"), Long.TYPE).invoke(f1642a, Long.valueOf(j6))).intValue();
        }

        public static long a(Field field) {
            return ((Long) a(f1642a.getClass(), l.a("017:elggih:gdj,hdej,gh]edhifgfggjNgj"), Field.class).invoke(f1642a, field)).longValue();
        }

        private static Method a(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
            try {
                if (b == null) {
                    b = Class.class.getDeclaredMethod(l.a("017!fk%gj'gm*gdhe>ek4gWedid2gji6eled"), String.class, Class[].class);
                }
                Method method = (Method) b.invoke(cls, str, clsArr);
                method.setAccessible(true);
                return method;
            } catch (Throwable unused) {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
        }
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr, Class<?> cls2) {
        return (T) a.a((Class<?>) cls, obj, str, objArr);
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr, Class<?> cls) {
        return (T) a.a(str, obj, str2, objArr);
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str) {
        return (T) a.a(str, new Object[0]);
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str, String str2, Object obj, Class<?> cls) {
        return (T) a.a(str, str2, obj);
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str, Class[] clsArr, Object[] objArr) {
        return (T) a.a(str, objArr);
    }

    public static class b {

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f1615a;
        }

        /* JADX INFO: renamed from: cn.fly.tools.a.c$b$b, reason: collision with other inner class name */
        public static final class C0025b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private transient ClassLoader f1616a;
            private transient Class<?> b;
            private transient Object c;
            private transient Object d;
            private transient Object[] e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private transient String f1617f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private transient Class<?> f1618g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private transient Object f1619h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private transient long f1620i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private transient long f1621j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private transient long f1622k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private transient int f1623l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private transient int f1624m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private transient int f1625n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private transient int f1626o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private transient int f1627p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            private volatile transient int f1628q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            private transient int f1629r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private transient int f1630s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            private transient int f1631t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            private transient int f1632u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            private transient int f1633v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            private transient int f1634w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            private transient int f1635x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            private transient short f1636y;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            private transient short f1637z;
        }

        /* JADX INFO: renamed from: cn.fly.tools.a.c$b$c, reason: collision with other inner class name */
        public static final class C0026c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private C0025b f1638a;
            private C0025b b;
            private Object[] c;
            private long d;
            private int e;
        }

        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final f f1639a = null;
            private final Member b = null;
        }

        public static class e {
            /* JADX INFO: Access modifiers changed from: private */
            public static Object b(Object... objArr) {
                throw new IllegalStateException("i1");
            }

            private e(Object... objArr) {
                throw new IllegalStateException("i2");
            }
        }

        public static class f {
            private MethodType d;
            private f e;
            private final MethodType c = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            protected final int f1640a = 0;
            protected final long b = 0;
        }

        public static final class g extends f {
            private final C0025b c = null;
        }

        public static class h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static int f1641a;
            private static int b;
            private int c;
            private int d;
        }

        public static class i {
            /* JADX INFO: Access modifiers changed from: private */
            public static void c() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static void d() {
            }
        }
    }
}
