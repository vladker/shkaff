package p065l3;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import p027e3.o;
import t5.c;

/* JADX INFO: renamed from: l3.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1157h extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final AbstractC0979l c;
    public final o d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5842f;

    public /* synthetic */ C1157h(AbstractC0979l abstractC0979l, o oVar, int i5, int i6, int i7) {
        this.b = i7;
        this.c = abstractC0979l;
        this.d = oVar;
        this.e = i5;
        this.f5842f = i6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(c cVar) {
        switch (this.b) {
            case 0:
                this.c.subscribe((InterfaceC0984q) new C1156g(cVar, this.d, this.f5842f, this.e));
                break;
            default:
                this.c.subscribe((InterfaceC0984q) new C1159j(cVar, this.d, this.f5842f, this.e));
                break;
        }
    }
}
