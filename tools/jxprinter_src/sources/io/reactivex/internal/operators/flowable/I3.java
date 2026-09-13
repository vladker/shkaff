package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I3 extends AbstractC0824x3 {
    private static final long serialVersionUID = -5898283885385201806L;
    public final int d;

    public I3(int i5) {
        this.d = i5;
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0824x3
    public final void f() {
        if (this.b > this.d) {
            B3 b6 = (B3) ((B3) get()).get();
            if (b6 == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.b--;
            set(b6);
        }
    }
}
