package org.apache.commons.compress.harmony.pack200;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPUTF8 extends ConstantPoolEntry implements Comparable {
    private final String string;

    public CPUTF8(String str) {
        this.string = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return this.string.compareTo(((CPUTF8) obj).string);
    }

    public String getUnderlyingString() {
        return this.string;
    }

    public String toString() {
        return this.string;
    }
}
