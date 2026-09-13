package p095q4;

import java.util.List;
import kotlin.jvm.internal.E;
import p060k4.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends c {
    private final b serializer;

    public a(b serializer) {
        E.f(serializer, "serializer");
        this.serializer = serializer;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && E.a(((a) obj).serializer, this.serializer);
    }

    public final b getSerializer() {
        return this.serializer;
    }

    public final int hashCode() {
        return this.serializer.hashCode();
    }

    @Override // p095q4.c
    public b invoke(List<? extends b> typeArgumentsSerializers) {
        E.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        return this.serializer;
    }
}
