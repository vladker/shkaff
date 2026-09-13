package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0682i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final InterfaceC0682i c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ T(io.reactivex.B b, InterfaceC0682i interfaceC0682i, int i5) {
        super(b);
        this.b = i5;
        this.c = interfaceC0682i;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new S(i5, this.c));
                break;
            default:
                J1 j1 = new J1(i5);
                i5.onSubscribe(j1);
                this.f5141a.subscribe(j1);
                ((AbstractC0676c) this.c).subscribe(j1.c);
                break;
        }
    }
}
