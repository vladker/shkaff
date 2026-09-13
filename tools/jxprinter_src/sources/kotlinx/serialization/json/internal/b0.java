package kotlinx.serialization.json.internal;

import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b0 {
    public static final a0 ReaderJsonLexer(AbstractC1519d json, InterfaceC1145v reader, char[] buffer) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(reader, "reader");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        return !json.getConfiguration().f7766m ? new a0(reader, buffer) : new c0(reader, buffer);
    }
}
