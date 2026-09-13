package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.n;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U0 implements b {
    public static final U0 INSTANCE = new U0();
    private static final r descriptor = new M0("kotlin.Short", n.INSTANCE);

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* bridge */ /* synthetic */ void serialize(l lVar, Object obj) {
        serialize(lVar, ((Number) obj).shortValue());
    }

    @Override // p060k4.b, p060k4.a
    public Short deserialize(j decoder) {
        E.f(decoder, "decoder");
        return Short.valueOf(decoder.d());
    }

    public void serialize(l encoder, short s6) {
        E.f(encoder, "encoder");
        encoder.a(s6);
    }
}
