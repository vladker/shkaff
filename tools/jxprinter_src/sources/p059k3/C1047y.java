package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import p017c3.d;
import p033f3.e;

/* JADX INFO: renamed from: k3.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1047y extends AbstractC1010a {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1047y(y yVar, int i5) {
        super(yVar);
        this.b = i5;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.b) {
            case 0:
                C1046x c1046x = new C1046x();
                c1046x.b = interfaceC0988v;
                ((AbstractC0985s) this.f5536a).subscribe(c1046x);
                return;
            case 1:
                ((AbstractC0985s) this.f5536a).subscribe(new C1046x(interfaceC0988v, 1));
                return;
            case 2:
                ((AbstractC0985s) this.f5536a).subscribe(new C1046x(interfaceC0988v, 2));
                return;
            case 3:
                ((AbstractC0985s) this.f5536a).subscribe(new C1046x(interfaceC0988v, 3));
                return;
            case 4:
                try {
                    throw null;
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    interfaceC0988v.onSubscribe(e.f3970a);
                    interfaceC0988v.onError(th);
                    return;
                }
            default:
                ((AbstractC0985s) this.f5536a).subscribe(interfaceC0988v);
                return;
        }
    }
}
