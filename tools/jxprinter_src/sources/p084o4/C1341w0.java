package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p060k4.l;
import p072m4.r;
import p078n4.j;

/* JADX INFO: renamed from: o4.w0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1341w0 implements b {
    public static final C1341w0 INSTANCE = new C1341w0();
    private static final r descriptor = C1339v0.INSTANCE;

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.a
    public Void deserialize(j decoder) {
        E.f(decoder, "decoder");
        throw new l("'kotlin.Nothing' does not have instances");
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(p078n4.l encoder, Void value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        throw new l("'kotlin.Nothing' cannot be serialized");
    }
}
