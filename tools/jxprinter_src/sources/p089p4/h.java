package p089p4;

import java.util.List;
import kotlin.jvm.internal.E;
import p060k4.b;
import p066l4.a;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements b {
    public static final h INSTANCE = new h();
    private static final r descriptor = C1522g.INSTANCE;

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.a
    public C1521f deserialize(j decoder) {
        E.f(decoder, "decoder");
        q.asJsonDecoder(decoder);
        return new C1521f((List) a.ListSerializer(o.INSTANCE).deserialize(decoder));
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(l encoder, C1521f value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        q.asJsonEncoder(encoder);
        a.ListSerializer(o.INSTANCE).serialize(encoder, value);
    }
}
