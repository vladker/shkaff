package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.h;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: renamed from: o4.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1319l implements b {
    public static final C1319l INSTANCE = new C1319l();
    private static final r descriptor = new M0("kotlin.Byte", h.INSTANCE);

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* bridge */ /* synthetic */ void serialize(l lVar, Object obj) {
        serialize(lVar, ((Number) obj).byteValue());
    }

    @Override // p060k4.b, p060k4.a
    public Byte deserialize(j decoder) {
        E.f(decoder, "decoder");
        return Byte.valueOf(decoder.b());
    }

    public void serialize(l encoder, byte b) {
        E.f(encoder, "encoder");
        encoder.f(b);
    }
}
