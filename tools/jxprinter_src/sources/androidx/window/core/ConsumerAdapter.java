package androidx.window.core;

import O3.l;
import V3.c;
import V3.d;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.CheckResult;
import androidx.window.reflection.WindowExtensionsConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.E;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanUncheckedReflection"})
public final class ConsumerAdapter {
    private final ClassLoader loader;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ConsumerHandler<T> implements InvocationHandler {
        private final c clazz;
        private final l consumer;

        public ConsumerHandler(c clazz, l consumer) {
            E.f(clazz, "clazz");
            E.f(consumer, "consumer");
            this.clazz = clazz;
            this.consumer = consumer;
        }

        private final boolean isAccept(Method method, Object[] objArr) {
            return E.a(method.getName(), "accept") && objArr != null && objArr.length == 1;
        }

        private final boolean isEquals(Method method, Object[] objArr) {
            return E.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        private final boolean isHashCode(Method method, Object[] objArr) {
            return E.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        private final boolean isToString(Method method, Object[] objArr) {
            return E.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            E.f(obj, "obj");
            E.f(method, "method");
            if (isAccept(method, objArr)) {
                invokeAccept(d.cast(this.clazz, objArr != null ? objArr[0] : null));
                return Q.INSTANCE;
            }
            if (isEquals(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (isHashCode(method, objArr)) {
                return Integer.valueOf(this.consumer.hashCode());
            }
            if (isToString(method, objArr)) {
                return this.consumer.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }

        public final void invokeAccept(T parameter) {
            E.f(parameter, "parameter");
            this.consumer.invoke(parameter);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Subscription {
        void dispose();
    }

    public ConsumerAdapter(ClassLoader loader) {
        E.f(loader, "loader");
        this.loader = loader;
    }

    private final <T> Object buildConsumer(c cVar, l lVar) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.loader, new Class[]{unsafeConsumerClass()}, new ConsumerHandler(cVar, lVar));
        E.e(objNewProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return objNewProxyInstance;
    }

    private final Class<?> unsafeConsumerClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass(WindowExtensionsConstants.JAVA_CONSUMER);
        E.e(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }

    public final <T> void addConsumer(Object obj, c clazz, String methodName, l consumer) {
        E.f(obj, "obj");
        E.f(clazz, "clazz");
        E.f(methodName, "methodName");
        E.f(consumer, "consumer");
        obj.getClass().getMethod(methodName, unsafeConsumerClass()).invoke(obj, buildConsumer(clazz, consumer));
    }

    public final Class<?> consumerClassOrNull$window_release() {
        try {
            return unsafeConsumerClass();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final <T> void createConsumer(Object obj, c clazz, String addMethodName, Activity activity, l consumer) throws IllegalAccessException, InvocationTargetException {
        E.f(obj, "obj");
        E.f(clazz, "clazz");
        E.f(addMethodName, "addMethodName");
        E.f(activity, "activity");
        E.f(consumer, "consumer");
        obj.getClass().getMethod(addMethodName, Activity.class, unsafeConsumerClass()).invoke(obj, activity, buildConsumer(clazz, consumer));
    }

    @CheckResult
    public final <T> Subscription createSubscription(final Object obj, c clazz, String addMethodName, String removeMethodName, Activity activity, l consumer) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        E.f(obj, "obj");
        E.f(clazz, "clazz");
        E.f(addMethodName, "addMethodName");
        E.f(removeMethodName, "removeMethodName");
        E.f(activity, "activity");
        E.f(consumer, "consumer");
        final Object objBuildConsumer = buildConsumer(clazz, consumer);
        obj.getClass().getMethod(addMethodName, Activity.class, unsafeConsumerClass()).invoke(obj, activity, objBuildConsumer);
        final Method method = obj.getClass().getMethod(removeMethodName, unsafeConsumerClass());
        return new Subscription() { // from class: androidx.window.core.ConsumerAdapter.createSubscription.1
            @Override // androidx.window.core.ConsumerAdapter.Subscription
            public void dispose() throws IllegalAccessException, InvocationTargetException {
                method.invoke(obj, objBuildConsumer);
            }
        };
    }

    @CheckResult
    public final <T> Subscription createSubscriptionNoActivity(final Object obj, c clazz, String addMethodName, String removeMethodName, l consumer) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        E.f(obj, "obj");
        E.f(clazz, "clazz");
        E.f(addMethodName, "addMethodName");
        E.f(removeMethodName, "removeMethodName");
        E.f(consumer, "consumer");
        final Object objBuildConsumer = buildConsumer(clazz, consumer);
        obj.getClass().getMethod(addMethodName, unsafeConsumerClass()).invoke(obj, objBuildConsumer);
        final Method method = obj.getClass().getMethod(removeMethodName, unsafeConsumerClass());
        return new Subscription() { // from class: androidx.window.core.ConsumerAdapter.createSubscriptionNoActivity.1
            @Override // androidx.window.core.ConsumerAdapter.Subscription
            public void dispose() throws IllegalAccessException, InvocationTargetException {
                method.invoke(obj, objBuildConsumer);
            }
        };
    }

    @CheckResult
    public final <T> Subscription createSubscription(final Object obj, c clazz, String addMethodName, String removeMethodName, Context context, l consumer) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        E.f(obj, "obj");
        E.f(clazz, "clazz");
        E.f(addMethodName, "addMethodName");
        E.f(removeMethodName, "removeMethodName");
        E.f(context, "context");
        E.f(consumer, "consumer");
        final Object objBuildConsumer = buildConsumer(clazz, consumer);
        obj.getClass().getMethod(addMethodName, Context.class, unsafeConsumerClass()).invoke(obj, context, objBuildConsumer);
        final Method method = obj.getClass().getMethod(removeMethodName, unsafeConsumerClass());
        return new Subscription() { // from class: androidx.window.core.ConsumerAdapter.createSubscription.2
            @Override // androidx.window.core.ConsumerAdapter.Subscription
            public void dispose() throws IllegalAccessException, InvocationTargetException {
                method.invoke(obj, objBuildConsumer);
            }
        };
    }
}
