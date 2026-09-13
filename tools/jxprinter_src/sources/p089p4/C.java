package p089p4;

import java.util.Map;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.X;
import p060k4.b;
import p066l4.a;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C implements b {
    public static final C INSTANCE = new C();
    private static final r descriptor = B.INSTANCE;

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.a
    public A deserialize(j decoder) {
        E.f(decoder, "decoder");
        q.asJsonDecoder(decoder);
        return new A((Map) a.MapSerializer(a.serializer(X.INSTANCE), o.INSTANCE).deserialize(decoder));
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(l encoder, A value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        q.asJsonEncoder(encoder);
        a.MapSerializer(a.serializer(X.INSTANCE), o.INSTANCE).serialize(encoder, value);
    }
}
