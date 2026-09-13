package kotlinx.serialization.json.internal;

import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class M extends AbstractC1131g {
    private p089p4.m content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(AbstractC1519d json, O3.l nodeConsumer) {
        super(json, nodeConsumer);
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(nodeConsumer, "nodeConsumer");
        k(l0.PRIMITIVE_TAG);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1131g
    public p089p4.m getCurrent() {
        p089p4.m mVar = this.content;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?");
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1131g
    public void putElement(String key, p089p4.m element) {
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(element, "element");
        if (key != l0.PRIMITIVE_TAG) {
            throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag");
        }
        if (this.content != null) {
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?");
        }
        this.content = element;
        getNodeConsumer().invoke(element);
    }
}
