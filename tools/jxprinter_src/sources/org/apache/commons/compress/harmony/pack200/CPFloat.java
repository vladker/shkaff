package org.apache.commons.compress.harmony.pack200;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPFloat extends CPConstant {
    private final float theFloat;

    public CPFloat(float f6) {
        this.theFloat = f6;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Float.compare(this.theFloat, ((CPFloat) obj).theFloat);
    }

    public float getFloat() {
        return this.theFloat;
    }
}
