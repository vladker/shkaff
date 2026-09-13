package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import t5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5406a;
    public final int b;
    public final boolean c;

    public C(b bVar, int i5, boolean z6) {
        this.f5406a = bVar;
        this.b = i5;
        this.c = z6;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        this.f5406a.subscribe(new B(interfaceC0679f, this.b, this.c));
    }
}
