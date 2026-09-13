package kotlinx.serialization.json.internal;

import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class r {
    public static final C1138n Composer(InterfaceC1147x sb, AbstractC1519d json) {
        kotlin.jvm.internal.E.f(sb, "sb");
        kotlin.jvm.internal.E.f(json, "json");
        return json.getConfiguration().e ? new C1141q(sb, json) : new C1138n(sb);
    }
}
