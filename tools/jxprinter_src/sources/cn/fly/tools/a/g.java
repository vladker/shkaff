package cn.fly.tools.a;

import cn.fly.commons.o;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class g implements a {
    @Override // cn.fly.tools.a.a
    public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr, Class<?> cls2) {
        Method method = (Method) Class.class.getDeclaredMethod(o.a("017Fej,fiGfl6fcgdMdj7fRdchc(fih>dkdc"), String.class, Class[].class).invoke(cls, str, clsArr);
        method.setAccessible(true);
        return (T) method.invoke(obj, objArr);
    }

    @Override // cn.fly.tools.a.a
    public Class b(String str) {
        return (Class) Class.class.getDeclaredMethod(o.a("007HefdkdjegSd7df>f"), String.class).invoke(null, str);
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr, Class<?> cls) {
        return (T) a((Class) Class.class.getDeclaredMethod(o.a("007Hefdkdjeg'dEdf!f"), String.class).invoke(null, str), obj, str2, clsArr, objArr, cls);
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str) {
        return (T) Class.class.getDeclaredMethod(o.a("011ef]fgeeNe>fi)idecf"), null).invoke((Class) Class.class.getDeclaredMethod(o.a("0070efdkdjeg_d+df$f"), String.class).invoke(null, str), null);
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str, String str2, Object obj, Class<?> cls) {
        Field field = (Field) Class.class.getDeclaredMethod(o.a("0161ej5fi'fl0fcgdSdj=f1dcgcdiOfg>dc"), String.class).invoke((Class) Class.class.getDeclaredMethod(o.a("007=efdkdjeg$dRdfBf"), String.class).invoke(null, str), str2);
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    @Override // cn.fly.tools.a.a
    public <T> T a(String str, Class[] clsArr, Object[] objArr) {
        if (clsArr != null && clsArr.length != 0 && objArr != null && objArr.length != 0) {
            Constructor constructor = (Constructor) Class.class.getDeclaredMethod(o.a("022!ej$fiEfl+fcgdXdj@fLdceddkBe*fi<iOdjdg@ci@dkdj"), Class[].class).invoke((Class) Class.class.getDeclaredMethod(o.a("007*efdkdjeg>d(df8f"), String.class).invoke(null, str), clsArr);
            constructor.setAccessible(true);
            return (T) constructor.newInstance(objArr);
        }
        return (T) a(str);
    }
}
