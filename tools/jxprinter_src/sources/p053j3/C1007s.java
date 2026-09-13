package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;

/* JADX INFO: renamed from: j3.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1007s extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5452a;
    public final AbstractC0676c b;

    public /* synthetic */ C1007s(AbstractC0676c abstractC0676c, int i5) {
        this.f5452a = i5;
        this.b = abstractC0676c;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5452a) {
            case 0:
                r rVar = new r();
                rVar.b = interfaceC0679f;
                this.b.subscribe(rVar);
                break;
            default:
                this.b.subscribe(new r(interfaceC0679f, 1));
                break;
        }
    }
}
