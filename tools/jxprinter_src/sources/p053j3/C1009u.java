package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.N;
import p011b3.c;
import p033f3.d;
import p033f3.h;

/* JADX INFO: renamed from: j3.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1009u extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5454a;
    public final AbstractC0676c b;
    public final N c;

    public /* synthetic */ C1009u(AbstractC0676c abstractC0676c, N n6, int i5) {
        this.f5454a = i5;
        this.b = abstractC0676c;
        this.c = n6;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5454a) {
            case 0:
                this.b.subscribe(new RunnableC1008t(interfaceC0679f, this.c));
                break;
            case 1:
                this.b.subscribe(new F(interfaceC0679f, this.c));
                break;
            default:
                J j6 = new J(this.b, interfaceC0679f);
                interfaceC0679f.onSubscribe(j6);
                c cVarScheduleDirect = this.c.scheduleDirect(j6);
                h hVar = j6.b;
                hVar.getClass();
                d.c(hVar, cVarScheduleDirect);
                break;
        }
    }
}
