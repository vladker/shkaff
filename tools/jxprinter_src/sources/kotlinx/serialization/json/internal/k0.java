package kotlinx.serialization.json.internal;

import p089p4.AbstractC1519d;
import p089p4.C1521f;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class k0 {
    public static final <T> T readJson(AbstractC1519d json, p089p4.m element, p060k4.a deserializer) {
        AbstractC1128d l6;
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(element, "element");
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        String str = null;
        if (element instanceof p089p4.A) {
            l6 = new P(json, (p089p4.A) element, str, 12);
        } else if (element instanceof C1521f) {
            l6 = new S(json, (C1521f) element);
        } else {
            if (!(element instanceof p089p4.s) && !element.equals(p089p4.x.INSTANCE)) {
                throw new C1937q();
            }
            l6 = new L(json, (p089p4.E) element, null);
        }
        return (T) l6.decodeSerializableValue(deserializer);
    }

    public static final <T> T readPolymorphicJson(AbstractC1519d abstractC1519d, String discriminator, p089p4.A element, p060k4.a deserializer) {
        kotlin.jvm.internal.E.f(abstractC1519d, "<this>");
        kotlin.jvm.internal.E.f(discriminator, "discriminator");
        kotlin.jvm.internal.E.f(element, "element");
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        return (T) new P(abstractC1519d, element, discriminator, deserializer.getDescriptor()).decodeSerializableValue(deserializer);
    }
}
