package kotlinx.serialization.json.internal;

import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class l0 {
    public static final String PRIMITIVE_TAG = "primitive";

    public static final <T> p089p4.m writeJson(AbstractC1519d json, T t6, p060k4.m serializer) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(serializer, "serializer");
        kotlin.jvm.internal.T t7 = new kotlin.jvm.internal.T();
        new Q(json, new S2.k(1, t7)).encodeSerializableValue(serializer, t6);
        Object obj = t7.f5689a;
        if (obj != null) {
            return (p089p4.m) obj;
        }
        kotlin.jvm.internal.E.m("result");
        throw null;
    }
}
