package org.apache.commons.compress.harmony.pack200;

import D3.c;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BandSet {
    private static final int[] effortThresholds = {0, 0, 1000, Videoio.CAP_QT, 100, 100, 100, 100, 100, 0};
    private long[] canonicalLargest;
    private long[] canonicalSmallest;
    final int effort;
    protected final SegmentHeader segmentHeader;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class BandAnalysisResults {
        private Codec betterCodec;
        private byte[] encodedBand;
        private int[] extraMetadata;
        private int numCodecsTried = 0;
        private int saved = 0;

        public BandAnalysisResults() {
        }

        public static /* synthetic */ int access$408(BandAnalysisResults bandAnalysisResults) {
            int i5 = bandAnalysisResults.numCodecsTried;
            bandAnalysisResults.numCodecsTried = i5 + 1;
            return i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class BandData {
        private double averageAbsoluteDelta;
        private double averageAbsoluteValue;
        private final int[] band;
        private Map distinctValues;
        private int largest;
        private int largestDelta;
        private int smallest;
        private int smallestDelta;
        private int deltaIsAscending = 0;
        private int smallDeltaCount = 0;

        public BandData(int[] iArr) {
            this.smallest = Integer.MAX_VALUE;
            this.largest = Integer.MIN_VALUE;
            this.averageAbsoluteDelta = 0.0d;
            this.averageAbsoluteValue = 0.0d;
            this.band = iArr;
            for (int i5 = 0; i5 < iArr.length; i5++) {
                int i6 = iArr[i5];
                if (i6 < this.smallest) {
                    this.smallest = i6;
                }
                if (i6 > this.largest) {
                    this.largest = i6;
                }
                if (i5 != 0) {
                    int i7 = i6 - iArr[i5 - 1];
                    if (i7 < this.smallestDelta) {
                        this.smallestDelta = i7;
                    }
                    if (i7 > this.largestDelta) {
                        this.largestDelta = i7;
                    }
                    if (i7 >= 0) {
                        this.deltaIsAscending++;
                    }
                    this.averageAbsoluteDelta = (((double) Math.abs(i7)) / ((double) (iArr.length - 1))) + this.averageAbsoluteDelta;
                    if (Math.abs(i7) < 256) {
                        this.smallDeltaCount++;
                    }
                } else {
                    int i8 = iArr[0];
                    this.smallestDelta = i8;
                    this.largestDelta = i8;
                }
                this.averageAbsoluteValue = (((double) Math.abs(iArr[i5])) / ((double) iArr.length)) + this.averageAbsoluteValue;
                if (BandSet.this.effort > 3) {
                    if (this.distinctValues == null) {
                        this.distinctValues = new HashMap();
                    }
                    Integer numValueOf = Integer.valueOf(iArr[i5]);
                    Integer num = (Integer) this.distinctValues.get(numValueOf);
                    this.distinctValues.put(numValueOf, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        public boolean anyNegatives() {
            return this.smallest < 0;
        }

        public boolean mainlyPositiveDeltas() {
            return ((float) this.deltaIsAscending) / ((float) this.band.length) > 0.95f;
        }

        public boolean mainlySmallDeltas() {
            return ((float) this.smallDeltaCount) / ((float) this.band.length) > 0.7f;
        }

        public int numDistinctValues() {
            Map map = this.distinctValues;
            return map == null ? this.band.length : map.size();
        }

        public boolean wellCorrelated() {
            return this.averageAbsoluteDelta * 3.1d < this.averageAbsoluteValue;
        }
    }

    public BandSet(int i5, SegmentHeader segmentHeader) {
        this.effort = i5;
        this.segmentHeader = segmentHeader;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:44:0x0103  */
    /* JADX WARN: Code duplicated, block: B:45:0x0127  */
    /* JADX WARN: Code duplicated, block: B:47:0x012d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0151  */
    /* JADX WARN: Code duplicated, block: B:51:0x0186  */
    /* JADX WARN: Code duplicated, block: B:54:0x0194  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a5 A[EDGE_INSN: B:59:0x01a5->B:56:0x01a5 BREAK  A[LOOP:1: B:53:0x0192->B:60:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:? A[LOOP:1: B:53:0x0192->B:60:?, LOOP_END, SYNTHETIC] */
    private BandAnalysisResults analyseBand(String str, int[] iArr, BHSDCodec bHSDCodec) {
        BandSet bandSet;
        String str2;
        int[] iArr2;
        BHSDCodec bHSDCodec2;
        ArrayList arrayList;
        int size;
        int i5;
        BandAnalysisResults bandAnalysisResults = new BandAnalysisResults();
        if (this.canonicalLargest == null) {
            this.canonicalLargest = new long[116];
            this.canonicalSmallest = new long[116];
            int i6 = 1;
            while (true) {
                long[] jArr = this.canonicalLargest;
                if (i6 >= jArr.length) {
                    break;
                }
                jArr[i6] = CodecEncoding.getCanonicalCodec(i6).largest();
                this.canonicalSmallest[i6] = CodecEncoding.getCanonicalCodec(i6).smallest();
                i6++;
            }
        }
        BandData bandData = new BandData(iArr);
        byte[] bArrEncode = bHSDCodec.encode(iArr);
        bandAnalysisResults.encodedBand = bArrEncode;
        if (bArrEncode.length > (iArr.length + 23) - (this.effort * 2)) {
            if (!bandData.anyNegatives()) {
                long j6 = bandData.largest;
                BHSDCodec bHSDCodec3 = Codec.BYTE1;
                if (j6 <= bHSDCodec3.largest()) {
                    bandAnalysisResults.encodedBand = bHSDCodec3.encode(iArr);
                    bandAnalysisResults.betterCodec = bHSDCodec3;
                    return bandAnalysisResults;
                }
            }
            if (this.effort <= 3 || str.equals("POPULATION")) {
                bandSet = this;
                str2 = str;
                iArr2 = iArr;
                bHSDCodec2 = bHSDCodec;
                arrayList = new ArrayList();
                if (bandData.mainlyPositiveDeltas() && bandData.mainlySmallDeltas()) {
                    arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs2);
                }
                if (bandData.wellCorrelated()) {
                    if (bandData.mainlyPositiveDeltas()) {
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs3);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs4);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs5);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs3);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs4);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs5);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs2);
                    } else {
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs3);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs2);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs4);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs5);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs2);
                    }
                } else if (bandData.anyNegatives()) {
                    arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs1);
                    arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs2);
                    arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs1);
                    arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs2);
                    arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs3);
                    arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs4);
                    arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs5);
                } else {
                    arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs1);
                    arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs3);
                    arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs4);
                    arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs5);
                    arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs2);
                    arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs1);
                    arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs3);
                    arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs4);
                    arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs5);
                }
                if (str2.equalsIgnoreCase("cpint")) {
                    System.out.print("");
                }
                size = arrayList.size();
                i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    bandSet.tryCodecs(str2, iArr2, bHSDCodec2, bandData, bandAnalysisResults, bArrEncode, (BHSDCodec[]) obj);
                    if (timeToStop(bandAnalysisResults)) {
                        break;
                    }
                }
            } else {
                int iNumDistinctValues = bandData.numDistinctValues();
                float length = iNumDistinctValues / iArr.length;
                if (iNumDistinctValues >= 100) {
                    double d = length;
                    if (d >= 0.02d && (this.effort <= 6 || d >= 0.04d)) {
                        bandSet = this;
                        str2 = str;
                        iArr2 = iArr;
                        bHSDCodec2 = bHSDCodec;
                    }
                    arrayList = new ArrayList();
                    if (bandData.mainlyPositiveDeltas()) {
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs2);
                    }
                    if (bandData.wellCorrelated()) {
                        if (bandData.mainlyPositiveDeltas()) {
                            arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs1);
                            arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs3);
                            arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs4);
                            arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs5);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs1);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs3);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs4);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs5);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs2);
                        } else {
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs1);
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs3);
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs2);
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs4);
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs5);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs1);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs2);
                        }
                    } else if (bandData.anyNegatives()) {
                        arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs2);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs2);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs3);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs4);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs5);
                    } else {
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs3);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs4);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs5);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs2);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs3);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs4);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs5);
                    }
                    if (str2.equalsIgnoreCase("cpint")) {
                        System.out.print("");
                    }
                    size = arrayList.size();
                    i5 = 0;
                    while (i5 < size) {
                        Object obj2 = arrayList.get(i5);
                        i5++;
                        bandSet.tryCodecs(str2, iArr2, bHSDCodec2, bandData, bandAnalysisResults, bArrEncode, (BHSDCodec[]) obj2);
                        if (timeToStop(bandAnalysisResults)) {
                            break;
                            break;
                        }
                    }
                }
                bandSet = this;
                str2 = str;
                iArr2 = iArr;
                bHSDCodec2 = bHSDCodec;
                bandSet.encodeWithPopulationCodec(str2, iArr2, bHSDCodec2, bandData, bandAnalysisResults);
                if (!timeToStop(bandAnalysisResults)) {
                    arrayList = new ArrayList();
                    if (bandData.mainlyPositiveDeltas()) {
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs2);
                    }
                    if (bandData.wellCorrelated()) {
                        if (bandData.mainlyPositiveDeltas()) {
                            arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs1);
                            arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs3);
                            arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs4);
                            arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs5);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs1);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs3);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs4);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs5);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs2);
                        } else {
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs1);
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs3);
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs2);
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs4);
                            arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs5);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs1);
                            arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs2);
                        }
                    } else if (bandData.anyNegatives()) {
                        arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaSignedCodecs2);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs2);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs3);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs4);
                        arrayList.add(CanonicalCodecFamilies.deltaSignedCodecs5);
                    } else {
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs3);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs4);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs5);
                        arrayList.add(CanonicalCodecFamilies.nonDeltaUnsignedCodecs2);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs1);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs3);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs4);
                        arrayList.add(CanonicalCodecFamilies.deltaUnsignedCodecs5);
                    }
                    if (str2.equalsIgnoreCase("cpint")) {
                        System.out.print("");
                    }
                    size = arrayList.size();
                    i5 = 0;
                    while (i5 < size) {
                        Object obj3 = arrayList.get(i5);
                        i5++;
                        bandSet.tryCodecs(str2, iArr2, bHSDCodec2, bandData, bandAnalysisResults, bArrEncode, (BHSDCodec[]) obj3);
                        if (timeToStop(bandAnalysisResults)) {
                            break;
                            break;
                        }
                    }
                }
            }
        }
        return bandAnalysisResults;
    }

    private void encodeWithPopulationCodec(String str, int[] iArr, BHSDCodec bHSDCodec, BandData bandData, BandAnalysisResults bandAnalysisResults) {
        Codec codec;
        byte[] bArrEncode;
        int l6;
        int i5;
        bandAnalysisResults.numCodecsTried += 3;
        Map map = bandData.distinctValues;
        ArrayList arrayList = new ArrayList();
        for (Integer num : map.keySet()) {
            if (((Integer) map.get(num)).intValue() > 2 || map.size() < 256) {
                arrayList.add(num);
            }
        }
        if (map.size() > 255) {
            Collections.sort(arrayList, new c(map, 1));
        }
        IntList intList = new IntList();
        HashMap map2 = new HashMap();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            map2.put((Integer) arrayList.get(i6), Integer.valueOf(i6));
        }
        int[] iArr2 = new int[iArr.length];
        for (int i7 = 0; i7 < iArr.length; i7++) {
            Integer num2 = (Integer) map2.get(Integer.valueOf(iArr[i7]));
            if (num2 == null) {
                iArr2[i7] = 0;
                intList.add(iArr[i7]);
            } else {
                iArr2[i7] = num2.intValue() + 1;
            }
        }
        arrayList.add(arrayList.get(arrayList.size() - 1));
        int[] iArrIntegerListToArray = integerListToArray(arrayList);
        int[] array = intList.toArray();
        BandAnalysisResults bandAnalysisResultsAnalyseBand = analyseBand("POPULATION", iArrIntegerListToArray, bHSDCodec);
        BandAnalysisResults bandAnalysisResultsAnalyseBand2 = analyseBand("POPULATION", array, bHSDCodec);
        int size = arrayList.size() - 1;
        if (size < 256) {
            bArrEncode = Codec.BYTE1.encode(iArr2);
            l6 = 0;
            codec = null;
            i5 = 1;
        } else {
            BandAnalysisResults bandAnalysisResultsAnalyseBand3 = analyseBand("POPULATION", iArr2, bHSDCodec);
            codec = bandAnalysisResultsAnalyseBand3.betterCodec;
            bArrEncode = bandAnalysisResultsAnalyseBand3.encodedBand;
            if (codec == null) {
                codec = bHSDCodec;
            }
            BHSDCodec bHSDCodec2 = (BHSDCodec) codec;
            l6 = bHSDCodec2.getL();
            int h6 = bHSDCodec2.getH();
            int s6 = bHSDCodec2.getS();
            int b = bHSDCodec2.getB();
            boolean zIsDelta = bHSDCodec2.isDelta();
            if (s6 != 0 || zIsDelta) {
                i5 = 0;
            } else if (b <= 1 || new BHSDCodec(b - 1, h6).largest() < size) {
                switch (l6) {
                    case 4:
                        i5 = 1;
                        break;
                    case 8:
                        i5 = 2;
                        break;
                    case 16:
                        i5 = 3;
                        break;
                    case 32:
                        i5 = 4;
                        break;
                    case 64:
                        i5 = 5;
                        break;
                    case 128:
                        i5 = 6;
                        break;
                    case 192:
                        i5 = 7;
                        break;
                    case 224:
                        i5 = 8;
                        break;
                    case 240:
                        i5 = 9;
                        break;
                    case 248:
                        i5 = 10;
                        break;
                    case 252:
                        i5 = 11;
                        break;
                    default:
                        i5 = 0;
                        break;
                }
            } else {
                i5 = 0;
            }
        }
        byte[] bArr = bandAnalysisResultsAnalyseBand.encodedBand;
        byte[] bArr2 = bandAnalysisResultsAnalyseBand2.encodedBand;
        Codec codec2 = bandAnalysisResultsAnalyseBand.betterCodec;
        Codec codec3 = bandAnalysisResultsAnalyseBand2.betterCodec;
        int i8 = (i5 * 4) + (codec2 == null ? 1 : 0) + 141 + (codec3 == null ? 2 : 0);
        IntList intList2 = new IntList(3);
        if (codec2 != null) {
            for (int i9 : CodecEncoding.getSpecifier(codec2, null)) {
                intList2.add(i9);
            }
        }
        if (i5 == 0) {
            for (int i10 : CodecEncoding.getSpecifier(codec, null)) {
                intList2.add(i10);
            }
        }
        if (codec3 != null) {
            for (int i11 : CodecEncoding.getSpecifier(codec3, null)) {
                intList2.add(i11);
            }
        }
        int[] array2 = intList2.toArray();
        byte[] bArrEncode2 = Codec.UNSIGNED5.encode(array2);
        byte[] bArrEncode3 = bHSDCodec.encode(new int[]{bHSDCodec.isSigned() ? (-1) - i8 : bHSDCodec.getL() + i8});
        int length = bArrEncode3.length + bArr.length + bArrEncode.length + bArr2.length;
        if (bArrEncode2.length + length < bandAnalysisResults.encodedBand.length) {
            bandAnalysisResults.saved = (bandAnalysisResults.encodedBand.length - (bArrEncode2.length + length)) + bandAnalysisResults.saved;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArrEncode3, 0, bArr3, 0, bArrEncode3.length);
            System.arraycopy(bArr, 0, bArr3, bArrEncode3.length, bArr.length);
            System.arraycopy(bArrEncode, 0, bArr3, bArrEncode3.length + bArr.length, bArrEncode.length);
            System.arraycopy(bArr2, 0, bArr3, bArrEncode3.length + bArr.length + bArrEncode.length, bArr2.length);
            bandAnalysisResults.encodedBand = bArr3;
            bandAnalysisResults.extraMetadata = array2;
            if (l6 != 0) {
                bandAnalysisResults.betterCodec = new PopulationCodec(codec2, l6, codec3);
            } else {
                bandAnalysisResults.betterCodec = new PopulationCodec(codec2, codec, codec3);
            }
        }
    }

    private long[] flatten(long[][] jArr) {
        int length = 0;
        for (long[] jArr2 : jArr) {
            length += jArr2.length;
        }
        long[] jArr3 = new long[length];
        int i5 = 0;
        for (long[] jArr4 : jArr) {
            int i6 = 0;
            while (true) {
                if (i6 < jArr4.length) {
                    jArr3[i5] = jArr4[i6];
                    i5++;
                    i6++;
                }
            }
        }
        return jArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$encodeWithPopulationCodec$0(Map map, Object obj, Object obj2) {
        return ((Integer) map.get(obj2)).compareTo((Integer) map.get(obj));
    }

    private boolean timeToStop(BandAnalysisResults bandAnalysisResults) {
        if (this.effort > 6) {
            return bandAnalysisResults.numCodecsTried >= this.effort * 2;
        }
        return bandAnalysisResults.numCodecsTried >= this.effort;
    }

    private void tryCodecs(String str, int[] iArr, BHSDCodec bHSDCodec, BandData bandData, BandAnalysisResults bandAnalysisResults, byte[] bArr, BHSDCodec[] bHSDCodecArr) {
        for (BHSDCodec bHSDCodec2 : bHSDCodecArr) {
            if (bHSDCodec2.equals(bHSDCodec)) {
                return;
            }
            if (bHSDCodec2.isDelta()) {
                if (bHSDCodec2.largest() >= bandData.largestDelta && bHSDCodec2.smallest() <= bandData.smallestDelta && bHSDCodec2.largest() >= bandData.largest && bHSDCodec2.smallest() <= bandData.smallest) {
                    byte[] bArrEncode = bHSDCodec2.encode(iArr);
                    BandAnalysisResults.access$408(bandAnalysisResults);
                    int length = (bArr.length - bArrEncode.length) - bHSDCodec.encode(CodecEncoding.getSpecifier(bHSDCodec2, null)).length;
                    if (length > bandAnalysisResults.saved) {
                        bandAnalysisResults.betterCodec = bHSDCodec2;
                        bandAnalysisResults.encodedBand = bArrEncode;
                        bandAnalysisResults.saved = length;
                    }
                }
            } else if (bHSDCodec2.largest() >= bandData.largest && bHSDCodec2.smallest() <= bandData.smallest) {
                byte[] bArrEncode2 = bHSDCodec2.encode(iArr);
                BandAnalysisResults.access$408(bandAnalysisResults);
                int length2 = (bArr.length - bArrEncode2.length) - bHSDCodec.encode(CodecEncoding.getSpecifier(bHSDCodec2, null)).length;
                if (length2 > bandAnalysisResults.saved) {
                    bandAnalysisResults.betterCodec = bHSDCodec2;
                    bandAnalysisResults.encodedBand = bArrEncode2;
                    bandAnalysisResults.saved = length2;
                }
            }
            if (timeToStop(bandAnalysisResults)) {
                return;
            }
        }
    }

    public int[] cpEntryListToArray(List list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            int index = ((ConstantPoolEntry) list.get(i5)).getIndex();
            iArr[i5] = index;
            if (index < 0) {
                throw new RuntimeException("Index should be > 0");
            }
        }
        return iArr;
    }

    public int[] cpEntryOrNullListToArray(List list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            ConstantPoolEntry constantPoolEntry = (ConstantPoolEntry) list.get(i5);
            iArr[i5] = constantPoolEntry == null ? 0 : constantPoolEntry.getIndex() + 1;
            if (constantPoolEntry != null && constantPoolEntry.getIndex() < 0) {
                throw new RuntimeException("Index should be > 0");
            }
        }
        return iArr;
    }

    public byte[] encodeBandInt(String str, int[] iArr, BHSDCodec bHSDCodec) {
        byte[] bArrEncode;
        int i5 = this.effort;
        if (i5 <= 1 || iArr.length < effortThresholds[i5]) {
            bArrEncode = null;
        } else {
            BandAnalysisResults bandAnalysisResultsAnalyseBand = analyseBand(str, iArr, bHSDCodec);
            Codec codec = bandAnalysisResultsAnalyseBand.betterCodec;
            bArrEncode = bandAnalysisResultsAnalyseBand.encodedBand;
            if (codec != null) {
                if (codec instanceof BHSDCodec) {
                    int[] specifier = CodecEncoding.getSpecifier(codec, bHSDCodec);
                    int i6 = specifier[0];
                    if (specifier.length > 1) {
                        for (int i7 = 1; i7 < specifier.length; i7++) {
                            this.segmentHeader.appendBandCodingSpecifier(specifier[i7]);
                        }
                    }
                    byte[] bArrEncode2 = bHSDCodec.encode(new int[]{bHSDCodec.isSigned() ? (-1) - i6 : bHSDCodec.getL() + i6});
                    byte[] bArr = new byte[bArrEncode2.length + bArrEncode.length];
                    System.arraycopy(bArrEncode2, 0, bArr, 0, bArrEncode2.length);
                    System.arraycopy(bArrEncode, 0, bArr, bArrEncode2.length, bArrEncode.length);
                    return bArr;
                }
                if (codec instanceof PopulationCodec) {
                    for (int i8 : bandAnalysisResultsAnalyseBand.extraMetadata) {
                        this.segmentHeader.appendBandCodingSpecifier(i8);
                    }
                    return bArrEncode;
                }
            }
        }
        if (iArr.length <= 0) {
            return new byte[0];
        }
        if (bArrEncode == null) {
            bArrEncode = bHSDCodec.encode(iArr);
        }
        int i9 = iArr[0];
        if (bHSDCodec.getB() != 1) {
            if (bHSDCodec.isSigned() && i9 >= -256 && i9 <= -1) {
                byte[] bArrEncode3 = bHSDCodec.encode(new int[]{(-1) - CodecEncoding.getSpecifierForDefaultCodec(bHSDCodec)});
                byte[] bArr2 = new byte[bArrEncode3.length + bArrEncode.length];
                System.arraycopy(bArrEncode3, 0, bArr2, 0, bArrEncode3.length);
                System.arraycopy(bArrEncode, 0, bArr2, bArrEncode3.length, bArrEncode.length);
                return bArr2;
            }
            if (!bHSDCodec.isSigned() && i9 >= bHSDCodec.getL() && i9 <= bHSDCodec.getL() + 255) {
                byte[] bArrEncode4 = bHSDCodec.encode(new int[]{bHSDCodec.getL() + CodecEncoding.getSpecifierForDefaultCodec(bHSDCodec)});
                byte[] bArr3 = new byte[bArrEncode4.length + bArrEncode.length];
                System.arraycopy(bArrEncode4, 0, bArr3, 0, bArrEncode4.length);
                System.arraycopy(bArrEncode, 0, bArr3, bArrEncode4.length, bArrEncode.length);
                return bArr3;
            }
        }
        return bArrEncode;
    }

    public byte[] encodeFlags(String str, long[] jArr, BHSDCodec bHSDCodec, BHSDCodec bHSDCodec2, boolean z6) {
        if (!z6) {
            int[] iArr = new int[jArr.length];
            for (int i5 = 0; i5 < jArr.length; i5++) {
                iArr[i5] = (int) jArr[i5];
            }
            return encodeBandInt(str, iArr, bHSDCodec);
        }
        int[] iArr2 = new int[jArr.length];
        int[] iArr3 = new int[jArr.length];
        for (int i6 = 0; i6 < jArr.length; i6++) {
            long j6 = jArr[i6];
            iArr2[i6] = (int) (j6 >> 32);
            iArr3[i6] = (int) j6;
        }
        byte[] bArrEncodeBandInt = encodeBandInt(str, iArr2, bHSDCodec2);
        byte[] bArrEncodeBandInt2 = encodeBandInt(str, iArr3, bHSDCodec);
        byte[] bArr = new byte[bArrEncodeBandInt.length + bArrEncodeBandInt2.length];
        System.arraycopy(bArrEncodeBandInt, 0, bArr, 0, bArrEncodeBandInt.length);
        System.arraycopy(bArrEncodeBandInt2, 0, bArr, bArrEncodeBandInt.length + 1, bArrEncodeBandInt2.length);
        return bArr;
    }

    public byte[] encodeScalar(int[] iArr, BHSDCodec bHSDCodec) {
        return bHSDCodec.encode(iArr);
    }

    public int[] integerListToArray(List list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr[i5] = ((Integer) list.get(i5)).intValue();
        }
        return iArr;
    }

    public long[] longListToArray(List list) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i5 = 0; i5 < size; i5++) {
            jArr[i5] = ((Long) list.get(i5)).longValue();
        }
        return jArr;
    }

    public abstract void pack(OutputStream outputStream);

    public byte[] encodeScalar(int i5, BHSDCodec bHSDCodec) {
        return bHSDCodec.encode(i5);
    }

    public byte[] encodeFlags(String str, long[][] jArr, BHSDCodec bHSDCodec, BHSDCodec bHSDCodec2, boolean z6) {
        return encodeFlags(str, flatten(jArr), bHSDCodec, bHSDCodec2, z6);
    }
}
