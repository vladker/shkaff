package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.a2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0841a2 extends p048i3.b {
    private static final long serialVersionUID = 396518478098735504L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5143a;
    public final long b;
    public long c;
    public boolean d;

    public C0841a2(io.reactivex.I i5, long j6, long j7) {
        this.f5143a = i5;
        this.c = j6;
        this.b = j7;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.d = true;
        return 1;
    }

    @Override // p043h3.j
    public final void clear() {
        this.c = this.b;
        lazySet(1);
    }

    @Override // p011b3.c
    public final void dispose() {
        set(1);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() != 0;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.c == this.b;
    }

    @Override // p048i3.b, p043h3.e, p043h3.f, p043h3.j
    public Long poll() {
        long j6 = this.c;
        if (j6 != this.b) {
            this.c = 1 + j6;
            return Long.valueOf(j6);
        }
        lazySet(1);
        return null;
    }
}
