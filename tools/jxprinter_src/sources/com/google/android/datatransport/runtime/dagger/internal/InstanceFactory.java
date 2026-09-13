package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    private InstanceFactory(T t6) {
        this.instance = t6;
    }

    public static <T> Factory<T> create(T t6) {
        return new InstanceFactory(Preconditions.checkNotNull(t6, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t6) {
        return t6 == null ? nullInstanceFactory() : new InstanceFactory(t6);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return (InstanceFactory<T>) NULL_INSTANCE_FACTORY;
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, p141y3.a
    public T get() {
        return this.instance;
    }
}
