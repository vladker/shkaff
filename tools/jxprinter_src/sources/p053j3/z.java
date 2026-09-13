package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.V;
import p011b3.d;
import p065l3.s;
import p077n3.C;
import t5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5459a;
    public final Object b;

    public /* synthetic */ z(Object obj, int i5) {
        this.f5459a = i5;
        this.b = obj;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f5459a) {
            case 0:
                ((AbstractC0676c) this.b).subscribe(new s(s6));
                break;
            case 1:
                ((b) this.b).subscribe(new C(s6));
                break;
            case 2:
                ((O) ((V) this.b)).subscribe(s6);
                break;
            default:
                s6.onSubscribe(d.disposed());
                s6.onSuccess(this.b);
                break;
        }
    }
}
