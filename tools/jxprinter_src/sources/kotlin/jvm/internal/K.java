package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class K extends O implements V3.l {
    public K(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.AbstractC1102p
    public V3.b computeReflected() {
        U.f5690a.getClass();
        return this;
    }

    @Override // V3.l
    public Object getDelegate(Object obj) {
        return ((V3.l) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.internal.O, V3.o
    public /* bridge */ /* synthetic */ V3.h getGetter() {
        getGetter();
        return null;
    }

    @Override // O3.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public K(Object obj, Class cls, String str, String str2, int i5) {
        super(obj, cls, str, str2, i5);
    }

    @Override // kotlin.jvm.internal.O, V3.o
    public V3.k getGetter() {
        ((V3.l) getReflected()).getGetter();
        return null;
    }
}
