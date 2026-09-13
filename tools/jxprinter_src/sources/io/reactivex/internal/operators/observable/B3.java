package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B3 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final int c;
    public final Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ B3(io.reactivex.B b, Object obj, int i5, int i6) {
        super(b);
        this.b = i6;
        this.d = obj;
        this.c = i5;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                A3 a6 = new A3(i5, this.c);
                i5.onSubscribe(a6);
                ((io.reactivex.G) this.d).subscribe(a6.c);
                this.f5141a.subscribe(a6);
                break;
            default:
                this.f5141a.subscribe(new G3(i5, this.c, (Callable) this.d));
                break;
        }
    }
}
