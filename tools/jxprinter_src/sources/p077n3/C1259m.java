package p077n3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.O;
import p027e3.o;
import p059k3.G;

/* JADX INFO: renamed from: n3.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1259m extends AbstractC0985s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6301a;
    public final O b;
    public final o c;

    public /* synthetic */ C1259m(O o6, o oVar, int i5) {
        this.f6301a = i5;
        this.b = o6;
        this.c = oVar;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.f6301a) {
            case 0:
                this.b.subscribe(new G(interfaceC0988v, this.c, 1));
                break;
            default:
                this.b.subscribe(new A(interfaceC0988v, this.c));
                break;
        }
    }
}
