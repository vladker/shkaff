package org.apache.commons.compress.harmony.pack200;

import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RunCodec extends Codec {
    private final Codec aCodec;
    private final Codec bCodec;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6717k;
    private int last;

    public RunCodec(int i5, Codec codec, Codec codec2) throws Pack200Exception {
        if (i5 <= 0) {
            throw new Pack200Exception("Cannot have a RunCodec for a negative number of numbers");
        }
        if (codec == null || codec2 == null) {
            throw new Pack200Exception("Must supply both codecs for a RunCodec");
        }
        this.f6717k = i5;
        this.aCodec = codec;
        this.bCodec = codec2;
    }

    private int normalise(int i5, Codec codec) {
        if (codec instanceof BHSDCodec) {
            BHSDCodec bHSDCodec = (BHSDCodec) codec;
            if (bHSDCodec.isDelta()) {
                long jCardinality = bHSDCodec.cardinality();
                while (true) {
                    long j6 = i5;
                    if (j6 <= bHSDCodec.largest()) {
                        break;
                    }
                    i5 = (int) (j6 - jCardinality);
                }
                while (true) {
                    long j7 = i5;
                    if (j7 >= bHSDCodec.smallest()) {
                        break;
                    }
                    i5 = (int) (j7 + jCardinality);
                }
            }
        }
        return i5;
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int decode(InputStream inputStream) {
        return decode(inputStream, this.last);
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int[] decodeInts(int i5, InputStream inputStream) {
        int[] iArr = new int[i5];
        int[] iArrDecodeInts = this.aCodec.decodeInts(this.f6717k, inputStream);
        normalise(iArrDecodeInts, this.aCodec);
        int[] iArrDecodeInts2 = this.bCodec.decodeInts(i5 - this.f6717k, inputStream);
        normalise(iArrDecodeInts2, this.bCodec);
        System.arraycopy(iArrDecodeInts, 0, iArr, 0, this.f6717k);
        int i6 = this.f6717k;
        System.arraycopy(iArrDecodeInts2, 0, iArr, i6, i5 - i6);
        this.lastBandLength = this.aCodec.lastBandLength + this.bCodec.lastBandLength;
        return iArr;
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public byte[] encode(int i5, int i6) throws Pack200Exception {
        throw new Pack200Exception("Must encode entire band at once with a RunCodec");
    }

    public Codec getACodec() {
        return this.aCodec;
    }

    public Codec getBCodec() {
        return this.bCodec;
    }

    public int getK() {
        return this.f6717k;
    }

    public String toString() {
        return "RunCodec[k=" + this.f6717k + ";aCodec=" + this.aCodec + "bCodec=" + this.bCodec + "]";
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int decode(InputStream inputStream, long j6) {
        int i5 = this.f6717k - 1;
        this.f6717k = i5;
        if (i5 >= 0) {
            int iDecode = this.aCodec.decode(inputStream, this.last);
            this.last = this.f6717k == 0 ? 0 : iDecode;
            return normalise(iDecode, this.aCodec);
        }
        int iDecode2 = this.bCodec.decode(inputStream, this.last);
        this.last = iDecode2;
        return normalise(iDecode2, this.bCodec);
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public byte[] encode(int i5) throws Pack200Exception {
        throw new Pack200Exception("Must encode entire band at once with a RunCodec");
    }

    private void normalise(int[] iArr, Codec codec) {
        int i5 = 0;
        if (codec instanceof BHSDCodec) {
            BHSDCodec bHSDCodec = (BHSDCodec) codec;
            if (bHSDCodec.isDelta()) {
                long jCardinality = bHSDCodec.cardinality();
                while (i5 < iArr.length) {
                    while (iArr[i5] > bHSDCodec.largest()) {
                        iArr[i5] = (int) (((long) iArr[i5]) - jCardinality);
                    }
                    while (iArr[i5] < bHSDCodec.smallest()) {
                        iArr[i5] = (int) (((long) iArr[i5]) + jCardinality);
                    }
                    i5++;
                }
                return;
            }
            return;
        }
        if (codec instanceof PopulationCodec) {
            PopulationCodec populationCodec = (PopulationCodec) codec;
            int[] iArr2 = (int[]) populationCodec.getFavoured().clone();
            Arrays.sort(iArr2);
            while (i5 < iArr.length) {
                Codec favouredCodec = Arrays.binarySearch(iArr2, iArr[i5]) > -1 ? populationCodec.getFavouredCodec() : populationCodec.getUnfavouredCodec();
                if (favouredCodec instanceof BHSDCodec) {
                    BHSDCodec bHSDCodec2 = (BHSDCodec) favouredCodec;
                    if (bHSDCodec2.isDelta()) {
                        long jCardinality2 = bHSDCodec2.cardinality();
                        while (iArr[i5] > bHSDCodec2.largest()) {
                            iArr[i5] = (int) (((long) iArr[i5]) - jCardinality2);
                        }
                        while (iArr[i5] < bHSDCodec2.smallest()) {
                            iArr[i5] = (int) (((long) iArr[i5]) + jCardinality2);
                        }
                    }
                }
                i5++;
            }
        }
    }
}
