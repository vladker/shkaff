package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S0 extends p048i3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5101a;
    public final Object[] b;
    public int c;
    public boolean d;
    public volatile boolean e;

    public S0(io.reactivex.I i5, Object[] objArr) {
        this.f5101a = i5;
        this.b = objArr;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.d = true;
        return 1;
    }

    @Override // p043h3.j
    public final void clear() {
        this.c = this.b.length;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.e = true;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.c == this.b.length;
    }

    @Override // p048i3.c, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        int i5 = this.c;
        Object[] objArr = this.b;
        if (i5 == objArr.length) {
            return null;
        }
        this.c = i5 + 1;
        Object obj = objArr[i5];
        p039g3.A.b(obj, "The array element is null");
        return obj;
    }
}
