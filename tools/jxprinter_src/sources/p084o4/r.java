package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.i;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements b {
    public static final r INSTANCE = new r();
    private static final p072m4.r descriptor = new M0("kotlin.Char", i.INSTANCE);

    @Override // p060k4.b, p060k4.m, p060k4.a
    public p072m4.r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* bridge */ /* synthetic */ void serialize(l lVar, Object obj) {
        serialize(lVar, ((Character) obj).charValue());
    }

    @Override // p060k4.b, p060k4.a
    public Character deserialize(j decoder) {
        E.f(decoder, "decoder");
        return Character.valueOf(decoder.e());
    }

    public void serialize(l encoder, char c) {
        E.f(encoder, "encoder");
        encoder.e(c);
    }
}
