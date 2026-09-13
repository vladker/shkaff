package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import p027e3.o;
import p048i3.t;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6266a;
    public final O b;
    public final o c;

    public /* synthetic */ G(O o6, o oVar, int i5) {
        this.f6266a = i5;
        this.b = o6;
        this.c = oVar;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f6266a) {
            case 0:
                this.b.subscribe(new t(s6, (Object) this.c, 10));
                break;
            default:
                this.b.subscribe(new K(s6, this.c));
                break;
        }
    }
}
