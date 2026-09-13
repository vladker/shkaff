package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class N implements O, M0.f {
    public static final Pools.Pool e = M0.h.threadSafe(20, new V1.b(9));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M0.j f2964a = M0.j.newInstance();
    public O b;
    public boolean c;
    public boolean d;

    @NonNull
    public static <Z> N obtain(O o6) {
        N n6 = (N) L0.q.checkNotNull((N) e.acquire());
        n6.d = false;
        n6.c = true;
        n6.b = o6;
        return n6;
    }

    public final synchronized void a() {
        this.f2964a.a();
        if (!this.c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.c = false;
        if (this.d) {
            recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Object get() {
        return this.b.get();
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Class<Object> getResourceClass() {
        return this.b.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        return this.b.getSize();
    }

    @Override // M0.f
    @NonNull
    public M0.j getVerifier() {
        return this.f2964a;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final synchronized void recycle() {
        this.f2964a.a();
        this.d = true;
        if (!this.c) {
            this.b.recycle();
            this.b = null;
            e.release(this);
        }
    }
}
