package kotlinx.serialization.json.internal;

import W3.InterfaceC0233q;
import p089p4.AbstractC1519d;
import p089p4.EnumC1517b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class N {
    public static final <T> T decodeByReader(AbstractC1519d json, p060k4.a deserializer, InterfaceC1145v reader) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        kotlin.jvm.internal.E.f(reader, "reader");
        a0 a0VarReaderJsonLexer = b0.ReaderJsonLexer(json, reader, C1136l.INSTANCE.take());
        try {
            T t6 = (T) new d0(json, m0.OBJ, a0VarReaderJsonLexer, deserializer.getDescriptor(), null).decodeSerializableValue(deserializer);
            a0VarReaderJsonLexer.m();
            return t6;
        } finally {
            a0VarReaderJsonLexer.x();
        }
    }

    public static final <T> InterfaceC0233q decodeToSequenceByReader(AbstractC1519d json, InterfaceC1145v reader, p060k4.a deserializer, EnumC1517b format) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(reader, "reader");
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        kotlin.jvm.internal.E.f(format, "format");
        return W3.z.constrainOnce(new W3.v(G.JsonIterator(format, json, b0.ReaderJsonLexer(json, reader, new char[16384]), deserializer), 1));
    }

    public static final <T> void encodeByWriter(AbstractC1519d json, InterfaceC1147x writer, p060k4.m serializer, T t6) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(writer, "writer");
        kotlin.jvm.internal.E.f(serializer, "serializer");
        new e0(writer, json, m0.OBJ, new p089p4.r[m0.getEntries().size()]).encodeSerializableValue(serializer, t6);
    }

    public static final <T> InterfaceC0233q decodeToSequenceByReader(AbstractC1519d json, InterfaceC1145v reader, EnumC1517b format) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(reader, "reader");
        kotlin.jvm.internal.E.f(format, "format");
        json.getSerializersModule();
        kotlin.jvm.internal.E.l();
        throw null;
    }
}
