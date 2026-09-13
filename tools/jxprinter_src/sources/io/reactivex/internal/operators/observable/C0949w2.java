package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.w2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0949w2 extends AbstractC0896l2 {
    private static final long serialVersionUID = -5898283885385201806L;
    public final int c;

    public C0949w2(int i5) {
        this.c = i5;
    }

    @Override // io.reactivex.internal.operators.observable.AbstractC0896l2
    public final void f() {
        if (this.b > this.c) {
            C0916p2 c0916p2 = (C0916p2) ((C0916p2) get()).get();
            this.b--;
            set(c0916p2);
        }
    }
}
