package org.apache.commons.compress.harmony.pack200;

import java.io.EOFException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class BHSDCodec extends Codec {
    private final int b;
    private long cardinality;
    private final int d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f6707h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f6708l;
    private final long largest;
    private final long[] powers;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f6709s;
    private final long smallest;

    public BHSDCodec(int i5, int i6) {
        this(i5, i6, 0, 0);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    private long calculateLargest() {
        long jCardinality;
        long jCardinality2;
        long j6;
        if (this.d == 1) {
            return new BHSDCodec(this.b, this.f6707h).largest();
        }
        int i5 = this.f6709s;
        if (i5 != 0) {
            if (i5 == 1) {
                jCardinality2 = cardinality() / 2;
            } else {
                if (i5 != 2) {
                    throw new Error("Unknown s value");
                }
                jCardinality = ((cardinality() * 3) / 4) - 1;
            }
            if (this.f6709s == 0) {
                j6 = 4294967294L;
            } else {
                j6 = 2147483647L;
            }
            return Math.min(j6 - 1, jCardinality);
        }
        jCardinality2 = cardinality();
        jCardinality = jCardinality2 - 1;
        if (this.f6709s == 0) {
            j6 = 4294967294L;
        } else {
            j6 = 2147483647L;
        }
        return Math.min(j6 - 1, jCardinality);
    }

    private long calculateSmallest() {
        if (this.d == 1 || !isSigned()) {
            return this.cardinality >= 4294967296L ? -2147483648L : 0L;
        }
        return Math.max(-2147483648L, (-cardinality()) / ((long) (1 << this.f6709s)));
    }

    public long cardinality() {
        return this.cardinality;
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int decode(InputStream inputStream) throws Pack200Exception {
        if (this.d == 0) {
            return decode(inputStream, 0L);
        }
        throw new Pack200Exception("Delta encoding used without passing in last value; this is a coding error");
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int[] decodeInts(int i5, InputStream inputStream) {
        int[] iArrDecodeInts = super.decodeInts(i5, inputStream);
        if (isDelta()) {
            for (int i6 = 0; i6 < iArrDecodeInts.length; i6++) {
                while (true) {
                    int i7 = iArrDecodeInts[i6];
                    if (i7 <= this.largest) {
                        break;
                    }
                    iArrDecodeInts[i6] = (int) (((long) i7) - this.cardinality);
                }
                while (true) {
                    int i8 = iArrDecodeInts[i6];
                    if (i8 < this.smallest) {
                        iArrDecodeInts[i6] = (int) (((long) i8) + this.cardinality);
                    }
                }
            }
        }
        return iArrDecodeInts;
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public byte[] encode(int i5, int i6) throws Pack200Exception {
        long j6;
        long j7 = i5;
        if (!encodes(j7)) {
            throw new Pack200Exception("The codec " + toString() + " does not encode the value " + i5);
        }
        if (isDelta()) {
            j7 -= (long) i6;
        }
        if (isSigned()) {
            if (j7 < -2147483648L) {
                j7 += 4294967296L;
            } else if (j7 > 2147483647L) {
                j7 -= 4294967296L;
            }
            if (j7 < 0) {
                j7 = ((-j7) << this.f6709s) - 1;
            } else {
                int i7 = this.f6709s;
                j7 = i7 == 1 ? j7 << i7 : j7 + ((j7 - (j7 % 3)) / 3);
            }
        } else if (j7 < 0) {
            long j8 = this.cardinality;
            j7 = j8 < 4294967296L ? j7 + j8 : j7 + 4294967296L;
        }
        if (j7 < 0) {
            throw new Pack200Exception("unable to encode");
        }
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < this.b; i8++) {
            if (j7 < this.f6708l) {
                j6 = j7;
            } else {
                j6 = j7 % ((long) this.f6707h);
                while (j6 < this.f6708l) {
                    j6 += (long) this.f6707h;
                }
            }
            arrayList.add(Byte.valueOf((byte) j6));
            if (j6 < this.f6708l) {
                break;
            }
            j7 = (j7 - j6) / ((long) this.f6707h);
        }
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i9 = 0; i9 < size; i9++) {
            bArr[i9] = ((Byte) arrayList.get(i9)).byteValue();
        }
        return bArr;
    }

    public boolean encodes(long j6) {
        return j6 >= this.smallest && j6 <= this.largest;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BHSDCodec) {
            BHSDCodec bHSDCodec = (BHSDCodec) obj;
            if (bHSDCodec.b == this.b && bHSDCodec.f6707h == this.f6707h && bHSDCodec.f6709s == this.f6709s && bHSDCodec.d == this.d) {
                return true;
            }
        }
        return false;
    }

    public int getB() {
        return this.b;
    }

    public int getH() {
        return this.f6707h;
    }

    public int getL() {
        return this.f6708l;
    }

    public int getS() {
        return this.f6709s;
    }

    public int hashCode() {
        return (((((this.b * 37) + this.f6707h) * 37) + this.f6709s) * 37) + this.d;
    }

    public boolean isDelta() {
        return this.d != 0;
    }

    public boolean isSigned() {
        return this.f6709s != 0;
    }

    public long largest() {
        return this.largest;
    }

    public long smallest() {
        return this.smallest;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(11);
        stringBuffer.append('(');
        stringBuffer.append(this.b);
        stringBuffer.append(',');
        stringBuffer.append(this.f6707h);
        if (this.f6709s != 0 || this.d != 0) {
            stringBuffer.append(',');
            stringBuffer.append(this.f6709s);
        }
        if (this.d != 0) {
            stringBuffer.append(',');
            stringBuffer.append(this.d);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public BHSDCodec(int i5, int i6, int i7) {
        this(i5, i6, i7, 0);
    }

    public BHSDCodec(int i5, int i6, int i7, int i8) {
        if (i5 < 1 || i5 > 5) {
            throw new IllegalArgumentException("1<=b<=5");
        }
        if (i6 < 1 || i6 > 256) {
            throw new IllegalArgumentException("1<=h<=256");
        }
        if (i7 < 0 || i7 > 2) {
            throw new IllegalArgumentException("0<=s<=2");
        }
        if (i8 < 0 || i8 > 1) {
            throw new IllegalArgumentException("0<=d<=1");
        }
        if (i5 == 1 && i6 != 256) {
            throw new IllegalArgumentException("b=1 -> h=256");
        }
        if (i6 == 256 && i5 == 5) {
            throw new IllegalArgumentException("h=256 -> b!=5");
        }
        this.b = i5;
        this.f6707h = i6;
        this.f6709s = i7;
        this.d = i8;
        int i9 = 256 - i6;
        this.f6708l = i9;
        if (i6 == 1) {
            this.cardinality = (i5 * 255) + 1;
        } else {
            double d = i6;
            double d6 = i5;
            this.cardinality = (long) (Math.pow(d, d6) + ((long) (((1.0d - Math.pow(d, d6)) * ((double) i9)) / ((double) (1 - i6)))));
        }
        this.smallest = calculateSmallest();
        this.largest = calculateLargest();
        this.powers = new long[i5];
        for (int i10 = 0; i10 < i5; i10++) {
            this.powers[i10] = (long) Math.pow(i6, i10);
        }
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int decode(InputStream inputStream, long j6) throws EOFException {
        long j7;
        int i5 = 0;
        long j8 = 0;
        do {
            j7 = inputStream.read();
            this.lastBandLength++;
            j8 += this.powers[i5] * j7;
            i5++;
            if (j7 < this.f6708l) {
                break;
            }
        } while (i5 < this.b);
        if (j7 != -1) {
            if (isSigned()) {
                int i6 = this.f6709s;
                long j9 = (1 << i6) - 1;
                j8 = (j8 & j9) == j9 ? ~(j8 >>> i6) : j8 - (j8 >>> i6);
            }
            if (isDelta()) {
                j8 += j6;
            }
            return (int) j8;
        }
        throw new EOFException("End of stream reached whilst decoding");
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int[] decodeInts(int i5, InputStream inputStream, int i6) {
        int[] iArrDecodeInts = super.decodeInts(i5, inputStream, i6);
        if (isDelta()) {
            for (int i7 = 0; i7 < iArrDecodeInts.length; i7++) {
                while (true) {
                    int i8 = iArrDecodeInts[i7];
                    if (i8 <= this.largest) {
                        break;
                    }
                    iArrDecodeInts[i7] = (int) (((long) i8) - this.cardinality);
                }
                while (true) {
                    int i9 = iArrDecodeInts[i7];
                    if (i9 < this.smallest) {
                        iArrDecodeInts[i7] = (int) (((long) i9) + this.cardinality);
                    }
                }
            }
        }
        return iArrDecodeInts;
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public byte[] encode(int i5) {
        return encode(i5, 0);
    }
}
