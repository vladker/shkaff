package kotlinx.serialization.json.internal;

import java.util.List;
import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class U extends P {
    public final int d;
    public int e;
    private final List<String> keys;
    private final p089p4.A value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(AbstractC1519d json, p089p4.A value) {
        super(json, value, (String) null, 12);
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(value, "value");
        this.value = value;
        List<String> list = A3.T.toList(getValue().getKeys());
        this.keys = list;
        this.d = list.size() * 2;
        this.e = -1;
    }

    @Override // kotlinx.serialization.json.internal.P, kotlinx.serialization.json.internal.AbstractC1128d
    public p089p4.m currentElement(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        return this.e % 2 == 0 ? p089p4.n.JsonPrimitive(tag) : (p089p4.m) A3.k0.getValue(getValue(), tag);
    }

    @Override // kotlinx.serialization.json.internal.P, kotlinx.serialization.json.internal.AbstractC1128d, p084o4.AbstractC1333s0, p084o4.W0, p078n4.f, p089p4.k
    public int decodeElementIndex(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        int i5 = this.e;
        if (i5 >= this.d - 1) {
            return -1;
        }
        int i6 = i5 + 1;
        this.e = i6;
        return i6;
    }

    @Override // kotlinx.serialization.json.internal.P, p084o4.AbstractC1333s0
    public String elementName(p072m4.r descriptor, int i5) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return this.keys.get(i5 / 2);
    }

    @Override // kotlinx.serialization.json.internal.P, kotlinx.serialization.json.internal.AbstractC1128d, p084o4.W0, p078n4.f, p089p4.k
    public void endStructure(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.internal.P, kotlinx.serialization.json.internal.AbstractC1128d
    public p089p4.A getValue() {
        return this.value;
    }
}
