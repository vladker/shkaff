package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.O;
import io.reactivex.S;

/* JADX INFO: renamed from: k3.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1030k extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5565a;
    public final AbstractC0985s b;
    public final Object c;

    public /* synthetic */ C1030k(AbstractC0985s abstractC0985s, Object obj, int i5) {
        this.f5565a = i5;
        this.b = abstractC0985s;
        this.c = obj;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f5565a) {
            case 0:
                this.b.subscribe(new C1028j(s6, this.c, 0));
                break;
            default:
                this.b.subscribe(new C1028j(s6, this.c, 1));
                break;
        }
    }
}
