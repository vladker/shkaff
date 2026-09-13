package retrofit2;

import okhttp3.InterfaceC1352e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class A extends v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f8089a;
    public final InterfaceC1352e b;
    public final InterfaceC1621t c;

    public A(q0 q0Var, InterfaceC1352e interfaceC1352e, InterfaceC1621t interfaceC1621t) {
        this.f8089a = q0Var;
        this.b = interfaceC1352e;
        this.c = interfaceC1621t;
    }

    public abstract Object adapt(InterfaceC1613k<Object> interfaceC1613k, Object[] objArr);

    @Override // retrofit2.v0
    public final Object invoke(Object obj, Object[] objArr) {
        return adapt(new N(this.f8089a, obj, objArr, this.b, this.c), objArr);
    }
}
