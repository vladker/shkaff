package y5;

import io.reactivex.B;
import io.reactivex.I;
import io.reactivex.internal.operators.observable.C0899m0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9045a;
    public final B b;

    public /* synthetic */ b(B b, int i5) {
        this.f9045a = i5;
        this.b = b;
    }

    @Override // io.reactivex.B
    public final void b(I i5) {
        switch (this.f9045a) {
            case 0:
                this.b.subscribe(new a(i5));
                break;
            default:
                this.b.subscribe(new C0899m0(i5, 4));
                break;
        }
    }
}
