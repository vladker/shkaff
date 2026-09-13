package A3;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class L extends J {
    public static <T> Iterator<T> iterator(Enumeration<T> enumeration) {
        kotlin.jvm.internal.E.f(enumeration, "<this>");
        return new K(enumeration);
    }
}
