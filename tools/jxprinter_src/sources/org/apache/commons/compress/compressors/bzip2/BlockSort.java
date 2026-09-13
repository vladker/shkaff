package org.apache.commons.compress.compressors.bzip2;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.UnsignedBytes;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class BlockSort {
    private static final int CLEARMASK = -2097153;
    private static final int DEPTH_THRESH = 10;
    private static final int FALLBACK_QSORT_SMALL_THRESH = 10;
    private static final int FALLBACK_QSORT_STACK_SIZE = 100;
    private static final int[] INCS = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    private static final int QSORT_STACK_SIZE = 1000;
    private static final int SETMASK = 2097152;
    private static final int SMALL_THRESH = 20;
    private static final int STACK_SIZE = 1000;
    private static final int WORK_FACTOR = 30;
    private int[] eclass;
    private boolean firstAttempt;
    private final char[] quadrant;
    private int workDone;
    private int workLimit;
    private final int[] stack_ll = new int[1000];
    private final int[] stack_hh = new int[1000];
    private final int[] stack_dd = new int[1000];
    private final int[] mainSort_runningOrder = new int[256];
    private final int[] mainSort_copy = new int[256];
    private final boolean[] mainSort_bigDone = new boolean[256];
    private final int[] ftab = new int[65537];

    public BlockSort(BZip2CompressorOutputStream.Data data) {
        this.quadrant = data.sfmap;
    }

    private void fallbackQSort3(int[] iArr, int[] iArr2, int i5, int i6) {
        int i7;
        int i8;
        iArr2 = iArr2;
        char c = 0;
        fpush(0, i5, i6);
        long j6 = 0;
        int i9 = 1;
        long j7 = 0;
        int i10 = 1;
        while (i10 > 0) {
            int i11 = i10 - 1;
            int[] iArrFpop = fpop(i11);
            int i12 = iArrFpop[c];
            int i13 = iArrFpop[i9];
            if (i13 - i12 < 10) {
                fallbackSimpleSort(iArr, iArr2, i12, i13);
                i10 = i11;
            } else {
                j7 = ((j7 * 7621) + 1) % PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                long j8 = j7 % 3;
                if (j8 == j6) {
                    i7 = iArr2[iArr[i12]];
                } else {
                    i7 = j8 == 1 ? iArr2[iArr[(i12 + i13) >>> i9]] : iArr2[iArr[i13]];
                }
                long j9 = i7;
                int i14 = i13;
                int i15 = i14;
                int i16 = i12;
                int i17 = i16;
                while (true) {
                    if (i17 > i14) {
                        i8 = i9;
                    } else {
                        i8 = i9;
                        int i18 = iArr2[iArr[i17]] - ((int) j9);
                        if (i18 == 0) {
                            fswap(iArr, i17, i16);
                            i16++;
                            i17++;
                        } else {
                            if (i18 <= 0) {
                                i17++;
                            }
                            iArr2 = iArr2;
                        }
                        i9 = i8;
                    }
                    while (i17 <= i14) {
                        int i19 = iArr2[iArr[i14]] - ((int) j9);
                        if (i19 == 0) {
                            fswap(iArr, i14, i15);
                            i15--;
                        } else if (i19 < 0) {
                            break;
                        }
                        i14--;
                        iArr2 = iArr2;
                    }
                    if (i17 > i14) {
                        break;
                    }
                    fswap(iArr, i17, i14);
                    i17++;
                    i14--;
                    iArr2 = iArr2;
                    i9 = i8;
                }
                if (i15 < i16) {
                    i10 = i11;
                } else {
                    int iFmin = fmin(i16 - i12, i17 - i16);
                    fvswap(iArr, i12, i17 - iFmin, iFmin);
                    int i20 = i13 - i15;
                    int i21 = i15 - i14;
                    int iFmin2 = fmin(i20, i21);
                    fvswap(iArr, i14 + 1, (i13 - iFmin2) + 1, iFmin2);
                    int i22 = ((i17 + i12) - i16) - 1;
                    int i23 = (i13 - i21) + 1;
                    if (i22 - i12 > i13 - i23) {
                        fpush(i11, i12, i22);
                        fpush(i10, i23, i13);
                        i10++;
                    } else {
                        fpush(i11, i23, i13);
                        fpush(i10, i12, i22);
                        i10++;
                    }
                }
                i9 = i8;
                c = 0;
                j6 = 0;
            }
        }
    }

    private void fallbackSimpleSort(int[] iArr, int[] iArr2, int i5, int i6) {
        if (i5 == i6) {
            return;
        }
        if (i6 - i5 > 3) {
            for (int i7 = i6 - 4; i7 >= i5; i7--) {
                int i8 = iArr[i7];
                int i9 = iArr2[i8];
                int i10 = i7 + 4;
                while (i10 <= i6) {
                    int i11 = iArr[i10];
                    if (i9 <= iArr2[i11]) {
                        break;
                    }
                    iArr[i10 - 4] = i11;
                    i10 += 4;
                }
                iArr[i10 - 4] = i8;
            }
        }
        for (int i12 = i6 - 1; i12 >= i5; i12--) {
            int i13 = iArr[i12];
            int i14 = iArr2[i13];
            int i15 = i12 + 1;
            while (i15 <= i6) {
                int i16 = iArr[i15];
                if (i14 <= iArr2[i16]) {
                    break;
                }
                iArr[i15 - 1] = i16;
                i15++;
            }
            iArr[i15 - 1] = i13;
        }
    }

    private int fmin(int i5, int i6) {
        return i5 < i6 ? i5 : i6;
    }

    private int[] fpop(int i5) {
        return new int[]{this.stack_ll[i5], this.stack_hh[i5]};
    }

    private void fpush(int i5, int i6, int i7) {
        this.stack_ll[i5] = i6;
        this.stack_hh[i5] = i7;
    }

    private void fswap(int[] iArr, int i5, int i6) {
        int i7 = iArr[i5];
        iArr[i5] = iArr[i6];
        iArr[i6] = i7;
    }

    private void fvswap(int[] iArr, int i5, int i6, int i7) {
        while (i7 > 0) {
            fswap(iArr, i5, i6);
            i5++;
            i6++;
            i7--;
        }
    }

    private int[] getEclass() {
        if (this.eclass == null) {
            this.eclass = new int[this.quadrant.length / 2];
        }
        return this.eclass;
    }

    private void mainQSort3(BZip2CompressorOutputStream.Data data, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        BlockSort blockSort = this;
        BZip2CompressorOutputStream.Data data2 = data;
        int[] iArr = blockSort.stack_ll;
        int[] iArr2 = blockSort.stack_hh;
        int[] iArr3 = blockSort.stack_dd;
        int[] iArr4 = data2.fmap;
        byte[] bArr = data2.block;
        iArr[0] = i5;
        iArr2[0] = i6;
        iArr3[0] = i7;
        boolean z6 = true;
        int i11 = 1;
        while (true) {
            int i12 = i11 - 1;
            if (i12 < 0) {
                return;
            }
            int i13 = i11;
            int i14 = iArr[i12];
            int i15 = iArr2[i12];
            int i16 = iArr3[i12];
            if (i15 - i14 >= 20) {
                if (i16 <= 10) {
                    int i17 = i16 + 1;
                    z6 = z6;
                    int iMed3 = med3(bArr[iArr4[i14] + i17], bArr[iArr4[i15] + i17], bArr[iArr4[(i14 + i15) >>> 1] + i17]) & UnsignedBytes.MAX_VALUE;
                    int i18 = i14;
                    int i19 = i18;
                    int i20 = i15;
                    int i21 = i20;
                    while (true) {
                        if (i19 <= i20) {
                            int i22 = iArr4[i19];
                            int i23 = (bArr[i22 + i17] & UnsignedBytes.MAX_VALUE) - iMed3;
                            if (i23 == 0) {
                                iArr4[i19] = iArr4[i18];
                                iArr4[i18] = i22;
                                i18++;
                                i19++;
                            } else if (i23 < 0) {
                                i19++;
                            }
                        }
                        i9 = i21;
                        while (true) {
                            if (i19 > i20) {
                                i10 = i15;
                                break;
                            }
                            int i24 = iArr4[i20];
                            i10 = i15;
                            int i25 = (bArr[i24 + i17] & UnsignedBytes.MAX_VALUE) - iMed3;
                            if (i25 != 0) {
                                if (i25 <= 0) {
                                    break;
                                } else {
                                    i20--;
                                }
                            } else {
                                iArr4[i20] = iArr4[i9];
                                iArr4[i9] = i24;
                                i9--;
                                i20--;
                            }
                            i15 = i10;
                        }
                        if (i19 > i20) {
                            break;
                        }
                        int i26 = iArr4[i19];
                        iArr4[i19] = iArr4[i20];
                        iArr4[i20] = i26;
                        i15 = i10;
                        i20--;
                        i19++;
                        i21 = i9;
                    }
                    if (i9 < i18) {
                        iArr[i12] = i14;
                        iArr2[i12] = i10;
                        iArr3[i12] = i17;
                        i11 = i13;
                    } else {
                        int i27 = i18 - i14;
                        int i28 = i19 - i18;
                        if (i27 >= i28) {
                            i27 = i28;
                        }
                        vswap(iArr4, i14, i19 - i27, i27);
                        int i29 = i10 - i9;
                        int i30 = i9 - i20;
                        if (i29 >= i30) {
                            i29 = i30;
                        }
                        vswap(iArr4, i19, (i10 - i29) + 1, i29);
                        int i31 = (i19 + i14) - i18;
                        int i32 = i10 - i30;
                        iArr[i12] = i14;
                        iArr2[i12] = i31 - 1;
                        iArr3[i12] = i16;
                        iArr[i13] = i31;
                        iArr2[i13] = i32;
                        iArr3[i13] = i17;
                        int i33 = i13 + 1;
                        iArr[i33] = i32 + 1;
                        iArr2[i33] = i10;
                        iArr3[i33] = i16;
                        i11 = i13 + 2;
                    }
                }
                blockSort = this;
                data2 = data;
                z6 = z6;
            } else {
                blockSort = this;
                data2 = data;
            }
            if (blockSort.mainSimpleSort(data2, i14, i15, i16, i8)) {
                return;
            }
            i11 = i12;
            blockSort = this;
            data2 = data;
            z6 = z6;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 4541. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private boolean mainSimpleSort(org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream.Data r30, int r31, int r32, int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.bzip2.BlockSort.mainSimpleSort(org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream$Data, int, int, int, int):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x000d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x000e A[RETURN] */
    private static byte med3(byte b, byte b6, byte b7) {
        if (b < b6) {
            if (b6 >= b7) {
                if (b < b7) {
                    return b7;
                }
                return b;
            }
            return b6;
        }
        if (b6 <= b7) {
            if (b > b7) {
                return b7;
            }
            return b;
        }
        return b6;
    }

    private static void vswap(int[] iArr, int i5, int i6, int i7) {
        int i8 = i7 + i5;
        while (i5 < i8) {
            int i9 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i9;
            i6++;
            i5++;
        }
    }

    public void blockSort(BZip2CompressorOutputStream.Data data, int i5) {
        this.workLimit = i5 * 30;
        this.workDone = 0;
        this.firstAttempt = true;
        if (i5 + 1 < 10000) {
            fallbackSort(data, i5);
        } else {
            mainSort(data, i5);
            if (this.firstAttempt && this.workDone > this.workLimit) {
                fallbackSort(data, i5);
            }
        }
        int[] iArr = data.fmap;
        data.origPtr = -1;
        for (int i6 = 0; i6 <= i5; i6++) {
            if (iArr[i6] == 0) {
                data.origPtr = i6;
                return;
            }
        }
    }

    public final void fallbackSort(BZip2CompressorOutputStream.Data data, int i5) {
        byte[] bArr = data.block;
        int i6 = i5 + 1;
        bArr[0] = bArr[i6];
        fallbackSort(data.fmap, bArr, i6);
        for (int i7 = 0; i7 < i6; i7++) {
            int[] iArr = data.fmap;
            iArr[i7] = iArr[i7] - 1;
        }
        for (int i8 = 0; i8 < i6; i8++) {
            int[] iArr2 = data.fmap;
            if (iArr2[i8] == -1) {
                iArr2[i8] = i5;
                return;
            }
        }
    }

    public final void mainSort(BZip2CompressorOutputStream.Data data, int i5) {
        int i6;
        int i7;
        int[] iArr;
        int i8;
        int i9;
        BZip2CompressorOutputStream.Data data2 = data;
        int i10 = i5;
        int[] iArr2 = this.mainSort_runningOrder;
        int[] iArr3 = this.mainSort_copy;
        boolean[] zArr = this.mainSort_bigDone;
        int[] iArr4 = this.ftab;
        byte[] bArr = data2.block;
        int[] iArr5 = data2.fmap;
        char[] cArr = this.quadrant;
        int i11 = this.workLimit;
        boolean z6 = this.firstAttempt;
        int i12 = 65537;
        while (true) {
            i12--;
            if (i12 < 0) {
                break;
            } else {
                iArr4[i12] = 0;
            }
        }
        for (int i13 = 0; i13 < 20; i13++) {
            bArr[i10 + i13 + 2] = bArr[(i13 % (i10 + 1)) + 1];
        }
        int i14 = i10 + 21;
        while (true) {
            i14--;
            if (i14 < 0) {
                break;
            } else {
                cArr[i14] = 0;
            }
        }
        int i15 = i10 + 1;
        byte b = bArr[i15];
        bArr[0] = b;
        int i16 = 255;
        int i17 = b & UnsignedBytes.MAX_VALUE;
        int i18 = 0;
        while (i18 <= i10) {
            i18++;
            int i19 = bArr[i18] & UnsignedBytes.MAX_VALUE;
            int i20 = (i17 << 8) + i19;
            iArr4[i20] = iArr4[i20] + 1;
            i17 = i19;
        }
        for (int i21 = 1; i21 <= 65536; i21++) {
            iArr4[i21] = iArr4[i21] + iArr4[i21 - 1];
        }
        int i22 = bArr[1] & UnsignedBytes.MAX_VALUE;
        int i23 = 0;
        while (i23 < i10) {
            int i24 = bArr[i23 + 2] & UnsignedBytes.MAX_VALUE;
            int i25 = (i22 << 8) + i24;
            int i26 = iArr4[i25] - 1;
            iArr4[i25] = i26;
            iArr5[i26] = i23;
            i23++;
            i22 = i24;
        }
        int i27 = ((bArr[i15] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[1] & UnsignedBytes.MAX_VALUE);
        int i28 = iArr4[i27] - 1;
        iArr4[i27] = i28;
        iArr5[i28] = i10;
        int i29 = 256;
        while (true) {
            i29--;
            if (i29 < 0) {
                break;
            }
            zArr[i29] = false;
            iArr2[i29] = i29;
        }
        int i30 = 364;
        for (int i31 = 1; i30 != i31; i31 = 1) {
            i30 /= 3;
            int i32 = i30;
            while (i32 <= i16) {
                int i33 = iArr2[i32];
                int i34 = iArr4[(i33 + 1) << 8] - iArr4[i33 << 8];
                int i35 = i30 - 1;
                int i36 = iArr2[i32 - i30];
                int i37 = i32;
                while (true) {
                    i9 = i30;
                    if (iArr4[(i36 + 1) << 8] - iArr4[i36 << 8] <= i34) {
                        break;
                    }
                    iArr2[i37] = i36;
                    int i38 = i37 - i9;
                    if (i38 <= i35) {
                        i37 = i38;
                        break;
                    } else {
                        i36 = iArr2[i38 - i9];
                        i37 = i38;
                        i30 = i9;
                    }
                }
                iArr2[i37] = i33;
                i32++;
                i30 = i9;
                i16 = 255;
            }
        }
        int i39 = i16;
        int i40 = 0;
        while (i40 <= i39) {
            int i41 = iArr2[i40];
            int i42 = 0;
            while (true) {
                i6 = CLEARMASK;
                if (i42 <= i39) {
                    int i43 = (i41 << 8) + i42;
                    int i44 = iArr4[i43];
                    if ((i44 & 2097152) != 2097152) {
                        int i45 = i42;
                        int i46 = i44 & CLEARMASK;
                        int i47 = (iArr4[i43 + 1] & CLEARMASK) - 1;
                        if (i47 > i46) {
                            i8 = 2097152;
                            i7 = i45;
                            iArr = iArr2;
                            mainQSort3(data2, i46, i47, 2, i10);
                            if (z6 && this.workDone > i11) {
                                return;
                            }
                        } else {
                            i7 = i45;
                            i8 = 2097152;
                            iArr = iArr2;
                        }
                        iArr4[i43] = i44 | i8;
                    } else {
                        i7 = i42;
                        iArr = iArr2;
                    }
                    i42 = i7 + 1;
                    data2 = data;
                    i10 = i5;
                    iArr2 = iArr;
                    i39 = 255;
                }
            }
            int[] iArr6 = iArr2;
            for (int i48 = 0; i48 <= 255; i48++) {
                iArr3[i48] = iArr4[(i48 << 8) + i41] & CLEARMASK;
            }
            int i49 = i41 << 8;
            int i50 = iArr4[i49] & CLEARMASK;
            int i51 = (i41 + 1) << 8;
            int i52 = iArr4[i51] & CLEARMASK;
            while (i50 < i52) {
                int i53 = iArr5[i50];
                int i54 = i6;
                int i55 = bArr[i53] & UnsignedBytes.MAX_VALUE;
                if (!zArr[i55]) {
                    iArr5[iArr3[i55]] = i53 == 0 ? i5 : i53 - 1;
                    iArr3[i55] = iArr3[i55] + 1;
                }
                i50++;
                i6 = i54;
            }
            int i56 = i6;
            int i57 = 256;
            while (true) {
                i57--;
                if (i57 < 0) {
                    break;
                }
                int i58 = (i57 << 8) + i41;
                iArr4[i58] = iArr4[i58] | 2097152;
            }
            zArr[i41] = true;
            if (i40 < 255) {
                int i59 = iArr4[i49] & i56;
                int i60 = (iArr4[i51] & i56) - i59;
                int i61 = 0;
                while ((i60 >> i61) > 65534) {
                    i61++;
                }
                for (int i62 = 0; i62 < i60; i62++) {
                    int i63 = iArr5[i59 + i62];
                    char c = (char) (i62 >> i61);
                    cArr[i63] = c;
                    if (i63 < 20) {
                        cArr[i63 + i5 + 1] = c;
                    }
                }
            }
            i40++;
            data2 = data;
            i10 = i5;
            iArr2 = iArr6;
            i39 = 255;
        }
    }

    public final void fallbackSort(int[] iArr, byte[] bArr, int i5) {
        int i6;
        int[] iArr2 = new int[257];
        int[] eclass = getEclass();
        for (int i7 = 0; i7 < i5; i7++) {
            eclass[i7] = 0;
        }
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = bArr[i8] & UnsignedBytes.MAX_VALUE;
            iArr2[i9] = iArr2[i9] + 1;
        }
        for (int i10 = 1; i10 < 257; i10++) {
            iArr2[i10] = iArr2[i10] + iArr2[i10 - 1];
        }
        for (int i11 = 0; i11 < i5; i11++) {
            int i12 = bArr[i11] & UnsignedBytes.MAX_VALUE;
            int i13 = iArr2[i12] - 1;
            iArr2[i12] = i13;
            iArr[i13] = i11;
        }
        BitSet bitSet = new BitSet(i5 + 64);
        for (int i14 = 0; i14 < 256; i14++) {
            bitSet.set(iArr2[i14]);
        }
        for (int i15 = 0; i15 < 32; i15++) {
            int i16 = (i15 * 2) + i5;
            bitSet.set(i16);
            bitSet.clear(i16 + 1);
        }
        int i17 = 1;
        do {
            int i18 = 0;
            for (int i19 = 0; i19 < i5; i19++) {
                if (bitSet.get(i19)) {
                    i18 = i19;
                }
                int i20 = iArr[i19] - i17;
                if (i20 < 0) {
                    i20 += i5;
                }
                eclass[i20] = i18;
            }
            int iNextSetBit = -1;
            i6 = 0;
            while (true) {
                int iNextClearBit = bitSet.nextClearBit(iNextSetBit + 1);
                int i21 = iNextClearBit - 1;
                if (i21 >= i5 || (iNextSetBit = bitSet.nextSetBit(iNextClearBit + 1) - 1) >= i5) {
                    break;
                }
                if (iNextSetBit > i21) {
                    i6 += (iNextSetBit - i21) + 1;
                    fallbackQSort3(iArr, eclass, i21, iNextSetBit);
                    int i22 = -1;
                    while (i21 <= iNextSetBit) {
                        int i23 = eclass[iArr[i21]];
                        if (i22 != i23) {
                            bitSet.set(i21);
                            i22 = i23;
                        }
                        i21++;
                    }
                }
            }
            i17 *= 2;
            if (i17 > i5) {
                return;
            }
        } while (i6 != 0);
    }
}
