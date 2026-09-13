package p065l3;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.B;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0984q;
import p027e3.o;
import p067m.h;

/* JADX INFO: renamed from: l3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1154e extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5829a;
    public final o b;
    public final int c;
    public final int d;
    public final Object e;

    public /* synthetic */ C1154e(Object obj, o oVar, int i5, int i6, int i7) {
        this.f5829a = i7;
        this.e = obj;
        this.b = oVar;
        this.c = i5;
        this.d = i6;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5829a) {
            case 0:
                ((AbstractC0979l) this.e).subscribe((InterfaceC0984q) new C1153d(interfaceC0679f, this.b, this.c, this.d));
                break;
            default:
                B b = (B) this.e;
                o oVar = this.b;
                if (!h.c(b, oVar, interfaceC0679f)) {
                    b.subscribe(new w(interfaceC0679f, oVar, this.c, this.d));
                }
                break;
        }
    }
}
