package kotlinx.serialization.json.internal;

import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class L extends AbstractC1128d {
    private final p089p4.m value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(AbstractC1519d json, p089p4.m value, String str) {
        super(json, value, str);
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(value, "value");
        this.value = value;
        j(l0.PRIMITIVE_TAG);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d
    public p089p4.m currentElement(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        if (tag == l0.PRIMITIVE_TAG) {
            return getValue();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag");
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d, p084o4.AbstractC1333s0, p084o4.W0, p078n4.f, p089p4.k
    public int decodeElementIndex(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d
    public p089p4.m getValue() {
        return this.value;
    }
}
