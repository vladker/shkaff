package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.l;
import p072m4.r;
import p078n4.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z implements b {
    public static final Z INSTANCE = new Z();
    private static final r descriptor = new M0("kotlin.Int", l.INSTANCE);

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* bridge */ /* synthetic */ void serialize(p078n4.l lVar, Object obj) {
        serialize(lVar, ((Number) obj).intValue());
    }

    @Override // p060k4.b, p060k4.a
    public Integer deserialize(j decoder) {
        E.f(decoder, "decoder");
        return Integer.valueOf(decoder.f());
    }

    public void serialize(p078n4.l encoder, int i5) {
        E.f(encoder, "encoder");
        encoder.c(i5);
    }
}
