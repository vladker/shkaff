package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.plugins.a;
import p043h3.c;

/* JADX INFO: renamed from: k3.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1015c0 extends O implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0985s f5541a;

    public C1015c0(AbstractC0985s abstractC0985s) {
        this.f5541a = abstractC0985s;
    }

    @Override // p043h3.c
    public final AbstractC0985s a() {
        return a.onAssembly(new C1047y(this.f5541a, 3));
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        this.f5541a.subscribe(new C1032l(s6, 1));
    }
}
