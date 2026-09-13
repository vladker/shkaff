package p028e4;

import A3.AbstractC0157z;
import p007a4.F;

/* JADX INFO: renamed from: e4.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0659m {
    public static final void a(int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final F namedOrThis(F f6, String str) {
        return str != null ? new z(f6, str) : f6;
    }
}
