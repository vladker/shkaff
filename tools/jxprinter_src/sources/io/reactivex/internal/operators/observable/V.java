package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0985s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final io.reactivex.y c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ V(io.reactivex.B b, io.reactivex.y yVar, int i5) {
        super(b);
        this.b = i5;
        this.c = yVar;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new U(i5, this.c));
                break;
            default:
                L1 l6 = new L1(i5);
                i5.onSubscribe(l6);
                this.f5141a.subscribe(l6);
                ((AbstractC0985s) this.c).subscribe(l6.c);
                break;
        }
    }
}
