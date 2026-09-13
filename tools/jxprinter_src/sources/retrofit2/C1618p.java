package retrofit2;

import java.lang.reflect.Type;

/* JADX INFO: renamed from: retrofit2.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1618p implements InterfaceC1615m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8136a;
    public final Type b;

    public /* synthetic */ C1618p(int i5, Type type) {
        this.f8136a = i5;
        this.b = type;
    }

    @Override // retrofit2.InterfaceC1615m
    public final Type a() {
        switch (this.f8136a) {
            case 0:
                break;
        }
        return this.b;
    }

    @Override // retrofit2.InterfaceC1615m
    public final Object c(InterfaceC1613k interfaceC1613k) {
        switch (this.f8136a) {
            case 0:
                C1619q c1619q = new C1619q(interfaceC1613k);
                interfaceC1613k.b(new C1617o(c1619q, 0));
                return c1619q;
            default:
                C1619q c1619q2 = new C1619q(interfaceC1613k);
                interfaceC1613k.b(new C1617o(c1619q2, 1));
                return c1619q2;
        }
    }
}
