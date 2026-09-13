package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;

/* JADX INFO: renamed from: j3.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0993d extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5429a;
    public final AbstractC0676c b;
    public final InterfaceC0682i c;

    public /* synthetic */ C0993d(AbstractC0676c abstractC0676c, InterfaceC0682i interfaceC0682i, int i5) {
        this.f5429a = i5;
        this.b = abstractC0676c;
        this.c = interfaceC0682i;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5429a) {
            case 0:
                this.b.subscribe(new C0992c(interfaceC0679f, this.c));
                break;
            default:
                L l6 = new L(interfaceC0679f);
                interfaceC0679f.onSubscribe(l6);
                ((AbstractC0676c) this.c).subscribe(l6.b);
                this.b.subscribe(l6);
                break;
        }
    }
}
