package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import p027e3.a;
import p027e3.b;
import p027e3.g;

/* JADX INFO: renamed from: k3.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1048z extends AbstractC1010a {
    public final /* synthetic */ int b;
    public final Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1048z(AbstractC0985s abstractC0985s, Object obj, int i5) {
        super(abstractC0985s);
        this.b = i5;
        this.c = obj;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.b) {
            case 0:
                ((AbstractC0985s) this.f5536a).subscribe(new r(1, interfaceC0988v, (g) this.c));
                break;
            case 1:
                ((AbstractC0985s) this.f5536a).subscribe(new A(interfaceC0988v, (a) this.c));
                break;
            default:
                ((AbstractC0985s) this.f5536a).subscribe(new r(2, interfaceC0988v, (b) this.c));
                break;
        }
    }
}
