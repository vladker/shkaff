package cn.fly.tools.utils;

import A3.AbstractC0157z;
import android.content.BroadcastReceiver;
import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.ProxyConfig;
import cn.fly.FlySDK;
import cn.fly.commons.a.l;
import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.PublicMemberKeeper;
import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: loaded from: classes.dex */
public class ReflectHelper implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<String> f1933a;
    private static HashMap<String, Class<?>> b;
    private static HashMap<Class<?>, String> c;
    private static LinkedHashMap<String, Method> d;
    private static LinkedHashMap<String, Constructor<?>> e;

    public interface a<ArgType, RetType> {
        RetType a(ArgType argtype);
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        f1933a = hashSet;
        hashSet.add(l.a("009)ihBeMee=eJemWhef+fk"));
        f1933a.add(l.a("007TihCe?ee,eVemejel"));
        f1933a.add(l.a("008'ih eGee0eDemJfVejel"));
        f1933a.add("java.net");
        f1933a.add(l.a("009<ihFe[ee%e emehIjUej7h"));
        HashMap<String, Class<?>> map = new HashMap<>();
        b = map;
        map.put(l.a("006 edelehgg$hg"), Double.TYPE);
        b.put(l.a("005Rfg(h2el!ej"), Float.TYPE);
        b.put(XmlErrorCodes.LONG, Long.TYPE);
        b.put(l.a("003_ej)fj"), Integer.TYPE);
        b.put("short", Short.TYPE);
        b.put("byte", Byte.TYPE);
        b.put(l.a("004die=ek"), Character.TYPE);
        b.put("boolean", Boolean.TYPE);
        b.put("Object", Object.class);
        b.put("String", String.class);
        b.put("Thread", Thread.class);
        b.put(l.a("008ZhkehZffe1ggOhg"), Runnable.class);
        b.put(l.a("006Afmfdgj>jg9eg"), System.class);
        b.put(l.a("006IedelehggHhg"), Double.class);
        b.put("Float", Float.class);
        b.put("Long", Long.class);
        b.put("Integer", Integer.class);
        b.put(l.a("005GfmLi1elekQj"), Short.class);
        b.put("Byte", Byte.class);
        b.put(l.a("009RfeJie!ek8edjg]ek"), Character.class);
        b.put("Boolean", Boolean.class);
        c = new HashMap<>();
        for (Map.Entry<String, Class<?>> entry : b.entrySet()) {
            c.put(entry.getValue(), entry.getKey());
        }
        d = new LinkedHashMap<String, Method>() { // from class: cn.fly.tools.utils.ReflectHelper.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Method> entry2) {
                return size() > 10;
            }
        };
        e = new LinkedHashMap<String, Constructor<?>>() { // from class: cn.fly.tools.utils.ReflectHelper.2
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Constructor<?>> entry2) {
                return size() > 10;
            }
        };
    }

    private static synchronized Class<?> a(String str) {
        Class<?> cls;
        cls = b.get(str);
        if (cls == null) {
            Iterator<String> it = f1933a.iterator();
            while (it.hasNext()) {
                try {
                    importClass(it.next() + Consts.DOT + str);
                } catch (Throwable unused) {
                }
                cls = b.get(str);
                if (cls != null) {
                    break;
                }
            }
        }
        return cls;
    }

    private static boolean b(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length - clsArr2.length == 1) {
            for (int i5 = 0; i5 < clsArr2.length; i5++) {
                Class<?> cls = clsArr2[i5];
                if (cls == null || a(clsArr[i5], cls) || clsArr[i5].isAssignableFrom(clsArr2[i5])) {
                }
            }
            if (clsArr[clsArr.length - 1].isArray()) {
                return true;
            }
        }
        return false;
    }

    public static Object createProxy(HashMap<String, a<Object, Object[]>> map, Class<?>... clsArr) {
        HashMap map2 = new HashMap();
        for (final Map.Entry<String, a<Object, Object[]>> entry : map.entrySet()) {
            map2.put(entry.getKey(), new a<Object[], Object>() { // from class: cn.fly.tools.utils.ReflectHelper.3
                @Override // cn.fly.tools.utils.ReflectHelper.a
                public Object a(Object[] objArr) {
                    return ((Object[]) ((a) entry.getValue()).a(objArr))[0];
                }
            });
        }
        return createProxy((Map<String, a<Object[], Object>>) map2, clsArr);
    }

    public static Class<?> getClass(String str) {
        Class<?> clsA = a(str);
        if (clsA != null) {
            return clsA;
        }
        try {
            clsA = Class.forName(str);
            b.put(str, clsA);
            return clsA;
        } catch (Throwable unused) {
            return clsA;
        }
    }

    public static <T> T getInstanceField(Object obj, String str, T t6) {
        try {
            return (T) getInstanceField(obj, str);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return t6;
        }
    }

    public static String getName(Class<?> cls) {
        String simpleName = c.get(cls);
        if (simpleName == null) {
            simpleName = cls.getSimpleName();
            if (b.containsKey(simpleName)) {
                c.remove(b.get(simpleName));
            }
            b.put(simpleName, cls);
            c.put(cls, simpleName);
        }
        return simpleName;
    }

    public static <T> T getStaticField(String str, String str2, T t6) {
        try {
            getStaticField(str, str2);
            return t6;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return t6;
        }
    }

    public static String importClass(String str) {
        return importClass(null, str);
    }

    public static String importClassNoThrow(String str, String str2) {
        try {
            return importClass(str);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return str2;
        }
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr, T t6) {
        try {
            return (T) invokeInstanceMethod(obj, str, objArr, clsArr);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return t6;
        }
    }

    public static <T> T invokeInstanceMethodNoThrow(Object obj, String str, T t6, Object... objArr) {
        try {
            return (T) invokeInstanceMethod(obj, str, objArr);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return t6;
        }
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr, T t6) {
        try {
            invokeStaticMethod(str, str2, objArr, clsArr);
            return t6;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return t6;
        }
    }

    public static <T> T invokeStaticMethodNoThrow(String str, String str2, T t6, Object... objArr) {
        try {
            return (T) invokeStaticMethod(str, str2, objArr);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return t6;
        }
    }

    public static Object newInstance(String str, Object... objArr) throws Throwable {
        try {
            return a(str, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable(AbstractC0157z.o("className: ", str, ", methodName: <init>"), th);
        }
    }

    public static void setInstanceField(Object obj, String str, Object obj2) throws Throwable {
        try {
            a(obj, str, obj2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2), th);
        }
    }

    public static void setStaticField(String str, String str2, Object obj) throws Throwable {
        try {
            a(str, str2, obj);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            StringBuilder sbU = androidx.collection.a.u("className: ", str, ", fieldName: ", str2, ", value: ");
            sbU.append(String.valueOf(obj));
            throw new Throwable(sbU.toString(), th);
        }
    }

    public static synchronized String importClass(String str, String str2) {
        if (str2.endsWith(".*")) {
            f1933a.add(str2.substring(0, str2.length() - 2));
            return ProxyConfig.MATCH_ALL_SCHEMES;
        }
        Class<?> cls = Class.forName(str2);
        if (str == null) {
            str = cls.getSimpleName();
        }
        if (b.containsKey(str)) {
            c.remove(b.get(str));
        }
        b.put(str, cls);
        c.put(cls, str);
        return str;
    }

    public static <T> T getInstanceField(Object obj, String str) throws Throwable {
        try {
            return (T) a(obj, str);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str, th);
        }
    }

    public static <T> T getStaticField(String str, String str2) throws Throwable {
        try {
            return (T) a(str, str2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable(androidx.exifinterface.media.a.m("className: ", str, ", fieldName: ", str2), th);
        }
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        return (T) a(null, obj, str, objArr, clsArr);
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr) {
        return (T) a(str, null, str2, objArr, clsArr);
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) throws Throwable {
        try {
            return (T) a(null, obj, str, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", methodName: " + str, th);
        }
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object... objArr) throws Throwable {
        try {
            return (T) a(str, null, str2, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable(androidx.exifinterface.media.a.m("className: ", str, ", methodName: ", str2), th);
        }
    }

    public static Object createProxy(final Map<String, a<Object[], Object>> map, Class<?>... clsArr) {
        if (clsArr.length == 0) {
            return null;
        }
        return Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, new InvocationHandler() { // from class: cn.fly.tools.utils.ReflectHelper.4
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                a aVar = (a) map.get(method.getName());
                if (aVar != null) {
                    return aVar.a(objArr);
                }
                return null;
            }
        });
    }

    private static Class<?>[] a(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i5 = 0; i5 < objArr.length; i5++) {
            Object obj = objArr[i5];
            if (obj instanceof BroadcastReceiver) {
                clsArr[i5] = BroadcastReceiver.class;
            } else {
                clsArr[i5] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    private static Object b(String str, Object... objArr) throws NoSuchMethodException {
        Class<?> clsA;
        String strSubstring = str;
        int i5 = 0;
        while (strSubstring.startsWith("[")) {
            i5++;
            strSubstring = strSubstring.substring(1);
        }
        int[] iArr = null;
        if (i5 == objArr.length) {
            int[] iArr2 = new int[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                try {
                    iArr2[i6] = Integer.parseInt(String.valueOf(objArr[i6]));
                } catch (Throwable unused) {
                }
            }
            iArr = iArr2;
        }
        if (iArr != null) {
            if ("B".equals(strSubstring)) {
                clsA = Byte.TYPE;
            } else if (ExifInterface.LATITUDE_SOUTH.equals(strSubstring)) {
                clsA = Short.TYPE;
            } else if ("I".equals(strSubstring)) {
                clsA = Integer.TYPE;
            } else if ("J".equals(strSubstring)) {
                clsA = Long.TYPE;
            } else if ("F".equals(strSubstring)) {
                clsA = Float.TYPE;
            } else if ("D".equals(strSubstring)) {
                clsA = Double.TYPE;
            } else if ("Z".equals(strSubstring)) {
                clsA = Boolean.TYPE;
            } else if ("C".equals(strSubstring)) {
                clsA = Character.TYPE;
            } else {
                clsA = a(strSubstring);
            }
            if (clsA != null) {
                return Array.newInstance(clsA, iArr);
            }
        }
        throw new NoSuchMethodException(AbstractC0157z.o("className: [", str, ", methodName: <init>"));
    }

    private static boolean a(Class<?> cls, Class<?> cls2) {
        if (cls == Byte.TYPE && cls2 == Byte.class) {
            return true;
        }
        if (cls == Short.TYPE && (cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        if (cls == Character.TYPE && (cls2 == Character.class || cls2 == Short.class || cls2 == Byte.class)) {
            return true;
        }
        if (cls == Integer.TYPE && (cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        if (cls == Long.TYPE && (cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        if (cls == Float.TYPE && (cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        if (cls == Double.TYPE && (cls2 == Double.class || cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) {
            return true;
        }
        return cls == Boolean.TYPE && cls2 == Boolean.class;
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < clsArr2.length; i5++) {
            Class<?> cls = clsArr2[i5];
            if (cls != null && !a(clsArr[i5], cls) && !clsArr[i5].isAssignableFrom(clsArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    private static Object a(String str, Object... objArr) throws NoSuchMethodException {
        if (str.startsWith("[")) {
            return b(str, objArr);
        }
        Class<?> clsA = a(str);
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(clsA, sb, "#");
        sb.append(objArr.length);
        String string = sb.toString();
        Constructor<?> constructor = e.get(string);
        Class<?>[] clsArrA = a(objArr);
        if (constructor != null && a(constructor.getParameterTypes(), clsArrA)) {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        }
        Constructor<?>[] declaredConstructors = clsA.getDeclaredConstructors();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Constructor<?> constructor2 : declaredConstructors) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (a(parameterTypes, clsArrA)) {
                e.put(string, constructor2);
                constructor2.setAccessible(true);
                return constructor2.newInstance(objArr);
            }
            if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && clsArrA.length >= parameterTypes.length - 1) {
                arrayList.add(constructor2);
                arrayList2.add(parameterTypes);
            }
        }
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            Class[] clsArr = (Class[]) arrayList2.get(i5);
            Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
            if (b((Class<?>[]) clsArr, clsArrA)) {
                Object[] objArr2 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                objArr2[objArr.length] = Array.newInstance(componentType, 0);
                Constructor constructor3 = (Constructor) arrayList.get(i5);
                constructor3.setAccessible(true);
                return constructor3.newInstance(objArr);
            }
            int length = clsArr.length - 1;
            while (true) {
                if (length < clsArrA.length) {
                    if (!clsArrA[length].equals(componentType)) {
                        break;
                    }
                    length++;
                } else {
                    int length2 = (clsArrA.length - clsArr.length) + 1;
                    Object objNewInstance = Array.newInstance(componentType, length2);
                    for (int i6 = 0; i6 < length2; i6++) {
                        Array.set(objNewInstance, i6, objArr[(clsArr.length - 1) + i6]);
                    }
                    Object[] objArr3 = new Object[objArr.length + 1];
                    System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                    objArr3[objArr.length] = objNewInstance;
                    Constructor constructor4 = (Constructor) arrayList.get(i5);
                    constructor4.setAccessible(true);
                    return constructor4.newInstance(objArr);
                }
            }
        }
        throw new NoSuchMethodException(AbstractC0157z.o("className: ", str, ", methodName: <init>"));
    }

    private static Object b(Object obj, String str) throws NoSuchFieldException {
        int i5;
        int i6;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i6 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i6 = -1;
                }
                if (i6 != -1) {
                    return ((List) obj).get(i6);
                }
            }
        } else {
            if (l.a("006hgf@fkKji").equals(str)) {
                return Integer.valueOf(Array.getLength(obj));
            }
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i5 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused2) {
                    i5 = -1;
                }
                if (i5 != -1) {
                    return Array.get(obj, i5);
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static void b(Object obj, String str, Object obj2) throws NoSuchFieldException {
        int i5;
        int i6;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i6 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i6 = -1;
                }
                if (i6 != -1) {
                    ((List) obj).set(i6, obj2);
                    return;
                }
            }
        } else if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i5 = Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (Throwable unused2) {
                i5 = -1;
            }
            if (i5 != -1) {
                String name = obj.getClass().getName();
                while (name.startsWith("[")) {
                    name = name.substring(1);
                }
                Class<?> cls = obj2.getClass();
                if (!"B".equals(name)) {
                    Object objValueOf = null;
                    if (ExifInterface.LATITUDE_SOUTH.equals(name)) {
                        if (cls == Short.class) {
                            objValueOf = obj2;
                        } else if (cls == Byte.class) {
                            objValueOf = Short.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i5, objValueOf);
                            return;
                        }
                    } else if ("I".equals(name)) {
                        if (cls == Integer.class) {
                            objValueOf = obj2;
                        } else if (cls == Short.class) {
                            objValueOf = Integer.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            objValueOf = Integer.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i5, objValueOf);
                            return;
                        }
                    } else if ("J".equals(name)) {
                        if (cls == Long.class) {
                            objValueOf = obj2;
                        } else if (cls == Integer.class) {
                            objValueOf = Long.valueOf(((Integer) obj2).intValue());
                        } else if (cls == Short.class) {
                            objValueOf = Long.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            objValueOf = Long.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i5, objValueOf);
                            return;
                        }
                    } else if ("F".equals(name)) {
                        if (cls == Float.class) {
                            objValueOf = obj2;
                        } else if (cls == Long.class) {
                            objValueOf = Float.valueOf(((Long) obj2).longValue());
                        } else if (cls == Integer.class) {
                            objValueOf = Float.valueOf(((Integer) obj2).intValue());
                        } else if (cls == Short.class) {
                            objValueOf = Float.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            objValueOf = Float.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i5, objValueOf);
                            return;
                        }
                    } else if ("D".equals(name)) {
                        if (cls == Double.class) {
                            objValueOf = obj2;
                        } else if (cls == Float.class) {
                            objValueOf = Double.valueOf(((Float) obj2).floatValue());
                        } else if (cls == Long.class) {
                            objValueOf = Double.valueOf(((Long) obj2).longValue());
                        } else if (cls == Integer.class) {
                            objValueOf = Double.valueOf(((Integer) obj2).intValue());
                        } else if (cls == Short.class) {
                            objValueOf = Double.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            objValueOf = Double.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i5, objValueOf);
                            return;
                        }
                    } else if ("Z".equals(name)) {
                        if (cls == Boolean.class) {
                            Array.set(obj, i5, obj2);
                            return;
                        }
                    } else if ("C".equals(name)) {
                        if (cls == Character.class) {
                            Array.set(obj, i5, obj2);
                            return;
                        }
                    } else if (name.equals(cls.getName())) {
                        Array.set(obj, i5, obj2);
                        return;
                    }
                } else if (cls == Byte.class) {
                    Array.set(obj, i5, obj2);
                    return;
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    private static <T> T a(String str, Object obj, String str2, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> superclass;
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        if (obj == null) {
            superclass = a(str);
        } else {
            superclass = obj.getClass();
        }
        String str3 = superclass.getName() + "#" + str2 + "#" + objArr.length;
        Method method = d.get(str3);
        Class<?> cls = Void.TYPE;
        if (method != null) {
            method.setAccessible(true);
            if (method.getReturnType() == cls) {
                method.invoke(obj, objArr);
                return null;
            }
            return (T) method.invoke(obj, objArr);
        }
        while (superclass != null) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str2, clsArr);
                d.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() == cls) {
                    declaredMethod.invoke(obj, objArr);
                    return null;
                }
                return (T) declaredMethod.invoke(obj, objArr);
            } catch (InvocationTargetException e6) {
                throw e6;
            } catch (Throwable unused) {
                superclass = superclass.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder("className: ");
        Object obj2 = str;
        if (obj != null) {
            obj2 = obj.getClass();
        }
        sb.append(obj2);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new NoSuchMethodException(sb.toString());
    }

    private static <T> T a(String str, Object obj, String str2, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> superclass;
        Class<?>[] clsArrA;
        if (obj == null) {
            superclass = a(str);
        } else {
            superclass = obj.getClass();
        }
        boolean z6 = false;
        if (str2.equals(l.a("009Yfk$gj,id[gjiNeled")) && objArr != null && objArr.length == 2) {
            clsArrA = new Class[]{String.class, Class[].class};
            if (objArr[1] == String.class) {
                objArr[1] = new Class[]{String.class};
            }
        } else if (str2.equals("getDeviceId") && objArr != null && objArr.length == 1) {
            clsArrA = new Class[]{Integer.TYPE};
        } else if (str2.equals(l.a("006Vej:fMeeelfi?g")) && objArr != null && objArr.length == 2) {
            clsArrA = new Class[]{Object.class, Object[].class};
        } else {
            clsArrA = (str2.equals(l.a("013(gj*gjRgeEddg:gjgjejggYhg")) && objArr != null && objArr.length == 1) ? new Class[]{Boolean.TYPE} : a(objArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = clsArrA.length;
        for (int i5 = 0; i5 < length; i5++) {
            Class<?> cls = clsArrA[i5];
            stringBuffer.append(cls == null ? "" : cls.getName());
        }
        String str3 = superclass.getName() + "#" + str2 + "#" + objArr.length + stringBuffer.toString();
        Method method = d.get(str3);
        Class<?> cls2 = Void.TYPE;
        if (method != null) {
            boolean zIsStatic = Modifier.isStatic(method.getModifiers());
            if (obj == null) {
                z6 = zIsStatic;
            } else if (!zIsStatic) {
                z6 = true;
            }
            if (z6 && a(method.getParameterTypes(), clsArrA)) {
                method.setAccessible(true);
                if (method.getReturnType() == cls2) {
                    method.invoke(obj, objArr);
                    return null;
                }
                return (T) method.invoke(obj, objArr);
            }
        }
        while (superclass != null) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str2, clsArrA);
                d.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() == cls2) {
                    declaredMethod.invoke(obj, objArr);
                    return null;
                }
                return (T) declaredMethod.invoke(obj, objArr);
            } catch (InvocationTargetException e6) {
                throw e6;
            } catch (Throwable unused) {
                superclass = superclass.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder("className: ");
        Object obj2 = str;
        if (obj != null) {
            obj2 = obj.getClass();
        }
        sb.append(obj2);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new NoSuchMethodException(sb.toString());
    }

    private static <T> T a(String str, String str2) throws NoSuchFieldException {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (Class<?> clsA = a(str); clsA != null; clsA = clsA.getSuperclass()) {
            arrayList.add(clsA);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            try {
                declaredField = ((Class) obj).getDeclaredField(str2);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                return (T) declaredField.get(null);
            }
        }
        throw new NoSuchFieldException(androidx.exifinterface.media.a.m("className: ", str, ", fieldName: ", str2));
    }

    private static void a(String str, String str2, Object obj) throws Throwable {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (Class<?> clsA = a(str); clsA != null; clsA = clsA.getSuperclass()) {
            arrayList.add(clsA);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj2 = arrayList.get(i5);
            i5++;
            try {
                declaredField = ((Class) obj2).getDeclaredField(str2);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                if (Modifier.isFinal(declaredField.getModifiers()) && DH.SyncMtd.getOSVersionIntForFly() >= 37 && cn.fly.tools.b.c.a(FlySDK.getContext()).d().ar().targetSdkVersion >= 37) {
                    throw new Throwable(androidx.collection.a.p("className: ", str, ", fieldName: ", str2, " is static final, not allowed in 37"));
                }
                declaredField.setAccessible(true);
                declaredField.set(null, obj);
                return;
            }
        }
        StringBuilder sbU = androidx.collection.a.u("className: ", str, ", fieldName: ", str2, ", value: ");
        sbU.append(String.valueOf(obj));
        throw new NoSuchFieldException(sbU.toString());
    }

    private static <T> T a(Object obj, String str) throws NoSuchFieldException {
        Field declaredField;
        if (!(obj instanceof List) && !obj.getClass().isArray()) {
            if (obj instanceof Map) {
                return (T) ((Map) obj).get(str);
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                arrayList.add(superclass);
            }
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                try {
                    declaredField = ((Class) obj2).getDeclaredField(str);
                } catch (Throwable unused) {
                    declaredField = null;
                }
                if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                    declaredField.setAccessible(true);
                    return (T) declaredField.get(obj);
                }
            }
            throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
        }
        return (T) b(obj, str);
    }

    private static void a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField;
        if (!(obj instanceof List) && !obj.getClass().isArray()) {
            if (obj instanceof Map) {
                ((Map) obj).put(str, obj2);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                arrayList.add(superclass);
            }
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj3 = arrayList.get(i5);
                i5++;
                try {
                    declaredField = ((Class) obj3).getDeclaredField(str);
                } catch (Throwable unused) {
                    declaredField = null;
                }
                if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                    declaredField.setAccessible(true);
                    declaredField.set(obj, obj2);
                    return;
                }
            }
            throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
        }
        b(obj, str, obj2);
    }
}
