package p072m4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z {
    public final int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String simpleName = U.a(getClass()).getSimpleName();
        E.c(simpleName);
        return simpleName;
    }
}
