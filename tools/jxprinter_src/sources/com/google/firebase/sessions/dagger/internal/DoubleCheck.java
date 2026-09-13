package com.google.firebase.sessions.dagger.internal;

import com.google.firebase.sessions.dagger.Lazy;
import p141y3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p6) {
        return p6 instanceof Lazy ? (Lazy) p6 : new DoubleCheck((Provider) Preconditions.checkNotNull(p6));
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p6) {
        Preconditions.checkNotNull(p6);
        return p6 instanceof DoubleCheck ? p6 : new DoubleCheck(p6);
    }

    private static Object reentrantCheck(Object obj, Object obj2) {
        if (obj == UNINITIALIZED || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // com.google.firebase.sessions.dagger.internal.Provider, p141y3.a
    public T get() {
        T t6;
        T t7 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t7 != obj) {
            return t7;
        }
        synchronized (this) {
            try {
                t6 = (T) this.instance;
                if (t6 == obj) {
                    t6 = (T) this.provider.get();
                    this.instance = reentrantCheck(this.instance, t6);
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t6;
    }

    public static <P extends a, T> Lazy<T> lazy(P p6) {
        return lazy(Providers.asDaggerProvider(p6));
    }

    @Deprecated
    public static <P extends a, T> a provider(P p6) {
        return provider(Providers.asDaggerProvider(p6));
    }
}
