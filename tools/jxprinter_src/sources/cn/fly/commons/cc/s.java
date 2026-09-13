package cn.fly.commons.cc;

import A3.AbstractC0157z;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f1380a;
    private HashMap<String, Object> c;
    private s e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1381f;
    private LinkedList<Object> b = new LinkedList<>();
    private HashMap<String, Class<?>> d = new HashMap<>();

    public s(HashMap<String, Object> map, u uVar) {
        this.f1380a = uVar;
        this.c = new HashMap<>(map);
    }

    public void a(Object obj) {
        this.b.push(obj);
    }

    public void b(String str, Object obj) {
        if (this.c.containsKey(str)) {
            this.c.put(str, obj);
            return;
        }
        s sVar = this.e;
        if (sVar == null) {
            throw new RuntimeException(AbstractC0157z.o("\"", str, "\" has not defined"));
        }
        sVar.b(str, obj);
    }

    public s c() {
        return this.e;
    }

    public int d() {
        return this.b.size();
    }

    public void e() {
        this.f1381f = true;
    }

    public boolean f() {
        return this.f1381f;
    }

    public u g() {
        return this.f1380a;
    }

    public Object a() {
        return this.b.pop();
    }

    public void a(String str, Object obj) {
        if (!this.c.containsKey(str)) {
            this.c.put(str, obj);
            return;
        }
        throw new RuntimeException(AbstractC0157z.o("\"", str, "\" has defined"));
    }

    public Object a(String str) {
        for (s sVar = this; sVar != null; sVar = sVar.e) {
            if (sVar.c.containsKey(str)) {
                return sVar.c.get(str);
            }
        }
        throw new RuntimeException(AbstractC0157z.o("Can not find \"", str, "\""));
    }

    public Class<?> b(String str) {
        for (s sVar = this; sVar != null; sVar = sVar.e) {
            if (sVar.d.containsKey(str)) {
                return sVar.d.get(str);
            }
        }
        throw new RuntimeException(AbstractC0157z.n("Can not find class ", str));
    }

    public s b() {
        s sVar = new s(new HashMap(), this.f1380a);
        sVar.e = this;
        return sVar;
    }

    public void a(String str, Class<?> cls) {
        this.d.put(str, cls);
    }

    public Object a(final Object obj, final boolean z6, Class<?>... clsArr) {
        return Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new InvocationHandler() { // from class: cn.fly.commons.cc.s.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) throws Throwable {
                Throwable th;
                z zVar;
                LinkedList<Object> linkedListB;
                try {
                    Object obj3 = obj;
                    if (obj3 != null) {
                        zVar = obj3 instanceof z ? (z) obj3 : (z) ((Map) obj3).get(method.getName());
                    } else {
                        zVar = null;
                    }
                    if (zVar != null) {
                        if (objArr == null) {
                            objArr = new Object[0];
                        }
                        if (z6) {
                            linkedListB = zVar.b(objArr);
                        } else {
                            try {
                                linkedListB = zVar.b(objArr);
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    throw th;
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (linkedListB.isEmpty()) {
                            return null;
                        }
                        return linkedListB.get(0);
                        th = null;
                    } else {
                        th = null;
                    }
                } catch (Throwable unused2) {
                }
                if (th == null) {
                    return null;
                }
                throw th;
            }
        });
    }

    public void a(Method method, int i5) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = new Object[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = a();
        }
        a(method, objArr);
    }

    public void a(Method method, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
        Object obj;
        if (Modifier.isStatic(method.getModifiers())) {
            obj = null;
        } else if (objArr.length > 0) {
            obj = objArr[0];
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + 1;
                objArr2[i5] = objArr[i6];
                i5 = i6;
            }
            objArr = objArr2;
        } else {
            throw new RuntimeException("receiver not found");
        }
        method.setAccessible(true);
        for (int i7 = 0; i7 < objArr.length; i7++) {
            if (method.getParameterTypes()[i7].isInterface()) {
                Object obj2 = objArr[i7];
                if (obj2 instanceof z) {
                    objArr[i7] = a(obj2, true, method.getParameterTypes()[i7]);
                }
            }
        }
        if (method.getReturnType() == Void.TYPE) {
            method.invoke(obj, objArr);
        } else {
            a(method.invoke(obj, objArr));
        }
    }
}
