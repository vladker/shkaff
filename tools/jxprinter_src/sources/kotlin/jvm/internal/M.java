package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class M extends O implements V3.n {
    public M(Class cls, String str, String str2, int i5) {
        super(AbstractC1102p.NO_RECEIVER, cls, str, str2, i5);
    }

    @Override // kotlin.jvm.internal.AbstractC1102p
    public final V3.b computeReflected() {
        U.f5690a.getClass();
        return this;
    }

    @Override // V3.n
    public Object getDelegate(Object obj, Object obj2) {
        return ((V3.n) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.jvm.internal.O, V3.o
    public final /* bridge */ /* synthetic */ V3.h getGetter() {
        getGetter();
        return null;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        ((N) this).getGetter();
        throw null;
    }

    @Override // kotlin.jvm.internal.O, V3.o
    public final V3.m getGetter() {
        ((V3.n) getReflected()).getGetter();
        return null;
    }
}
