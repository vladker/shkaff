package p048i3;

import io.reactivex.I;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class k extends b {
    private static final long serialVersionUID = -5502432239815349361L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f4053a;
    public Object b;

    public k(I i5) {
        this.f4053a = i5;
    }

    public final void a(Object obj) {
        int i5 = get();
        if ((i5 & 54) != 0) {
            return;
        }
        I i6 = this.f4053a;
        if (i5 == 8) {
            this.b = obj;
            lazySet(16);
            i6.onNext(null);
        } else {
            lazySet(2);
            i6.onNext(obj);
        }
        if (get() != 4) {
            i6.onComplete();
        }
    }

    @Override // p043h3.f
    public final int c(int i5) {
        lazySet(8);
        return 2;
    }

    @Override // p043h3.j
    public final void clear() {
        lazySet(32);
        this.b = null;
    }

    @Override // p011b3.c
    public void dispose() {
        set(4);
        this.b = null;
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == 4;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return get() != 16;
    }

    public void onSuccess(Object obj) {
        a(obj);
    }

    @Override // p048i3.b, p043h3.e, p043h3.f, p043h3.j
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        Object obj = this.b;
        this.b = null;
        lazySet(32);
        return obj;
    }
}
