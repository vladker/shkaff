package p095q4;

import V3.c;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String msg) {
        super(msg);
        E.f(msg, "msg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(c baseClass, c concreteClass) {
        this("Serializer for " + concreteClass + " already registered in the scope of " + baseClass);
        E.f(baseClass, "baseClass");
        E.f(concreteClass, "concreteClass");
    }
}
