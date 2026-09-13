package X3;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class P extends O {
    private static final G toRegex(Pattern pattern) {
        kotlin.jvm.internal.E.f(pattern, "<this>");
        return new G(pattern);
    }
}
