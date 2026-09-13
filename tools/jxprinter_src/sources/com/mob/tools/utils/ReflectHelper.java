package com.mob.tools.utils;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ReflectHelper implements PublicMemberKeeper {

    public interface a<ArgType, RetType> {
        RetType a(ArgType argtype);
    }

    public static Object createProxy(HashMap<String, a<Object, Object[]>> map, Class<?>... clsArr) {
        HashMap map2 = new HashMap();
        for (final Map.Entry<String, a<Object, Object[]>> entry : map.entrySet()) {
            map2.put(entry.getKey(), new a<Object[], Object>() { // from class: com.mob.tools.utils.ReflectHelper.1
                @Override // com.mob.tools.utils.ReflectHelper.a
                public Object a(Object[] objArr) {
                    return ((Object[]) ((a) entry.getValue()).a(objArr))[0];
                }
            });
        }
        return createProxy((Map<String, a<Object[], Object>>) map2, clsArr);
    }

    public static Class<?> getClass(String str) {
        return cn.fly.tools.utils.ReflectHelper.getClass(str);
    }

    public static <T> T getInstanceField(Object obj, String str, T t6) {
        return (T) cn.fly.tools.utils.ReflectHelper.getInstanceField(obj, str, t6);
    }

    public static String getName(Class<?> cls) {
        return cn.fly.tools.utils.ReflectHelper.getName(cls);
    }

    public static <T> T getStaticField(String str, String str2, T t6) {
        return (T) cn.fly.tools.utils.ReflectHelper.getStaticField(str, str2, t6);
    }

    public static String importClass(String str) {
        return importClass(null, str);
    }

    public static String importClassNoThrow(String str, String str2) {
        return cn.fly.tools.utils.ReflectHelper.importClassNoThrow(str, str2);
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr, T t6) {
        return (T) cn.fly.tools.utils.ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr, t6);
    }

    public static <T> T invokeInstanceMethodNoThrow(Object obj, String str, T t6, Object... objArr) {
        return (T) cn.fly.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(obj, str, t6, objArr);
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr, T t6) {
        return (T) cn.fly.tools.utils.ReflectHelper.invokeStaticMethod(str, str2, objArr, clsArr, t6);
    }

    public static <T> T invokeStaticMethodNoThrow(String str, String str2, T t6, Object... objArr) {
        return (T) cn.fly.tools.utils.ReflectHelper.invokeStaticMethodNoThrow(str, str2, t6, objArr);
    }

    public static Object newInstance(String str, Object... objArr) {
        return cn.fly.tools.utils.ReflectHelper.newInstance(str, objArr);
    }

    public static void setInstanceField(Object obj, String str, Object obj2) throws Throwable {
        cn.fly.tools.utils.ReflectHelper.setInstanceField(obj, str, obj2);
    }

    public static void setStaticField(String str, String str2, Object obj) throws Throwable {
        cn.fly.tools.utils.ReflectHelper.setStaticField(str, str2, obj);
    }

    public static <T> T getInstanceField(Object obj, String str) {
        return (T) cn.fly.tools.utils.ReflectHelper.getInstanceField(obj, str);
    }

    public static <T> T getStaticField(String str, String str2) {
        return (T) cn.fly.tools.utils.ReflectHelper.getStaticField(str, str2);
    }

    public static synchronized String importClass(String str, String str2) {
        return cn.fly.tools.utils.ReflectHelper.importClass(str, str2);
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        return (T) cn.fly.tools.utils.ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr);
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr) {
        return (T) cn.fly.tools.utils.ReflectHelper.invokeStaticMethod(str, str2, objArr, clsArr);
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
        return (T) cn.fly.tools.utils.ReflectHelper.invokeInstanceMethod(obj, str, objArr);
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object... objArr) {
        return (T) cn.fly.tools.utils.ReflectHelper.invokeStaticMethod(str, str2, objArr);
    }

    public static Object createProxy(final Map<String, a<Object[], Object>> map, Class<?>... clsArr) {
        if (clsArr.length == 0) {
            return null;
        }
        return Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, new InvocationHandler() { // from class: com.mob.tools.utils.ReflectHelper.2
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
}
