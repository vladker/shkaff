package org.apache.commons.compress.harmony.pack200;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPLong extends CPConstant {
    private final long theLong;

    public CPLong(long j6) {
        this.theLong = j6;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        long j6 = this.theLong;
        long j7 = ((CPLong) obj).theLong;
        if (j6 > j7) {
            return 1;
        }
        return j6 == j7 ? 0 : -1;
    }

    public long getLong() {
        return this.theLong;
    }

    public String toString() {
        return "" + this.theLong;
    }
}
