package org.apache.commons.compress.harmony.pack200;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPDouble extends CPConstant {
    private final double theDouble;

    public CPDouble(double d) {
        this.theDouble = d;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Double.compare(this.theDouble, ((CPDouble) obj).theDouble);
    }

    public double getDouble() {
        return this.theDouble;
    }
}
