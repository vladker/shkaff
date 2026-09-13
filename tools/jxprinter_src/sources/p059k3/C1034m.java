package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.O;
import io.reactivex.S;
import p065l3.s;

/* JADX INFO: renamed from: k3.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1034m extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5568a;
    public final AbstractC0985s b;

    public /* synthetic */ C1034m(AbstractC0985s abstractC0985s, int i5) {
        this.f5568a = i5;
        this.b = abstractC0985s;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f5568a) {
            case 0:
                this.b.subscribe(new C1032l(s6, 0));
                break;
            default:
                this.b.subscribe(new s(s6));
                break;
        }
    }
}
