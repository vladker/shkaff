package T2;

import kotlin.jvm.internal.E;
import p049i4.b;
import p049i4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final void tryUnlock(b bVar) {
        E.f(bVar, "<this>");
        try {
            if (((g) bVar).c()) {
                ((g) bVar).unlock(null);
            }
        } catch (Exception unused) {
        }
    }
}
