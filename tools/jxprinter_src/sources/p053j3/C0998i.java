package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import t5.b;

/* JADX INFO: renamed from: j3.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0998i extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5441a;
    public final int b;

    public C0998i(b bVar, int i5) {
        this.f5441a = bVar;
        this.b = i5;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        this.f5441a.subscribe(new C0997h(interfaceC0679f, this.b));
    }
}
