package X3;

import java.util.Map;

/* JADX INFO: renamed from: X3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0237c {
    public final EnumC0238d valueOf(int i5) {
        EnumC0238d enumC0238d = (EnumC0238d) ((Map) EnumC0238d.directionalityMap$delegate.getValue()).get(Integer.valueOf(i5));
        if (enumC0238d != null) {
            return enumC0238d;
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Directionality #", " is not defined."));
    }
}
