package kotlinx.serialization.json.internal;

import p089p4.AbstractC1519d;
import p089p4.C1521f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class S extends AbstractC1128d {
    public final int b;
    public int c;
    private final C1521f value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(AbstractC1519d json, C1521f value) {
        super(json, value, null);
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(value, "value");
        this.value = value;
        this.b = getValue().size();
        this.c = -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d
    public p089p4.m currentElement(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        return getValue().get(Integer.parseInt(tag));
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d, p084o4.AbstractC1333s0, p084o4.W0, p078n4.f, p089p4.k
    public int decodeElementIndex(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        int i5 = this.c;
        if (i5 >= this.b - 1) {
            return -1;
        }
        int i6 = i5 + 1;
        this.c = i6;
        return i6;
    }

    @Override // p084o4.AbstractC1333s0
    public String elementName(p072m4.r descriptor, int i5) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return String.valueOf(i5);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d
    public C1521f getValue() {
        return this.value;
    }
}
