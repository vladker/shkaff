package org.apache.commons.compress.harmony.pack200;

import A3.AbstractC0157z;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PopulationCodec extends Codec {
    private int[] favoured;
    private final Codec favouredCodec;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6716l;
    private Codec tokenCodec;
    private final Codec unfavouredCodec;

    public PopulationCodec(Codec codec, Codec codec2, Codec codec3) {
        this.favouredCodec = codec;
        this.tokenCodec = codec2;
        this.unfavouredCodec = codec3;
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int decode(InputStream inputStream) throws Pack200Exception {
        throw new Pack200Exception("Population encoding does not work unless the number of elements are known");
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int[] decodeInts(int i5, InputStream inputStream) throws Pack200Exception {
        this.lastBandLength = 0;
        this.favoured = new int[i5];
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        int i8 = -1;
        while (true) {
            int iDecode = this.favouredCodec.decode(inputStream, i7);
            if (i8 > -1 && (iDecode == i6 || iDecode == i7)) {
                break;
            }
            i8++;
            this.favoured[i8] = iDecode;
            int iAbs = Math.abs(i6);
            int iAbs2 = Math.abs(iDecode);
            if (iAbs > iAbs2) {
                i6 = iDecode;
            } else if (iAbs == iAbs2) {
                i6 = iAbs;
            }
            i7 = iDecode;
        }
        this.lastBandLength += i8;
        if (this.tokenCodec == null) {
            if (i8 < 256) {
                this.tokenCodec = Codec.BYTE1;
            } else {
                int i9 = 1;
                while (true) {
                    i9++;
                    if (i9 >= 5) {
                        break;
                    }
                    BHSDCodec bHSDCodec = new BHSDCodec(i9, 256 - this.f6716l, 0);
                    if (bHSDCodec.encodes(i8)) {
                        this.tokenCodec = bHSDCodec;
                        break;
                    }
                }
                if (this.tokenCodec == null) {
                    StringBuilder sbT = AbstractC0157z.t(i8, "Cannot calculate token codec from ", " and ");
                    sbT.append(this.f6716l);
                    throw new Pack200Exception(sbT.toString());
                }
            }
        }
        this.lastBandLength += i5;
        int[] iArrDecodeInts = this.tokenCodec.decodeInts(i5, inputStream);
        int iDecode2 = 0;
        for (int i10 = 0; i10 < i5; i10++) {
            int i11 = iArrDecodeInts[i10];
            if (i11 == 0) {
                this.lastBandLength++;
                iDecode2 = this.unfavouredCodec.decode(inputStream, iDecode2);
                iArrDecodeInts[i10] = iDecode2;
            } else {
                iArrDecodeInts[i10] = this.favoured[i11 - 1];
            }
        }
        return iArrDecodeInts;
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public byte[] encode(int i5, int i6) throws Pack200Exception {
        throw new Pack200Exception("Population encoding does not work unless the number of elements are known");
    }

    public int[] getFavoured() {
        return this.favoured;
    }

    public Codec getFavouredCodec() {
        return this.favouredCodec;
    }

    public Codec getTokenCodec() {
        return this.tokenCodec;
    }

    public Codec getUnfavouredCodec() {
        return this.unfavouredCodec;
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public int decode(InputStream inputStream, long j6) throws Pack200Exception {
        throw new Pack200Exception("Population encoding does not work unless the number of elements are known");
    }

    @Override // org.apache.commons.compress.harmony.pack200.Codec
    public byte[] encode(int i5) throws Pack200Exception {
        throw new Pack200Exception("Population encoding does not work unless the number of elements are known");
    }

    public byte[] encode(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int[] iArr4 = new int[length + 1];
        System.arraycopy(iArr, 0, iArr4, 0, iArr.length);
        iArr4[length] = iArr[iArr.length - 1];
        byte[] bArrEncode = this.favouredCodec.encode(iArr4);
        byte[] bArrEncode2 = this.tokenCodec.encode(iArr2);
        byte[] bArrEncode3 = this.unfavouredCodec.encode(iArr3);
        byte[] bArr = new byte[bArrEncode.length + bArrEncode2.length + bArrEncode3.length];
        System.arraycopy(bArrEncode, 0, bArr, 0, bArrEncode.length);
        System.arraycopy(bArrEncode2, 0, bArr, bArrEncode.length, bArrEncode2.length);
        System.arraycopy(bArrEncode3, 0, bArr, bArrEncode.length + bArrEncode2.length, bArrEncode3.length);
        return bArr;
    }

    public PopulationCodec(Codec codec, int i5, Codec codec2) {
        if (i5 < 256 && i5 > 0) {
            this.favouredCodec = codec;
            this.f6716l = i5;
            this.unfavouredCodec = codec2;
            return;
        }
        throw new IllegalArgumentException("L must be between 1..255");
    }
}
