package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0682i;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.z1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0834z1 extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final Object c;

    public /* synthetic */ C0834z1(Object obj, int i5) {
        this.b = i5;
        this.c = obj;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.b) {
            case 0:
                Object[] objArr = (Object[]) this.c;
                if (!(cVar instanceof p043h3.a)) {
                    cVar.onSubscribe(new C0822x1(cVar, objArr));
                } else {
                    cVar.onSubscribe(new C0816w1((p043h3.a) cVar, objArr));
                }
                break;
            case 1:
                ((io.reactivex.B) this.c).subscribe(new G1(cVar));
                break;
            case 2:
                ((AbstractC0676c) ((InterfaceC0682i) this.c)).subscribe(new p048i3.u(cVar));
                break;
            case 3:
                ((AbstractC0985s) ((io.reactivex.y) this.c)).subscribe(new p059k3.E0(cVar));
                break;
            default:
                ((io.reactivex.O) ((io.reactivex.V) this.c)).subscribe(new p077n3.U(cVar));
                break;
        }
    }
}
