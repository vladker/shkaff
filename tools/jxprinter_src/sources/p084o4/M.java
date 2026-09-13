package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.k;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M implements b {
    public static final M INSTANCE = new M();
    private static final r descriptor = new M0("kotlin.Float", k.INSTANCE);

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* bridge */ /* synthetic */ void serialize(l lVar, Object obj) {
        serialize(lVar, ((Number) obj).floatValue());
    }

    @Override // p060k4.b, p060k4.a
    public Float deserialize(j decoder) {
        E.f(decoder, "decoder");
        return Float.valueOf(decoder.g());
    }

    public void serialize(l encoder, float f6) {
        E.f(encoder, "encoder");
        encoder.g(f6);
    }
}
