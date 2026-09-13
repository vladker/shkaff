package org.apache.commons.compress.harmony.pack200;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPInt extends CPConstant {
    private final int theInt;

    public CPInt(int i5) {
        this.theInt = i5;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        int i5 = this.theInt;
        int i6 = ((CPInt) obj).theInt;
        if (i5 > i6) {
            return 1;
        }
        return i5 == i6 ? 0 : -1;
    }

    public int getInt() {
        return this.theInt;
    }
}
