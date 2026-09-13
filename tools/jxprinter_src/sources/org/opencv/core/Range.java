package org.opencv.core;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Range {
    public int end;
    public int start;

    public Range(int i5, int i6) {
        this.start = i5;
        this.end = i6;
    }

    public static Range all() {
        return new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean empty() {
        return this.end <= this.start;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.start == range.start && this.end == range.end;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.start);
        int i5 = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.end);
        return (i5 * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public Range intersection(Range range) {
        Range range2 = new Range(Math.max(range.start, this.start), Math.min(range.end, this.end));
        range2.end = Math.max(range2.end, range2.start);
        return range2;
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.start = dArr.length > 0 ? (int) dArr[0] : 0;
            this.end = dArr.length > 1 ? (int) dArr[1] : 0;
        } else {
            this.start = 0;
            this.end = 0;
        }
    }

    public Range shift(int i5) {
        return new Range(this.start + i5, this.end + i5);
    }

    public int size() {
        if (empty()) {
            return 0;
        }
        return this.end - this.start;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.start);
        sb.append(", ");
        return AbstractC0157z.l(")", this.end, sb);
    }

    public Range clone() {
        return new Range(this.start, this.end);
    }

    public Range() {
        this(0, 0);
    }

    public Range(double[] dArr) {
        set(dArr);
    }
}
