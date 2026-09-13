package org.apache.commons.compress.harmony.unpack200;

import A3.AbstractC0157z;
import io.flutter.embedding.android.KeyboardMap;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.CodecEncoding;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.pack200.PopulationCodec;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFieldRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPString;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BandSet {
    protected SegmentHeader header;
    protected Segment segment;

    public BandSet(Segment segment) {
        this.segment = segment;
        this.header = segment.getSegmentHeader();
    }

    public int[] decodeBandInt(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        int[] iArrDecodeInts;
        Codec codec;
        if (bHSDCodec.getB() == 1 || i5 == 0) {
            return bHSDCodec.decodeInts(i5, inputStream);
        }
        int[] iArrDecodeInts2 = bHSDCodec.decodeInts(1, inputStream);
        if (iArrDecodeInts2.length == 0) {
            return iArrDecodeInts2;
        }
        int i6 = iArrDecodeInts2[0];
        if (bHSDCodec.isSigned() && i6 >= -256 && i6 <= -1) {
            Codec codec2 = CodecEncoding.getCodec((-1) - i6, this.header.getBandHeadersInputStream(), bHSDCodec);
            iArrDecodeInts = codec2.decodeInts(i5, inputStream);
            codec = codec2;
        } else if (bHSDCodec.isSigned() || i6 < bHSDCodec.getL() || i6 > bHSDCodec.getL() + 255) {
            iArrDecodeInts = bHSDCodec.decodeInts(i5 - 1, inputStream, i6);
            codec = bHSDCodec;
        } else {
            Codec codec3 = CodecEncoding.getCodec(i6 - bHSDCodec.getL(), this.header.getBandHeadersInputStream(), bHSDCodec);
            iArrDecodeInts = codec3.decodeInts(i5, inputStream);
            codec = codec3;
        }
        if (codec instanceof PopulationCodec) {
            PopulationCodec populationCodec = (PopulationCodec) codec;
            int[] iArr = (int[]) populationCodec.getFavoured().clone();
            Arrays.sort(iArr);
            for (int i7 = 0; i7 < iArrDecodeInts.length; i7++) {
                Codec favouredCodec = Arrays.binarySearch(iArr, iArrDecodeInts[i7]) > -1 ? populationCodec.getFavouredCodec() : populationCodec.getUnfavouredCodec();
                if (favouredCodec instanceof BHSDCodec) {
                    BHSDCodec bHSDCodec2 = (BHSDCodec) favouredCodec;
                    if (bHSDCodec2.isDelta()) {
                        long jCardinality = bHSDCodec2.cardinality();
                        while (iArrDecodeInts[i7] > bHSDCodec2.largest()) {
                            iArrDecodeInts[i7] = (int) (((long) iArrDecodeInts[i7]) - jCardinality);
                        }
                        while (iArrDecodeInts[i7] < bHSDCodec2.smallest()) {
                            iArrDecodeInts[i7] = (int) (((long) iArrDecodeInts[i7]) + jCardinality);
                        }
                    }
                }
            }
        }
        return iArrDecodeInts;
    }

    public String[] getReferences(int[] iArr, String[] strArr) {
        int length = iArr.length;
        String[] strArr2 = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            strArr2[i5] = strArr[iArr[i5]];
        }
        return strArr2;
    }

    public CPClass[] parseCPClassReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPClass[] cPClassArr = new CPClass[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cPClassArr[i6] = this.segment.getCpBands().cpClassValue(iArrDecodeBandInt[i6]);
        }
        return cPClassArr;
    }

    public CPNameAndType[] parseCPDescriptorReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        CpBands cpBands = this.segment.getCpBands();
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPNameAndType[] cPNameAndTypeArr = new CPNameAndType[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cPNameAndTypeArr[i6] = cpBands.cpNameAndTypeValue(iArrDecodeBandInt[i6]);
        }
        return cPNameAndTypeArr;
    }

    public CPDouble[] parseCPDoubleReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPDouble[] cPDoubleArr = new CPDouble[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cPDoubleArr[i6] = this.segment.getCpBands().cpDoubleValue(iArrDecodeBandInt[i6]);
        }
        return cPDoubleArr;
    }

    public CPFieldRef[] parseCPFieldRefReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        CpBands cpBands = this.segment.getCpBands();
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPFieldRef[] cPFieldRefArr = new CPFieldRef[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cPFieldRefArr[i6] = cpBands.cpFieldValue(iArrDecodeBandInt[i6]);
        }
        return cPFieldRefArr;
    }

    public CPFloat[] parseCPFloatReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPFloat[] cPFloatArr = new CPFloat[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cPFloatArr[i6] = this.segment.getCpBands().cpFloatValue(iArrDecodeBandInt[i6]);
        }
        return cPFloatArr;
    }

    public CPInteger[] parseCPIntReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) throws Pack200Exception {
        int[] cpInt = this.segment.getCpBands().getCpInt();
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPInteger[] cPIntegerArr = new CPInteger[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iArrDecodeBandInt[i6];
            if (i7 < 0 || i7 >= cpInt.length) {
                StringBuilder sbT = AbstractC0157z.t(i7, "Something has gone wrong during parsing references, index = ", ", array size = ");
                sbT.append(cpInt.length);
                throw new Pack200Exception(sbT.toString());
            }
            cPIntegerArr[i6] = this.segment.getCpBands().cpIntegerValue(i7);
        }
        return cPIntegerArr;
    }

    public CPInterfaceMethodRef[] parseCPInterfaceMethodRefReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        CpBands cpBands = this.segment.getCpBands();
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPInterfaceMethodRef[] cPInterfaceMethodRefArr = new CPInterfaceMethodRef[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cPInterfaceMethodRefArr[i6] = cpBands.cpIMethodValue(iArrDecodeBandInt[i6]);
        }
        return cPInterfaceMethodRefArr;
    }

    public CPLong[] parseCPLongReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) throws Pack200Exception {
        long[] cpLong = this.segment.getCpBands().getCpLong();
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPLong[] cPLongArr = new CPLong[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iArrDecodeBandInt[i6];
            if (i7 < 0 || i7 >= cpLong.length) {
                StringBuilder sbT = AbstractC0157z.t(i7, "Something has gone wrong during parsing references, index = ", ", array size = ");
                sbT.append(cpLong.length);
                throw new Pack200Exception(sbT.toString());
            }
            cPLongArr[i6] = this.segment.getCpBands().cpLongValue(i7);
        }
        return cPLongArr;
    }

    public CPMethodRef[] parseCPMethodRefReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        CpBands cpBands = this.segment.getCpBands();
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPMethodRef[] cPMethodRefArr = new CPMethodRef[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cPMethodRefArr[i6] = cpBands.cpMethodValue(iArrDecodeBandInt[i6]);
        }
        return cPMethodRefArr;
    }

    public CPUTF8[] parseCPSignatureReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPUTF8[] cputf8Arr = new CPUTF8[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cputf8Arr[i6] = this.segment.getCpBands().cpSignatureValue(iArrDecodeBandInt[i6]);
        }
        return cputf8Arr;
    }

    public CPString[] parseCPStringReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPString[] cPStringArr = new CPString[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cPStringArr[i6] = this.segment.getCpBands().cpStringValue(iArrDecodeBandInt[i6]);
        }
        return cPStringArr;
    }

    public CPUTF8[] parseCPUTF8References(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5) {
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        CPUTF8[] cputf8Arr = new CPUTF8[iArrDecodeBandInt.length];
        for (int i6 = 0; i6 < i5; i6++) {
            cputf8Arr[i6] = this.segment.getCpBands().cpUTF8Value(iArrDecodeBandInt[i6]);
        }
        return cputf8Arr;
    }

    public long[] parseFlags(String str, InputStream inputStream, int i5, BHSDCodec bHSDCodec, boolean z6) {
        BHSDCodec bHSDCodec2;
        BHSDCodec bHSDCodec3;
        int[] iArr = {i5};
        if (z6) {
            bHSDCodec2 = bHSDCodec;
            bHSDCodec3 = bHSDCodec2;
        } else {
            bHSDCodec2 = null;
            bHSDCodec3 = bHSDCodec;
        }
        return parseFlags(str, inputStream, iArr, bHSDCodec2, bHSDCodec3)[0];
    }

    public String[] parseReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int i5, String[] strArr) {
        return parseReferences(str, inputStream, bHSDCodec, new int[]{i5}, strArr)[0];
    }

    public abstract void read(InputStream inputStream);

    public abstract void unpack();

    public void unpack(InputStream inputStream) {
        read(inputStream);
        unpack();
    }

    public long[][] parseFlags(String str, InputStream inputStream, int[] iArr, BHSDCodec bHSDCodec, boolean z6) {
        BHSDCodec bHSDCodec2;
        BHSDCodec bHSDCodec3;
        if (z6) {
            bHSDCodec3 = bHSDCodec;
            bHSDCodec2 = bHSDCodec3;
        } else {
            bHSDCodec2 = bHSDCodec;
            bHSDCodec3 = null;
        }
        return parseFlags(str, inputStream, iArr, bHSDCodec3, bHSDCodec2);
    }

    public String[][] parseReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int[] iArr, String[] strArr) throws Pack200Exception {
        int length = iArr.length;
        if (length == 0) {
            return new String[][]{new String[0]};
        }
        String[][] strArr2 = new String[length][];
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = iArr[i6];
            strArr2[i6] = new String[i7];
            i5 += i7;
        }
        String[] strArr3 = new String[i5];
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = iArrDecodeBandInt[i8];
            if (i9 < 0 || i9 >= strArr.length) {
                StringBuilder sbT = AbstractC0157z.t(i9, "Something has gone wrong during parsing references, index = ", ", array size = ");
                sbT.append(strArr.length);
                throw new Pack200Exception(sbT.toString());
            }
            strArr3[i8] = strArr[i9];
        }
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = iArr[i11];
            String[] strArr4 = new String[i12];
            strArr2[i11] = strArr4;
            System.arraycopy(strArr3, i10, strArr4, 0, i12);
            i10 += i12;
        }
        return strArr2;
    }

    public String[][] getReferences(int[][] iArr, String[] strArr) {
        int length = iArr.length;
        String[][] strArr2 = new String[length][];
        for (int i5 = 0; i5 < length; i5++) {
            strArr2[i5] = new String[iArr[i5].length];
            int i6 = 0;
            while (true) {
                String[] strArr3 = strArr2[i5];
                if (i6 < strArr3.length) {
                    strArr3[i6] = strArr[iArr[i5][i6]];
                    i6++;
                }
            }
        }
        return strArr2;
    }

    public long[] parseFlags(String str, InputStream inputStream, int i5, BHSDCodec bHSDCodec, BHSDCodec bHSDCodec2) {
        return parseFlags(str, inputStream, new int[]{i5}, bHSDCodec, bHSDCodec2)[0];
    }

    public long[][] parseFlags(String str, InputStream inputStream, int[] iArr, BHSDCodec bHSDCodec, BHSDCodec bHSDCodec2) {
        int[] iArrDecodeBandInt;
        int[] iArrDecodeBandInt2;
        int length = iArr.length;
        if (length == 0) {
            return new long[][]{new long[0]};
        }
        long[][] jArr = new long[length][];
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = iArr[i6];
            jArr[i6] = new long[i7];
            i5 += i7;
        }
        if (bHSDCodec != null) {
            iArrDecodeBandInt2 = decodeBandInt(str, inputStream, bHSDCodec, i5);
            iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec2, i5);
        } else {
            iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec2, i5);
            iArrDecodeBandInt2 = null;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = 0;
            while (true) {
                long[] jArr2 = jArr[i9];
                if (i10 < jArr2.length) {
                    if (iArrDecodeBandInt2 != null) {
                        jArr2[i10] = (((long) iArrDecodeBandInt2[i8]) << 32) | (((long) iArrDecodeBandInt[i8]) & KeyboardMap.kValueMask);
                    } else {
                        jArr2[i10] = iArrDecodeBandInt[i8];
                    }
                    i8++;
                    i10++;
                }
            }
        }
        return jArr;
    }

    public CPUTF8[][] parseCPSignatureReferences(String str, InputStream inputStream, BHSDCodec bHSDCodec, int[] iArr) {
        CPUTF8[][] cputf8Arr = new CPUTF8[iArr.length][];
        int i5 = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            cputf8Arr[i6] = new CPUTF8[i7];
            i5 += i7;
        }
        CPUTF8[] cputf8Arr2 = new CPUTF8[i5];
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            cputf8Arr2[i8] = this.segment.getCpBands().cpSignatureValue(iArrDecodeBandInt[i8]);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int i11 = iArr[i10];
            CPUTF8[] cputf8Arr3 = new CPUTF8[i11];
            cputf8Arr[i10] = cputf8Arr3;
            System.arraycopy(cputf8Arr2, i9, cputf8Arr3, 0, i11);
            i9 += i11;
        }
        return cputf8Arr;
    }

    public CPUTF8[][] parseCPUTF8References(String str, InputStream inputStream, BHSDCodec bHSDCodec, int[] iArr) {
        CPUTF8[][] cputf8Arr = new CPUTF8[iArr.length][];
        int i5 = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            cputf8Arr[i6] = new CPUTF8[i7];
            i5 += i7;
        }
        CPUTF8[] cputf8Arr2 = new CPUTF8[i5];
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            cputf8Arr2[i8] = this.segment.getCpBands().cpUTF8Value(iArrDecodeBandInt[i8]);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int i11 = iArr[i10];
            CPUTF8[] cputf8Arr3 = new CPUTF8[i11];
            cputf8Arr[i10] = cputf8Arr3;
            System.arraycopy(cputf8Arr2, i9, cputf8Arr3, 0, i11);
            i9 += i11;
        }
        return cputf8Arr;
    }

    public int[][] decodeBandInt(String str, InputStream inputStream, BHSDCodec bHSDCodec, int[] iArr) {
        int length = iArr.length;
        int[][] iArr2 = new int[length][];
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        int[] iArrDecodeBandInt = decodeBandInt(str, inputStream, bHSDCodec, i5);
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            iArr2[i8] = new int[iArr[i8]];
            int i9 = 0;
            while (true) {
                int[] iArr3 = iArr2[i8];
                if (i9 < iArr3.length) {
                    iArr3[i9] = iArrDecodeBandInt[i7];
                    i7++;
                    i9++;
                }
            }
        }
        return iArr2;
    }
}
