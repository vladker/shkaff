package kotlinx.serialization.json.internal;

import java.util.Map;
import p089p4.AbstractC1519d;
import p089p4.C1521f;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class V extends Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5729a;
    public boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(AbstractC1519d json, O3.l nodeConsumer) {
        super(json, nodeConsumer);
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(nodeConsumer, "nodeConsumer");
        this.b = true;
    }

    @Override // kotlinx.serialization.json.internal.Q, kotlinx.serialization.json.internal.AbstractC1131g
    public p089p4.m getCurrent() {
        return new p089p4.A(getContent());
    }

    @Override // kotlinx.serialization.json.internal.Q, kotlinx.serialization.json.internal.AbstractC1131g
    public void putElement(String key, p089p4.m element) {
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(element, "element");
        if (!this.b) {
            Map<String, p089p4.m> content = getContent();
            String str = this.f5729a;
            if (str == null) {
                kotlin.jvm.internal.E.m("tag");
                throw null;
            }
            content.put(str, element);
            this.b = true;
            return;
        }
        if (element instanceof p089p4.E) {
            this.f5729a = ((p089p4.E) element).getContent();
            this.b = false;
        } else {
            if (element instanceof p089p4.A) {
                throw E.InvalidKeyKindException(p089p4.C.INSTANCE.getDescriptor());
            }
            if (!(element instanceof C1521f)) {
                throw new C1937q();
            }
            throw E.InvalidKeyKindException(p089p4.h.INSTANCE.getDescriptor());
        }
    }
}
