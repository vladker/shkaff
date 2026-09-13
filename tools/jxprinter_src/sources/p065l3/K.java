package p065l3;

import io.reactivex.B;
import io.reactivex.I;
import io.reactivex.O;
import p027e3.o;
import p077n3.C1271z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5817a;
    public final O b;
    public final o c;

    public /* synthetic */ K(O o6, o oVar, int i5) {
        this.f5817a = i5;
        this.b = o6;
        this.c = oVar;
    }

    @Override // io.reactivex.B
    public final void b(I i5) {
        switch (this.f5817a) {
            case 0:
                J j6 = new J(i5, this.c);
                i5.onSubscribe(j6);
                this.b.subscribe(j6);
                break;
            default:
                this.b.subscribe(new C1271z(i5, this.c));
                break;
        }
    }
}
