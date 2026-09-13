package p084o4;

import p060k4.b;
import p072m4.j;
import p072m4.r;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E implements b {
    public static final E INSTANCE = new E();
    private static final r descriptor = new M0("kotlin.Double", j.INSTANCE);

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* bridge */ /* synthetic */ void serialize(l lVar, Object obj) {
        serialize(lVar, ((Number) obj).doubleValue());
    }

    @Override // p060k4.b, p060k4.a
    public Double deserialize(p078n4.j decoder) {
        kotlin.jvm.internal.E.f(decoder, "decoder");
        return Double.valueOf(decoder.a());
    }

    public void serialize(l encoder, double d) {
        kotlin.jvm.internal.E.f(encoder, "encoder");
        encoder.h(d);
    }
}
