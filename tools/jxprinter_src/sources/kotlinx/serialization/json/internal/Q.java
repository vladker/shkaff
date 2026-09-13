package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Q extends AbstractC1131g {
    private final Map<String, p089p4.m> content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(AbstractC1519d json, O3.l nodeConsumer) {
        super(json, nodeConsumer);
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(nodeConsumer, "nodeConsumer");
        this.content = new LinkedHashMap();
    }

    @Override // p084o4.X0, p078n4.h, p089p4.r
    public <T> void encodeNullableSerializableElement(p072m4.r descriptor, int i5, p060k4.m serializer, T t6) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        kotlin.jvm.internal.E.f(serializer, "serializer");
        if (t6 != null || this.configuration.f7759f) {
            super.encodeNullableSerializableElement(descriptor, i5, serializer, t6);
        }
    }

    public final Map<String, p089p4.m> getContent() {
        return this.content;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1131g
    public p089p4.m getCurrent() {
        return new p089p4.A(this.content);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1131g
    public void putElement(String key, p089p4.m element) {
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(element, "element");
        this.content.put(key, element);
    }
}
