package p059k3;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import io.reactivex.y;
import p043h3.c;

/* JADX INFO: renamed from: k3.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1013b0 extends AbstractC0676c implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f5539a;

    public C1013b0(y yVar) {
        this.f5539a = yVar;
    }

    @Override // p043h3.c
    public final AbstractC0985s a() {
        return a.onAssembly(new C1047y(this.f5539a, 2));
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        ((AbstractC0985s) this.f5539a).subscribe(new I(interfaceC0679f));
    }
}
