package org.litepal.crud;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e {
    public static Object getField(Object obj, String str, Class<?> cls) {
        if (cls == f.class || cls == Object.class) {
            throw new p024d5.e(p024d5.e.a(cls.getSimpleName(), str));
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException unused) {
            return getField(obj, str, cls.getSuperclass());
        }
    }

    public static Object send(Object obj, String str, Object[] objArr, Class<?> cls, Class<?>[] clsArr) {
        if (objArr == null) {
            try {
                objArr = new Object[0];
            } catch (NoSuchMethodException e) {
                throw new p024d5.e(androidx.collection.a.p("The ", str, " method in ", cls.getSimpleName(), " class is necessary which does not exist."), e);
            }
        }
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static void set(Object obj, String str, Object obj2, Class<?> cls) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static void setField(Object obj, String str, Object obj2, Class<?> cls) {
        if (cls == f.class || cls == Object.class) {
            throw new p024d5.e(p024d5.e.a(cls.getSimpleName(), str));
        }
        try {
            set(obj, str, obj2, cls);
        } catch (NoSuchFieldException unused) {
            setField(obj, str, obj2, cls.getSuperclass());
        }
    }
}
