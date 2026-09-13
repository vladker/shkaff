package com.google.firebase.components;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance;
    private volatile Provider<T> provider;

    public Lazy(T t6) {
        this.instance = UNINITIALIZED;
        this.instance = t6;
    }

    @Override // com.google.firebase.inject.Provider
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
                    t6 = this.provider.get();
                    this.instance = t6;
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t6;
    }

    @VisibleForTesting
    public boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }

    public Lazy(Provider<T> provider) {
        this.instance = UNINITIALIZED;
        this.provider = provider;
    }
}
