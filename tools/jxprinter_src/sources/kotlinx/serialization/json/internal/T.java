package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import p089p4.AbstractC1519d;
import p089p4.C1521f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class T extends AbstractC1131g {
    private final ArrayList<p089p4.m> array;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(AbstractC1519d json, O3.l nodeConsumer) {
        super(json, nodeConsumer);
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(nodeConsumer, "nodeConsumer");
        this.array = new ArrayList<>();
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1131g, p084o4.AbstractC1335t0
    public String elementName(p072m4.r descriptor, int i5) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return String.valueOf(i5);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1131g
    public p089p4.m getCurrent() {
        return new C1521f(this.array);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1131g
    public void putElement(String key, p089p4.m element) {
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(element, "element");
        this.array.add(Integer.parseInt(key), element);
    }
}
