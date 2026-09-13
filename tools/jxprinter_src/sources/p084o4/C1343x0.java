package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: renamed from: o4.x0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1343x0 implements b {
    private final r descriptor;
    private final b serializer;

    public C1343x0(b serializer) {
        E.f(serializer, "serializer");
        this.serializer = serializer;
        this.descriptor = new P0(serializer.getDescriptor());
    }

    @Override // p060k4.b, p060k4.a
    public Object deserialize(j decoder) {
        E.f(decoder, "decoder");
        return decoder.decodeNotNullMark() ? decoder.decodeSerializableValue(this.serializer) : decoder.decodeNull();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C1343x0.class == obj.getClass() && E.a(this.serializer, ((C1343x0) obj).serializer);
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return this.descriptor;
    }

    public final int hashCode() {
        return this.serializer.hashCode();
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(l encoder, Object obj) {
        E.f(encoder, "encoder");
        if (obj == null) {
            encoder.encodeNull();
        } else {
            encoder.encodeNotNullMark();
            encoder.encodeSerializableValue(this.serializer, obj);
        }
    }
}
