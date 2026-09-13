package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class H implements O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2956a;
    public final boolean b;
    public final O c;
    public final G d;
    public final p126w0.q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2958g;

    public H(O o6, boolean z6, boolean z7, p126w0.q qVar, G g6) {
        this.c = (O) L0.q.checkNotNull(o6);
        this.f2956a = z6;
        this.b = z7;
        this.e = qVar;
        this.d = (G) L0.q.checkNotNull(g6);
    }

    public final synchronized void a() {
        if (this.f2958g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f2957f++;
    }

    public final void b() {
        boolean z6;
        synchronized (this) {
            int i5 = this.f2957f;
            if (i5 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z6 = true;
            int i6 = i5 - 1;
            this.f2957f = i6;
            if (i6 != 0) {
                z6 = false;
            }
        }
        if (z6) {
            ((x) this.d).d(this.e, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Object get() {
        return this.c.get();
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Class<Object> getResourceClass() {
        return this.c.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        return this.c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.O
    public final synchronized void recycle() {
        if (this.f2957f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f2958g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f2958g = true;
        if (this.b) {
            this.c.recycle();
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f2956a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f2957f + ", isRecycled=" + this.f2958g + ", resource=" + this.c + '}';
    }
}
