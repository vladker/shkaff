package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class I extends O implements V3.j {
    public I(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.AbstractC1102p
    public final V3.b computeReflected() {
        U.f5690a.getClass();
        return this;
    }

    @Override // V3.j
    public Object getDelegate() {
        return ((V3.j) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.internal.O, V3.o
    public final /* bridge */ /* synthetic */ V3.h getGetter() {
        getGetter();
        return null;
    }

    @Override // O3.a
    public final Object invoke() {
        return get();
    }

    public I(Object obj, Class cls, String str, String str2, int i5) {
        super(obj, cls, str, str2, i5);
    }

    @Override // kotlin.jvm.internal.O, V3.o
    public final V3.i getGetter() {
        ((V3.j) getReflected()).getGetter();
        return null;
    }
}
