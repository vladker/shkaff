package androidx.window.core;

import O3.l;
import O3.p;
import V3.c;
import V3.d;
import android.annotation.SuppressLint;
import android.util.Pair;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanUncheckedReflection"})
public final class PredicateAdapter {
    private final ClassLoader loader;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class BaseHandler<T> implements InvocationHandler {
        private final c clazz;

        public BaseHandler(c clazz) {
            E.f(clazz, "clazz");
            this.clazz = clazz;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            E.f(obj, "obj");
            E.f(method, "method");
            if (isTest(method, objArr)) {
                return Boolean.valueOf(invokeTest(obj, d.cast(this.clazz, objArr != null ? objArr[0] : null)));
            }
            if (isEquals(method, objArr)) {
                Object obj2 = objArr != null ? objArr[0] : null;
                E.c(obj2);
                return Boolean.valueOf(obj == obj2);
            }
            if (isHashCode(method, objArr)) {
                return Integer.valueOf(hashCode());
            }
            if (isToString(method, objArr)) {
                return toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }

        public abstract boolean invokeTest(Object obj, T t6);

        public final boolean isEquals(Method method, Object[] objArr) {
            E.f(method, "<this>");
            return E.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        public final boolean isHashCode(Method method, Object[] objArr) {
            E.f(method, "<this>");
            return E.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        public final boolean isTest(Method method, Object[] objArr) {
            E.f(method, "<this>");
            return E.a(method.getName(), "test") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        public final boolean isToString(Method method, Object[] objArr) {
            E.f(method, "<this>");
            return E.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PairPredicateStubHandler<T, U> extends BaseHandler<Pair<?, ?>> {
        private final c clazzT;
        private final c clazzU;
        private final p predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PairPredicateStubHandler(c clazzT, c clazzU, p predicate) {
            super(U.a(Pair.class));
            E.f(clazzT, "clazzT");
            E.f(clazzU, "clazzU");
            E.f(predicate, "predicate");
            this.clazzT = clazzT;
            this.clazzU = clazzU;
            this.predicate = predicate;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return this.predicate.toString();
        }

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        public boolean invokeTest(Object obj, Pair<?, ?> parameter) {
            E.f(obj, "obj");
            E.f(parameter, "parameter");
            return ((Boolean) this.predicate.invoke(d.cast(this.clazzT, parameter.first), d.cast(this.clazzU, parameter.second))).booleanValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PredicateStubHandler<T> extends BaseHandler<T> {
        private final l predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PredicateStubHandler(c clazzT, l predicate) {
            super(clazzT);
            E.f(clazzT, "clazzT");
            E.f(predicate, "predicate");
            this.predicate = predicate;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        public boolean invokeTest(Object obj, T parameter) {
            E.f(obj, "obj");
            E.f(parameter, "parameter");
            return ((Boolean) this.predicate.invoke(parameter)).booleanValue();
        }

        public String toString() {
            return this.predicate.toString();
        }
    }

    public PredicateAdapter(ClassLoader loader) {
        E.f(loader, "loader");
        this.loader = loader;
    }

    private final Class<?> predicateClassOrThrow() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("java.util.function.Predicate");
        E.e(clsLoadClass, "loader.loadClass(\"java.util.function.Predicate\")");
        return clsLoadClass;
    }

    public final <T, U> Object buildPairPredicate(c firstClazz, c secondClazz, p predicate) {
        E.f(firstClazz, "firstClazz");
        E.f(secondClazz, "secondClazz");
        E.f(predicate, "predicate");
        Object objNewProxyInstance = Proxy.newProxyInstance(this.loader, new Class[]{predicateClassOrThrow()}, new PairPredicateStubHandler(firstClazz, secondClazz, predicate));
        E.e(objNewProxyInstance, "newProxyInstance(loader,…row()), predicateHandler)");
        return objNewProxyInstance;
    }

    public final <T> Object buildPredicate(c clazz, l predicate) {
        E.f(clazz, "clazz");
        E.f(predicate, "predicate");
        Object objNewProxyInstance = Proxy.newProxyInstance(this.loader, new Class[]{predicateClassOrThrow()}, new PredicateStubHandler(clazz, predicate));
        E.e(objNewProxyInstance, "newProxyInstance(loader,…row()), predicateHandler)");
        return objNewProxyInstance;
    }

    public final Class<?> predicateClassOrNull$window_release() {
        try {
            return predicateClassOrThrow();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
