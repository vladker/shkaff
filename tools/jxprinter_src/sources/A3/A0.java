package A3;

import W3.InterfaceC0233q;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A0 implements InterfaceC0233q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0233q f30a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    public A0(InterfaceC0233q interfaceC0233q, int i5, int i6, boolean z6, boolean z7) {
        this.f30a = interfaceC0233q;
        this.b = i5;
        this.c = i6;
        this.d = z6;
        this.e = z7;
    }

    @Override // W3.InterfaceC0233q
    public final Iterator iterator() {
        return B0.windowedIterator(this.f30a.iterator(), this.b, this.c, this.d, this.e);
    }
}
