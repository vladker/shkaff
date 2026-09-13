package A4;

import A3.AbstractC0139g;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class S extends AbstractC0139g implements RandomAccess {
    public static final Q Companion = new Q();
    private final C0173p[] byteStrings;
    private final int[] trie;

    public S(C0173p[] c0173pArr, int[] iArr) {
        this.byteStrings = c0173pArr;
        this.trie = iArr;
    }

    public static final S of(C0173p... c0173pArr) {
        return Companion.of(c0173pArr);
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        return this.byteStrings.length;
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C0173p) {
            return super.contains((C0173p) obj);
        }
        return false;
    }

    public final C0173p[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof C0173p) {
            return super.indexOf((C0173p) obj);
        }
        return -1;
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof C0173p) {
            return super.lastIndexOf((C0173p) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public C0173p get(int i5) {
        return this.byteStrings[i5];
    }
}
