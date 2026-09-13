package cn.fly.tools.a;

import android.content.Context;
import android.os.Build;
import cn.fly.commons.m;
import cn.fly.commons.z;
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
public class d implements cn.fly.tools.a.a {
    @Override // cn.fly.tools.a.a
    public Class b(String str) {
        return Class.forName(str);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static long f1643a = 0;
        private static long b = 0;
        private static long c = 0;
        private static long d = 0;
        private static long e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static long f1644f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static long f1645g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static long f1646h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static long f1647i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static long f1648j = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static long f1649k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static boolean f1650l = false;

        private static synchronized void a(int i5) {
            z.a().a("usf", Integer.valueOf(i5)).h();
        }

        private static synchronized boolean b() {
            int iIntValue = ((Integer) z.a().b("usf", -1)).intValue();
            if (iIntValue == 1) {
                f.a("36u ckFe f", new String[0]);
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
                    f.a("36u ckHpCz " + str, new String[0]);
                    return false;
                }
                int length2 = b.g.class.getDeclaredFields().length;
                String str2 = str + "|f" + length2;
                if (length2 != 3) {
                    f.a("36u ckHpCz " + str2, new String[0]);
                    return false;
                }
                int length3 = b.C0029d.class.getDeclaredFields().length;
                String str3 = str2 + "|f" + length3;
                if (length3 != 2) {
                    f.a("36u ckHpCz " + str3, new String[0]);
                    return false;
                }
                int length4 = b.C0028b.class.getDeclaredFields().length;
                String str4 = str3 + "|f" + length4;
                if (length4 != 25) {
                    f.a("36u ckHpCz " + str4, new String[0]);
                    return false;
                }
                int length5 = b.a.class.getDeclaredFields().length;
                String str5 = str4 + "|f" + length5;
                if (length5 != 1) {
                    f.a("36u ckHpCz " + str5, new String[0]);
                    return false;
                }
                int length6 = b.c.class.getDeclaredFields().length;
                String str6 = str5 + "|f" + length6;
                if (length6 != 5) {
                    f.a("36u ckHpCz " + str6, new String[0]);
                    return false;
                }
                int length7 = b.h.class.getDeclaredFields().length;
                String str7 = str6 + "|f" + length7;
                if (length7 != 4) {
                    f.a("36u ckHpCz " + str7, new String[0]);
                    return false;
                }
                int length8 = b.i.class.getDeclaredMethods().length;
                String str8 = str7 + "|m" + length8;
                if (length8 < 2) {
                    f.a("36u ckHpCz " + str8, new String[0]);
                    return false;
                }
                int length9 = b.e.class.getDeclaredMethods().length;
                String str9 = str8 + "|m" + length9;
                if (length9 >= 1) {
                    return true;
                }
                f.a("36u ckHpCz " + str9, new String[0]);
                return false;
            } catch (Throwable th) {
                f.a(th);
                return false;
            }
        }

        public static synchronized boolean a() {
            f.a("36u ck", new String[0]);
            if (Build.VERSION.SDK_INT < 29) {
                return false;
            }
            if (c.a()) {
                if (!b() || !d()) {
                    return false;
                }
                try {
                    Field[] declaredFields = b.c.class.getDeclaredFields();
                    for (Field field : declaredFields) {
                        if (field.getType() == Long.TYPE) {
                            f1643a = c.a(field);
                            break;
                        }
                    }
                    if (a("", f1643a)) {
                        return false;
                    }
                    for (Field field2 : declaredFields) {
                        if (field2.getType() == b.C0028b.class) {
                            b = c.a(field2);
                            break;
                        }
                    }
                    if (a("", b)) {
                        return false;
                    }
                    for (Field field3 : b.f.class.getDeclaredFields()) {
                        if (field3.getType() == Long.TYPE) {
                            c = c.a(field3);
                            break;
                        }
                    }
                    if (a("", c)) {
                        return false;
                    }
                    for (Field field4 : b.g.class.getDeclaredFields()) {
                        if (field4.getType() == b.C0028b.class) {
                            d = c.a(field4);
                            break;
                        }
                    }
                    if (a("", d)) {
                        return false;
                    }
                    int i5 = 1;
                    for (Field field5 : b.C0028b.class.getDeclaredFields()) {
                        if (field5.getType() == Long.TYPE) {
                            if (i5 != 1) {
                                if (i5 == 2) {
                                    e = c.a(field5);
                                    break;
                                }
                            } else {
                                f1644f = c.a(field5);
                                i5++;
                            }
                        }
                    }
                    if (a("", f1644f)) {
                        return false;
                    }
                    if (a("", e)) {
                        return false;
                    }
                    for (Field field6 : b.C0029d.class.getDeclaredFields()) {
                        if (field6.getType() == Member.class) {
                            f1645g = c.a(field6);
                            break;
                        }
                    }
                    if (a("", f1645g)) {
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
                                    jA = c.a(MethodHandles.lookup().unreflect(method), c);
                                    break;
                                }
                            } else {
                                method.setAccessible(true);
                                jA2 = c.a(MethodHandles.lookup().unreflect(method), c);
                                i6++;
                            }
                        }
                    }
                    long j6 = jA - jA2;
                    f1646h = j6;
                    if (a("", j6)) {
                        return false;
                    }
                    long jA3 = (jA2 - c.a(b.i.class, e)) - f1646h;
                    f1647i = jA3;
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
                    long jA4 = c.a(methodHandleUnreflectGetter2, c);
                    long jA5 = c.a(methodHandleUnreflectGetter, c) - jA4;
                    f1648j = jA5;
                    if (a("", jA5)) {
                        return false;
                    }
                    long jA6 = jA4 - c.a(b.h.class, f1644f);
                    f1649k = jA6;
                    if (a("", jA6)) {
                        return false;
                    }
                    d.b();
                } catch (Throwable unused) {
                }
                c();
            }
            f1650l = true;
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
                if (f1650l && zB) {
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
                        long jA = c.a(cls, e);
                        if (jA != 0) {
                            int iA = c.a(jA);
                            for (int i6 = 0; i6 < iA; i6++) {
                                long j6 = (((long) i6) * f1646h) + jA + f1647i;
                                c.a(method, f1643a, j6);
                                if (m.a("006_kgfk[gYfk$k]ki").equals(method.getName())) {
                                    c.a(declaredConstructor, f1643a, j6);
                                    c.a(declaredConstructor, b, cls);
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
                throw new Throwable("x1 " + f1650l + "|" + zB);
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
                if (f1650l && zB) {
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
                        long jA = c.a(cls, e);
                        if (jA != 0) {
                            int iA = c.a(jA);
                            for (int i6 = 0; i6 < iA; i6++) {
                                c.a(method, f1643a, (((long) i6) * f1646h) + jA + f1647i);
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
                throw new Throwable("x2 " + f1650l + "|" + zB);
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
                if (f1650l && zB) {
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
                        long jA = c.a(cls, f1644f);
                        if (jA != 0) {
                            int iA = c.a(jA);
                            for (int i6 = 0; i6 < iA; i6++) {
                                c.a(methodHandleUnreflectGetter, c, (((long) i6) * f1648j) + jA + f1649k);
                                c.a(methodHandleUnreflectGetter, d, (Object) null);
                                try {
                                    MethodHandles.Lookup lookup = MethodHandles.lookup();
                                    Method method = lookup.getClass().getMethod(m.a("012)flJh7ffChfi)hnfkfl=hek"), MethodHandle.class);
                                    method.setAccessible(true);
                                    method.invoke(lookup, methodHandleUnreflectGetter);
                                } catch (Throwable unused) {
                                }
                                Field field2 = (Field) c.b(c.b(methodHandleUnreflectGetter, d), f1645g);
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
                throw new Throwable("x3 " + f1650l + "|" + zB);
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
                f.a("36u ckZr " + str2.substring(0, str2.length() - 1), new String[0]);
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
            String str = "" + fVar.c + fVar.d + fVar.e + TarConstants.VERSION_POSIX;
            b.g gVar = new b.g();
            String str2 = str + "" + gVar.d + gVar.c + 0L;
            b.C0029d c0029d = new b.C0029d();
            String str3 = str2 + "" + c0029d.b + c0029d.f1674a;
            b.C0028b c0028b = new b.C0028b();
            String str4 = (str3 + "" + c0028b.f1652a + c0028b.b + c0028b.c + c0028b.d + Arrays.toString(c0028b.e) + c0028b.f1653f + c0028b.f1654g + c0028b.f1655h + c0028b.f1657j + c0028b.f1656i + c0028b.f1658k + c0028b.f1659l + c0028b.f1660m + c0028b.f1661n + c0028b.f1662o + c0028b.f1663p + c0028b.f1664q + c0028b.f1665r + c0028b.f1666s + c0028b.f1667t + c0028b.f1668u + c0028b.f1669v + c0028b.f1670w + ((int) c0028b.f1671x) + ((int) c0028b.f1672y)) + "" + new b.a().f1651a;
            b.c cVar = new b.c();
            String str5 = str4 + "" + cVar.f1673a + cVar.b + Arrays.toString(cVar.c) + cVar.d + cVar.e;
            b.h hVar = new b.h();
            String str6 = str5 + "" + hVar.c + hVar.d + b.h.f1676a + b.h.b;
            new b.i();
            b.i.c();
            b.i.d();
            b.e.b(new Object[0]);
            new b.e(new Object[]{str6});
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

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Object f1677a;
        private static Method b;

        public static boolean a() throws IllegalAccessException, InvocationTargetException {
            Object objInvoke = a(Class.forName(m.a("015 hkfiMgWfnfhfkhk>e6fngm,g)hk5fSghNh")), m.a("009$gl(hk9gmOg0hkEfIghZh"), new Class[0]).invoke(null, null);
            f1677a = objInvoke;
            return objInvoke != null;
        }

        public static Object b(Object obj, long j6) {
            return a(f1677a.getClass(), m.a("009+gl$hkCijhhjiKhek"), Object.class, Long.TYPE).invoke(f1677a, obj, Long.valueOf(j6));
        }

        public static long a(Object obj, long j6) {
            return ((Long) a(f1677a.getClass(), m.a("007]glChk6hgfm=gBgl"), Object.class, Long.TYPE).invoke(f1677a, obj, Long.valueOf(j6))).longValue();
        }

        public static void a(Object obj, long j6, long j7) throws IllegalAccessException, InvocationTargetException {
            Class<?> cls = f1677a.getClass();
            String strA = m.a("007lAfi]kXhgfmYg'gl");
            Class cls2 = Long.TYPE;
            a(cls, strA, Object.class, cls2, cls2).invoke(f1677a, obj, Long.valueOf(j6), Long.valueOf(j7));
        }

        public static void a(Object obj, long j6, Object obj2) throws IllegalAccessException, InvocationTargetException {
            a(f1677a.getClass(), m.a("009l1fiRkTijhhji]hek"), Object.class, Long.TYPE, Object.class).invoke(f1677a, obj, Long.valueOf(j6), obj2);
        }

        public static int a(long j6) {
            return ((Integer) a(f1677a.getClass(), m.a("0060glWhk'gg>gk"), Long.TYPE).invoke(f1677a, Long.valueOf(j6))).intValue();
        }

        public static long a(Field field) {
            return ((Long) a(f1677a.getClass(), m.a("017[fmhhji9hekZiefkBhi1feijghghhk0hk"), Field.class).invoke(f1677a, field)).longValue();
        }

        private static Method a(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
            try {
                if (b == null) {
                    b = Class.class.getDeclaredMethod(m.a("0175gl1hk7hnZheif0flOhIfeje$hkj6fmfe"), String.class, Class[].class);
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
            private boolean f1651a;
        }

        /* JADX INFO: renamed from: cn.fly.tools.a.d$b$b, reason: collision with other inner class name */
        public static final class C0028b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private transient ClassLoader f1652a;
            private transient Class<?> b;
            private transient Object c;
            private transient Object d;
            private transient Object[] e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private transient String f1653f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private transient Class<?> f1654g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private transient Object f1655h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private transient long f1656i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private transient long f1657j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private transient int f1658k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private transient int f1659l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private transient int f1660m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private transient int f1661n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private transient int f1662o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private volatile transient int f1663p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            private transient int f1664q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            private transient int f1665r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private transient int f1666s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            private transient int f1667t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            private transient int f1668u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            private transient int f1669v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            private transient int f1670w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            private transient short f1671x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            private transient short f1672y;
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private C0028b f1673a;
            private C0028b b;
            private Object[] c;
            private long d;
            private int e;
        }

        /* JADX INFO: renamed from: cn.fly.tools.a.d$b$d, reason: collision with other inner class name */
        public static final class C0029d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final f f1674a = null;
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
            private f d;
            private f e;
            private final MethodType c = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            protected final int f1675a = 0;
            protected final long b = 0;
        }

        public static final class g extends f {
            private final Field c = null;
            private final C0028b d = null;
            private final long e = 0;
        }

        public static class h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static int f1676a;
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
