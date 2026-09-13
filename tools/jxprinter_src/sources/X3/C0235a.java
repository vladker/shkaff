package X3;

/* JADX INFO: renamed from: X3.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0235a {
    public final EnumC0236b valueOf(int i5) {
        if (i5 >= 0 && i5 < 17) {
            return (EnumC0236b) EnumC0236b.getEntries().get(i5);
        }
        if (18 > i5 || i5 >= 31) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Category #", " is not defined."));
        }
        return (EnumC0236b) EnumC0236b.getEntries().get(i5 - 1);
    }
}
