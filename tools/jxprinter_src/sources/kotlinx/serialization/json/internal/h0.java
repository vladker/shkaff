package kotlinx.serialization.json.internal;

import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h0 {
    public static final g0 StringJsonLexer(AbstractC1519d json, String source) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(source, "source");
        return !json.getConfiguration().f7766m ? new g0(source) : new i0(source);
    }
}
