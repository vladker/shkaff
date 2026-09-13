package X3;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Q extends P {
    private static final G toRegex(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return new G(str);
    }

    private static final G toRegex(String str, K option) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(option, "option");
        return new G(str, option);
    }

    private static final G toRegex(String str, Set<? extends K> options) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(options, "options");
        return new G(str, options);
    }
}
