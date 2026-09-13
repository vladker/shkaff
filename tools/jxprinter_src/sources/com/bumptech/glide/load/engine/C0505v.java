package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0505v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.cache.a f3075a;
    public volatile com.bumptech.glide.load.engine.cache.c b;

    public C0505v(com.bumptech.glide.load.engine.cache.a aVar) {
        this.f3075a = aVar;
    }

    public final com.bumptech.glide.load.engine.cache.c a() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = ((S4.h) this.f3075a).build();
                    }
                    if (this.b == null) {
                        this.b = new V1.b(11);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.b;
    }

    @VisibleForTesting
    public synchronized void clearDiskCacheIfCreated() {
        if (this.b == null) {
            return;
        }
        this.b.clear();
    }
}
