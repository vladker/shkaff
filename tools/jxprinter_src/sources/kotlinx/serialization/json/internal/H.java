package kotlinx.serialization.json.internal;

import java.util.Iterator;
import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class H implements Iterator, P3.a {
    private final p060k4.a deserializer;
    private final AbstractC1519d json;
    private final a0 lexer;

    public H(AbstractC1519d json, a0 lexer, p060k4.a deserializer) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(lexer, "lexer");
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        this.json = json;
        this.lexer = lexer;
        this.deserializer = deserializer;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.lexer.q() != 10;
    }

    @Override // java.util.Iterator
    public final Object next() {
        return new d0(this.json, m0.OBJ, this.lexer, this.deserializer.getDescriptor(), null).decodeSerializableValue(this.deserializer);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
