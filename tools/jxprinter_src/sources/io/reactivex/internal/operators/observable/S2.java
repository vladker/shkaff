package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S2 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ S2(io.reactivex.B b, int i5, int i6) {
        super(b);
        this.b = i6;
        this.c = i5;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new R2(i5, this.c));
                break;
            default:
                this.f5141a.subscribe(new C0857d3(i5, this.c));
                break;
        }
    }
}
