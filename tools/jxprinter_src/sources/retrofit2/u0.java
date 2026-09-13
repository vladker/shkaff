package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.C1378y;
import okhttp3.InterfaceC1352e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f8163a = new ConcurrentHashMap();
    public final InterfaceC1352e b;
    public final C1378y c;
    final Executor callbackExecutor;
    public final List d;
    public final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8164f;

    public u0(InterfaceC1352e interfaceC1352e, C1378y c1378y, List<AbstractC1620s> list, int i5, List<AbstractC1614l> list2, int i6, Executor executor, boolean z6) {
        this.b = interfaceC1352e;
        this.c = c1378y;
        this.d = list;
        this.e = list2;
        this.callbackExecutor = executor;
        this.f8164f = z6;
    }

    public final Object a(Class cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls2.getName());
                if (cls2 != cls) {
                    sb.append(" which is an interface of ");
                    sb.append(cls.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.f8164f) {
            m0 m0Var = j0.f8130a;
            for (Method method : cls.getDeclaredMethods()) {
                if (!m0Var.b(method) && !Modifier.isStatic(method.getModifiers()) && !method.isSynthetic()) {
                    b(cls, method);
                }
            }
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new s0(this, cls));
    }

    public final v0 b(Class cls, Method method) {
        while (true) {
            Object objPutIfAbsent = this.f8163a.get(method);
            if (objPutIfAbsent instanceof v0) {
                return (v0) objPutIfAbsent;
            }
            if (objPutIfAbsent == null) {
                Object obj = new Object();
                synchronized (obj) {
                    try {
                        objPutIfAbsent = this.f8163a.putIfAbsent(method, obj);
                        if (objPutIfAbsent == null) {
                            try {
                                A a6 = v0.a(this, cls, method);
                                this.f8163a.put(method, a6);
                                return a6;
                            } catch (Throwable th) {
                                this.f8163a.remove(method);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            synchronized (objPutIfAbsent) {
                try {
                    Object obj2 = this.f8163a.get(method);
                    if (obj2 != null) {
                        return (v0) obj2;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    public final InterfaceC1621t c(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = this.d;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            InterfaceC1621t interfaceC1621tStringConverter = ((AbstractC1620s) list.get(i5)).stringConverter(type, annotationArr, this);
            if (interfaceC1621tStringConverter != null) {
                return interfaceC1621tStringConverter;
            }
        }
        return C1607e.f8123a;
    }

    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public InterfaceC1615m nextCallAdapter(AbstractC1614l abstractC1614l, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = this.e;
        int iIndexOf = list.indexOf(abstractC1614l) + 1;
        int size = list.size();
        for (int i5 = iIndexOf; i5 < size; i5++) {
            InterfaceC1615m interfaceC1615m = ((AbstractC1614l) list.get(i5)).get(type, annotationArr, this);
            if (interfaceC1615m != null) {
                return interfaceC1615m;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (abstractC1614l != null) {
            sb.append("  Skipped:");
            for (int i6 = 0; i6 < iIndexOf; i6++) {
                sb.append("\n   * ");
                sb.append(((AbstractC1614l) list.get(i6)).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((AbstractC1614l) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> InterfaceC1621t nextRequestBodyConverter(AbstractC1620s abstractC1620s, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        List list = this.d;
        int iIndexOf = list.indexOf(abstractC1620s) + 1;
        int size = list.size();
        for (int i5 = iIndexOf; i5 < size; i5++) {
            InterfaceC1621t interfaceC1621tRequestBodyConverter = ((AbstractC1620s) list.get(i5)).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (interfaceC1621tRequestBodyConverter != null) {
                return interfaceC1621tRequestBodyConverter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (abstractC1620s != null) {
            sb.append("  Skipped:");
            for (int i6 = 0; i6 < iIndexOf; i6++) {
                sb.append("\n   * ");
                sb.append(((AbstractC1620s) list.get(i6)).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((AbstractC1620s) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> InterfaceC1621t nextResponseBodyConverter(AbstractC1620s abstractC1620s, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = this.d;
        int iIndexOf = list.indexOf(abstractC1620s) + 1;
        int size = list.size();
        for (int i5 = iIndexOf; i5 < size; i5++) {
            InterfaceC1621t interfaceC1621tResponseBodyConverter = ((AbstractC1620s) list.get(i5)).responseBodyConverter(type, annotationArr, this);
            if (interfaceC1621tResponseBodyConverter != null) {
                return interfaceC1621tResponseBodyConverter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (abstractC1620s != null) {
            sb.append("  Skipped:");
            for (int i6 = 0; i6 < iIndexOf; i6++) {
                sb.append("\n   * ");
                sb.append(((AbstractC1620s) list.get(i6)).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((AbstractC1620s) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }
}
